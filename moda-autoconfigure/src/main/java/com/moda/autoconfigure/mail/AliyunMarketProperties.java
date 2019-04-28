package com.moda.autoconfigure.mail;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * 阿里云市场配置信息
 * Created by lyh on 2017/3/26/026.
 */
@ConfigurationProperties(prefix = "aliyun.market")
public class AliyunMarketProperties {
    private String appCode;//阿里云市场的AppCode

    public String getAppCode() {
        return appCode;
    }

    public void setAppCode(String appCode) {
        this.appCode = appCode;
    }
}
