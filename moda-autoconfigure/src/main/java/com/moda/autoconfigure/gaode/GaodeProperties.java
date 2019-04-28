package com.moda.autoconfigure.gaode;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * 高德相关配置
 *
 * @author lyh
 * @create 2018-9-26
 **/
@ConfigurationProperties(prefix = "gaode")
public class GaodeProperties {
    private final WebApi webApi = new WebApi();

    public WebApi getWebApi() {
        return webApi;
    }

    public static class WebApi {
        private String key;

        public String getKey() {
            return key;
        }

        public void setKey(String key) {
            this.key = key;
        }
    }
}
