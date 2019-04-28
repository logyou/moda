package com.moda.autoconfigure.weixin;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * 微信配置属性
 * Created by lyh on 2017/3/27/027.
 */
@ConfigurationProperties(prefix = "weixin")
public class WeixinProperties {
    private String weixinId;

    public String getWeixinId() {
        return weixinId;
    }

    public void setWeixinId(String weixinId) {
        this.weixinId = weixinId;
    }
}
