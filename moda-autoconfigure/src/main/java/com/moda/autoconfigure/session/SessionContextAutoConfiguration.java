package com.moda.autoconfigure.session;

import com.moda.autoconfigure.redis.RedisProperties;
import com.moda.util.mapper.JsonMapper;
import com.moda.util.session.SessionContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 会话上下文初始化配置
 *
 * @author lyh
 * @version 2018-08-31 00:13:03
 */
@Configuration
@EnableConfigurationProperties({SessionContextProperties.class, RedisProperties.class})
public class SessionContextAutoConfiguration {
    @Autowired
    private SessionContextProperties configProperties;
    @Autowired
    private RedisProperties redisProperties;
    private static Logger logger = LoggerFactory.getLogger(SessionContextAutoConfiguration.class);

    @Bean
    public SessionContext sessionContext() {
        logger.debug("Init SessionContext...");
        SessionContext sessionContext = new SessionContext();
        sessionContext.setSessionTimeout(configProperties.getTimeout());
        sessionContext.setRedisKeyPrefix(redisProperties.getPrefix());
        logger.debug(JsonMapper.toJsonString(sessionContext));
        return sessionContext;
    }
}
