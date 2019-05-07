package com.moda.session.spring.boot.autoconfigure;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * 配置文件
 *
 * @author lyh
 * @date 2019-05-07
 */
@ConfigurationProperties(prefix = "session")
public class SessionContextProperties {
    /**
     * Session 有效期（秒）
     */
    private Integer timeout = 72000;

    public Integer getTimeout() {
        return timeout;
    }

    public void setTimeout(Integer timeout) {
        this.timeout = timeout;
    }
}
