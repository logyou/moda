package com.moda.monitor.checker;

import com.alibaba.fastjson.JSONObject;
import com.moda.entity.rest.Result;
import com.moda.util.http.HttpClientUtils;
import com.moda.util.mapper.JsonMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author lyh
 * @date 2019-05-16
 **/
@Configuration
public class NacosChecker {
    private final static Logger logger = LoggerFactory.getLogger(NacosChecker.class);

    public final static Map<String, List<String>> services = new HashMap<String, List<String>>() {{
        put("nacos", Arrays.asList("localhost:8848"));
    }};

    public int getStatus(String instance) {
        String url = String.format("http://%s/nacos/v1/ns/operator/metrics", instance);
        JSONObject result = null;
        try {
            String json = HttpClientUtils.get(url);
            result = JsonMapper.parseObject(json, JSONObject.class);
        } catch (IOException e) {
            logger.error(e.getMessage());
        }
        return (result != null
                && result.getString("status") != null
                && "UP".equalsIgnoreCase(result.getString("status")))
                ? 1 : 0;
    }
}
