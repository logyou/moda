package com.moda.monitor.checker;

import com.moda.entity.rest.Result;
import com.moda.util.http.HttpClientUtils;
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
public class ServiceChecker {
    private final static Logger logger = LoggerFactory.getLogger(ServiceChecker.class);

    public final static Map<String, List<String>> services = new HashMap<String, List<String>>() {{
        put("moda-demo-api", Arrays.asList("localhost:21001"));
        put("moda-gateway", Arrays.asList("localhost:20001"));
        put("moda-demo-service", Arrays.asList("localhost:22001"));
    }};

    public int getStatus(String instance) {
        String url = String.format("http://%s/sys/info", instance);
        Result result = null;
        try {
            result = HttpClientUtils.postAsJson(Result.class, url, null);
        } catch (IOException e) {
            logger.error(e.getMessage());
        }
        return (result != null && result.getStatus() != null && result.getStatus() == 1) ? 1 : 0;
    }
}
