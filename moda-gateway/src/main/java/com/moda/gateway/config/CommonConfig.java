package com.moda.gateway.config;

import com.moda.autoconfigure.redis.RedisAutoConfiguration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author lyh
 * @date 2019-04-22 19:24
 **/
//@Configuration
public class CommonConfig {
    private static final Logger logger = LoggerFactory.getLogger(CommonConfig.class);

    @Bean
    public RedisAutoConfiguration redisAutoConfiguration() {
        logger.info("Init redisAutoConfiguration...");
        return new RedisAutoConfiguration();
    }
}
