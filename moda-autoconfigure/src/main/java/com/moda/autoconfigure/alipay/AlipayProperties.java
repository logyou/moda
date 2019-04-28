package com.moda.autoconfigure.alipay;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * 支付宝配置属性
 * Created by lyh on 2017/3/27/027.
 */
@ConfigurationProperties(prefix = "alipay")
public class AlipayProperties {
    private String partnerId;

    public String getPartnerId() {
        return partnerId;
    }

    public void setPartnerId(String partnerId) {
        this.partnerId = partnerId;
    }
}
