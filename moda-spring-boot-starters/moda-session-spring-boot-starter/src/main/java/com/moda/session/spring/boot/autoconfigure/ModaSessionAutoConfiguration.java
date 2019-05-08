package com.moda.session.spring.boot.autoconfigure;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Session 自动配置
 *
 * @author lyh
 * @date 2019-5-7
 */
@Configuration
@EnableConfigurationProperties({SessionContextProperties.class})
public class ModaSessionAutoConfiguration {
    private static final Logger logger = LoggerFactory.getLogger(ModaSessionAutoConfiguration.class);
    @Autowired
    private SessionContextProperties sessionContextProperties;

    @Bean
    public SessionContext sessionContext() {
        logger.info("Init SessionContext...");
        SessionContext sessionContext = new SessionContext();
        sessionContext.setSessionTimeout(sessionContextProperties.getTimeout());
        return sessionContext;
    }
}