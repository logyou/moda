package com.moda.gateway.filter;

import com.alibaba.fastjson.JSONObject;
import com.moda.entity.rest.Result;
import com.moda.entity.rest.Status;
import com.moda.autoconfigure.gateway.GatewayProperties;
import com.moda.gateway.util.AuthAccessUtils;
import org.bouncycastle.util.Strings;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.core.io.buffer.DataBufferUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.concurrent.atomic.AtomicReference;

/**
 * 全局网关过滤器
 * 验证请求签名
 *
 * @author lyh
 * @date 2019-4-22 17:39:20
 **/
public class AuthAccessGatewayFilter implements GlobalFilter, Ordered {
    private static final Logger logger = LoggerFactory.getLogger(AuthAccessGatewayFilter.class);
    @Autowired
    private AuthAccessUtils authAccessUtils;
    @Autowired
    private GatewayProperties gatewayProperties;

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        //响应状态始终为OK
        exchange.getResponse().setStatusCode(HttpStatus.OK);
        //响应类型为JSON
        exchange.getResponse().getHeaders().add(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_UTF8_VALUE);
        //获取通过POST方式提交Body
        Flux<DataBuffer> cachedBody = exchange.getAttribute(CacheRequestBodyGatewayFilter.CACHE_REQUEST_BODY_OBJECT_KEY);
        if (gatewayProperties.isAuthAccess()) {
            //验证签名是否合法
            Result result = authAccessUtils.checkAccess(exchange.getRequest().getURI().toString(), toRaw(cachedBody));
            if (Status.SUCCESS != result.getStatus()) {
                //校验失败
                return exchange.getResponse().writeWith(Flux.just(getBodyBuffer(exchange.getResponse(), result)));
            }
        } else {
            logger.info(exchange.getRequest().getURI().toString() + System.lineSeparator() + toRaw(cachedBody));
        }
        //校验通过
        return chain.filter(exchange);
    }

    @Override
    public int getOrder() {
        return Ordered.HIGHEST_PRECEDENCE + 100;
    }

    private static String toRaw(Flux<DataBuffer> body) {
        if (body == null) {
            return null;
        }
        AtomicReference<String> rawRef = new AtomicReference<>();
        body.subscribe(buffer -> {
            byte[] bytes = new byte[buffer.readableByteCount()];
            buffer.read(bytes);
            DataBufferUtils.release(buffer);
            rawRef.set(Strings.fromUTF8ByteArray(bytes));
        });
        return rawRef.get();
    }

    private static DataBuffer getBodyBuffer(ServerHttpResponse response, Result result) {
        return response.bufferFactory().wrap(JSONObject.toJSONBytes(result));
    }
}
