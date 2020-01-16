package com.moda.demo;

import com.moda.autoconfigure.sys.SysProperties;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * 服务
 *
 * @author lyh
 * @version 2019-04-01 16:37:40
 */
@EnableDiscoveryClient
@SpringBootApplication
@MapperScan("com.moda.demo.dao")
@EnableConfigurationProperties(SysProperties.class)
public class DemoServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(DemoServiceApplication.class, args);
    }
}
