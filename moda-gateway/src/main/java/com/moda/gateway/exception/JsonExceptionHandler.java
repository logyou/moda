package com.moda.gateway.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.web.ErrorProperties;
import org.springframework.boot.autoconfigure.web.ResourceProperties;
import org.springframework.boot.autoconfigure.web.reactive.error.DefaultErrorWebExceptionHandler;
import org.springframework.boot.web.reactive.error.ErrorAttributes;
import org.springframework.context.ApplicationContext;
import org.springframework.http.HttpStatus;
import org.springframework.web.reactive.function.server.*;

import java.util.HashMap;
import java.util.Map;

/**
 * 自定义错误结果
 *
 * @author lyh
 * @date 2019-04-23 10:14
 **/
public class JsonExceptionHandler extends DefaultErrorWebExceptionHandler {
    private final static Logger logger = LoggerFactory.getLogger(JsonExceptionHandler.class);

    public JsonExceptionHandler(ErrorAttributes errorAttributes, ResourceProperties resourceProperties, ErrorProperties errorProperties, ApplicationContext applicationContext) {
        super(errorAttributes, resourceProperties, errorProperties, applicationContext);
    }

    @Override
    protected Map<String, Object> getErrorAttributes(ServerRequest request, boolean includeStackTrace) {
        Throwable error = super.getError(request);
        int status = (int) super.getErrorAttributes(request, false).getOrDefault("status", 500);
        return response(status, request, error);
    }

    @Override
    protected RouterFunction<ServerResponse> getRoutingFunction(ErrorAttributes errorAttributes) {
        return RouterFunctions.route(RequestPredicates.all(), this::renderErrorResponse);
    }

    @Override
    protected HttpStatus getHttpStatus(Map<String, Object> errorAttributes) {
        return HttpStatus.OK;
    }

    /**
     * 构建异常信息
     *
     * @param request 请求
     * @param error   异常
     * @return 错误信息
     */
    private static String buildMessage(ServerRequest request, Throwable error) {
        StringBuilder message = new StringBuilder("Failed to handle request [");
        message.append(request.methodName());
        message.append(" ");
        message.append(request.uri());
        message.append("]");
        if (error != null) {
            message.append(": ");
            message.append(error.getMessage());
        }
        return message.toString();
    }

    /**
     * 构建返回的JSON数据格式
     *
     * @param status  状态
     * @param request 请求
     * @param error   异常
     * @return 返回结果
     */
    private static Map<String, Object> response(int status, ServerRequest request, Throwable error) {
        logger.error(buildMessage(request, error));
        String message;
        switch (status) {
            case 404:
                message = "[GATEWAY]您访问的服务地址不存在，请检查后重试！";
                break;
            case 503:
                message = "[GATEWAY]系统维护中，服务暂时不可用！";
                break;
            default:
                message = "[GATEWAY]抱歉，服务器繁忙，请稍后重试！";
                break;
        }
        Map<String, Object> map = new HashMap<>(3);
        map.put("status", 0);
        map.put("message", message);
        map.put("data", null);
        return map;
    }
}
