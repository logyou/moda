package com.moda.session.spring.boot.autoconfigure;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Session 配置文件
 *
 * @author lyh
 * @date 2019-05-07
 */
@ConfigurationProperties(prefix = "session")
public class SessionContextProperties {
    /**
     * Session 有效期（秒）
     * 默认7200秒，即2小时
     */
    private Long timeout = 72000L;

    public Long getTimeout() {
        return timeout;
    }

    public void setTimeout(Long timeout) {
        this.timeout = timeout;
    }
}
