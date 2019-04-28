package com.moda.entity.alipay.entity;

import java.io.Serializable;

/**
 * Created by lyh on 2017/5/4/004.
 */
public class ApAccount implements Serializable {
    private String partnerId;//支付宝合作ID
    private String apiKey;//支付宝API密钥
    private String email;//支付宝邮箱
    private String appId;//应用id
    private String privateKey;//密钥
    private String publicKey;//公钥

    public String getPartnerId() {
        return partnerId;
    }

    public void setPartnerId(String partnerId) {
        this.partnerId = partnerId;
    }

    public String getApiKey() {
        return apiKey;
    }

    public void setApiKey(String apiKey) {
        this.apiKey = apiKey;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getPrivateKey() {
        return privateKey;
    }

    public void setPrivateKey(String privateKey) {
        this.privateKey = privateKey;
    }

    public String getPublicKey() {
        return publicKey;
    }

    public void setPublicKey(String publicKey) {
        this.publicKey = publicKey;
    }
}
