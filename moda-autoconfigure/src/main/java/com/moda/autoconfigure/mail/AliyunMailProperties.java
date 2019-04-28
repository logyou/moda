package com.moda.autoconfigure.mail;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * 阿里云邮件配置信息
 * Created by lyh on 2017/3/26/026.
 */
@ConfigurationProperties(prefix = "aliyun.mail")
public class AliyunMailProperties {
    private String regionId;//机房信息
    private String accessKeyID;//密钥ID
    private String accessKeySecret;//密钥密码
    private String accountName;//管理控制台中配置的发信地址
    private String fromAlias;//发信人昵称
    private String tagName;//邮件标签

    public String getAccessKeyID() {
        return accessKeyID;
    }

    public void setAccessKeyID(String accessKeyID) {
        this.accessKeyID = accessKeyID;
    }

    public String getAccessKeySecret() {
        return accessKeySecret;
    }

    public void setAccessKeySecret(String accessKeySecret) {
        this.accessKeySecret = accessKeySecret;
    }

    public String getRegionId() {
        return regionId;
    }

    public void setRegionId(String regionId) {
        this.regionId = regionId;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getFromAlias() {
        return fromAlias;
    }

    public void setFromAlias(String fromAlias) {
        this.fromAlias = fromAlias;
    }

    public String getTagName() {
        return tagName;
    }

    public void setTagName(String tagName) {
        this.tagName = tagName;
    }
}
