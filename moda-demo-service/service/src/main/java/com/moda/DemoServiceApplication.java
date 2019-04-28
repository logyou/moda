package com.moda;

import com.moda.autoconfigure.sys.SysProperties;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
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
@MapperScan("com.moda.demo")
@EnableConfigurationProperties(SysProperties.class)
public class DemoServiceApplication {
    public static void main(String[] args) {
        new SpringApplicationBuilder(DemoServiceApplication.class)
                .web(WebApplicationType.NONE)
                .run(args);
    }
}
