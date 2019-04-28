package com.moda.autoconfigure.session;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * 配置文件
 *
 * @author lyh
 * @version 2018-08-31 00:10:58
 */
@ConfigurationProperties(prefix = "session")
public class SessionContextProperties {
    private Integer timeout;

    public Integer getTimeout() {
        return timeout;
    }

    public void setTimeout(Integer timeout) {
        this.timeout = timeout;
    }
}
