package com.moda.gateway;

import com.moda.autoconfigure.redis.RedisProperties;
import com.moda.autoconfigure.gateway.GatewayProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * Application
 *
 * @author lyh
 * @version 2019-4-18 17:53:01
 */
@EnableDiscoveryClient
@SpringBootApplication
@EnableConfigurationProperties({RedisProperties.class, GatewayProperties.class})
public class GatewayApplication {
    public static void main(String[] args) {
        SpringApplication.run(GatewayApplication.class, args);
    }
}
