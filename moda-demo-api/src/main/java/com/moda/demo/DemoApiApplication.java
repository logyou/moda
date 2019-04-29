package com.moda.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * Application
 *
 * @author lyh
 * @version 2019-04-02 17:36:58
 */
@EnableDiscoveryClient
@SpringBootApplication
public class DemoApiApplication {
    public static void main(String[] args) {
        SpringApplication.run(DemoApiApplication.class, args);
    }
}
