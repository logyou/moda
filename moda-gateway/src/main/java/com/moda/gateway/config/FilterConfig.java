package com.moda.gateway.config;

import com.moda.gateway.filter.AuthAccessGatewayFilter;
import com.moda.gateway.filter.CacheRequestBodyGatewayFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author lyh
 * @date 2019-04-22 14:41
 **/
@Configuration
public class FilterConfig {
    private static final Logger logger = LoggerFactory.getLogger(FilterConfig.class);

    @Bean
    public CacheRequestBodyGatewayFilter cacheRequestBodyGatewayFilter() {
        logger.info("Init CacheRequestBodyGatewayFilter...");
        return new CacheRequestBodyGatewayFilter();
    }

    @Bean
    public AuthAccessGatewayFilter authAccessFilter() {
        logger.info("Init AuthAccessGatewayFilter...");
        return new AuthAccessGatewayFilter();
    }
}
