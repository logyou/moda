package com.moda.redis.spring.boot.autoconfigure;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;


/**
 * 初始化Redis配置
 *
 * @author lyh
 * @version 1.0 2017-02-27
 */
@Configuration
@ConditionalOnClass(value = {Jedis.class, JedisPool.class})
@EnableConfigurationProperties(RedisProperties.class)
public class RedisAutoConfiguration {
    private static Logger logger = LoggerFactory.getLogger(RedisAutoConfiguration.class);
    @Autowired
    private RedisProperties redisProperties;

    @Bean
    public JedisPoolConfig jedisPoolConfig() {
        logger.info("Init JedisPoolConfig...");
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        jedisPoolConfig.setMaxIdle(redisProperties.getMaxIdle());
        jedisPoolConfig.setMaxTotal(redisProperties.getMaxTotal());
        jedisPoolConfig.setTestOnBorrow(redisProperties.isTestOnBorrow());
        return jedisPoolConfig;
    }

    @Bean
    public JedisPool jedisPool() {
        logger.info("Init JedisPool...");
        return new JedisPool(jedisPoolConfig(), redisProperties.getHost()
                , redisProperties.getPort(), redisProperties.getTimeout()
                , redisProperties.getPassword(), redisProperties.getDatabase());
    }
}
