package com.moda.gateway.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author lyh
 * @date 2019-04-18 17:42
 **/
@Configuration
public class RouteConfig {
    private static final Logger logger = LoggerFactory.getLogger(RouteConfig.class);

    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
        logger.info("Init CustomRouteLocator...");
        return builder.routes()
                .build();
    }
}
