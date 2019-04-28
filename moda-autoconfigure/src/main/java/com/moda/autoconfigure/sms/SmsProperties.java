package com.moda.autoconfigure.sms;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * 短信配置
 * Created by lyh on 2017/3/26/026.
 */
@ConfigurationProperties(prefix = "sms")
public class SmsProperties {
    private String apiKey;

    public String getApiKey() {
        return apiKey;
    }

    public void setApiKey(String apiKey) {
        this.apiKey = apiKey;
    }
}
