package com.moda.entity.message.system;

import com.moda.entity.message.BaseMessage;

import java.util.Date;

/**
 * 错误信息
 *
 * @author lyh
 * @create 2018-09-02
 **/
public class ErrorMessage extends BaseMessage {
    /**
     * 错误类型
     */
    private String type;
    /**
     * 标题
     */
    private String title;
    /**
     * 系统名称
     */
    private String OSName;
    /**
     * 系统版本
     */
    private String OSVersion;
    /**
     * 系统架构
     */
    private String OSArch;
    /**
     * 产品名称
     */
    private String productName;
    /**
     * 产品版本
     */
    private String productVersion;
    /**
     * 本机名称
     */
    private String hostName;
    /**
     * 本机IP
     */
    private String hostAddress;
    /**
     * IP
     */
    private String ip;
    /**
     * 浏览器用户代理
     */
    private String userAgent;
    /**
     * 请求地址
     */
    private String requestUri;
    /**
     * 请求方法
     */
    private String method;
    /**
     * 错误信息
     */
    private String exception;
    /**
     * 发生时间
     */
    private Date createTime;
    /**
     * 参数
     */
    private String params;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductVersion() {
        return productVersion;
    }

    public void setProductVersion(String productVersion) {
        this.productVersion = productVersion;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getUserAgent() {
        return userAgent;
    }

    public void setUserAgent(String userAgent) {
        this.userAgent = userAgent;
    }

    public String getRequestUri() {
        return requestUri;
    }

    public void setRequestUri(String requestUri) {
        this.requestUri = requestUri;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getException() {
        return exception;
    }

    public void setException(String exception) {
        this.exception = exception;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getParams() {
        return params;
    }

    public void setParams(String params) {
        this.params = params;
    }

    public String getHostName() {
        return hostName;
    }

    public void setHostName(String hostName) {
        this.hostName = hostName;
    }

    public String getHostAddress() {
        return hostAddress;
    }

    public void setHostAddress(String hostAddress) {
        this.hostAddress = hostAddress;
    }

    public String getOSName() {
        return OSName;
    }

    public void setOSName(String OSName) {
        this.OSName = OSName;
    }

    public String getOSVersion() {
        return OSVersion;
    }

    public void setOSVersion(String OSVersion) {
        this.OSVersion = OSVersion;
    }

    public String getOSArch() {
        return OSArch;
    }

    public void setOSArch(String OSArch) {
        this.OSArch = OSArch;
    }
}
