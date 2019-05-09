package com.moda.redis.spring.boot.autoconfigure;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * 初始化 Redis 配置
 *
 * @author lyh
 * @date 2019-5-9
 */
@Configuration
public class RedisAutoConfiguration {
    private static Logger logger = LoggerFactory.getLogger(RedisAutoConfiguration.class);

    @Bean
    public RedisClient redisClient() {
        logger.info("Init RedisClient...");
        return new RedisClient();
    }
}
