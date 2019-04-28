package com.moda.autoconfigure.sys;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * 系统配置信息
 *
 * @author lyh
 * @version 2018-09-02
 */
@ConfigurationProperties(prefix = "sys")
public class SysProperties {
    /**
     * 配置文件版本号
     */
    private String version;
    /**
     * 是否开启调试（true-开启，false-关闭）
     */
    private boolean debug;
    /**
     * 接口地址
     */
    private String apiUrl;
    /**
     * 部署环境（dev、test、demo、uat、prod）
     */
    private String env;
    /**
     * 自定义日志文件夹
     */
    private String customLogFolder;

    /**
     * 通知邮件地址（多个以逗号隔开）
     */
    private String notifyMailAddress;

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public boolean isDebug() {
        return debug;
    }

    public void setDebug(boolean debug) {
        this.debug = debug;
    }

    public String getApiUrl() {
        return apiUrl;
    }

    public void setApiUrl(String apiUrl) {
        this.apiUrl = apiUrl;
    }

    public String getEnv() {
        return env;
    }

    public void setEnv(String env) {
        this.env = env;
    }

    public String getCustomLogFolder() {
        return customLogFolder;
    }

    public void setCustomLogFolder(String customLogFolder) {
        this.customLogFolder = customLogFolder;
    }

    public String getNotifyMailAddress() {
        return notifyMailAddress;
    }

    public void setNotifyMailAddress(String notifyMailAddress) {
        this.notifyMailAddress = notifyMailAddress;
    }
}
