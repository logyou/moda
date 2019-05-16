package com.moda.web.spring.boot.autoconfigure;

import com.moda.autoconfigure.product.ProductProperties;
import com.moda.autoconfigure.sys.SysProperties;
import com.moda.web.spring.boot.controller.SystemController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 自定义 WEB
 *
 * @author lyh
 * @date 2019-5-16
 */
@Configuration
@EnableConfigurationProperties({ProductProperties.class, SysProperties.class})
public class ModaWebAutoConfiguration {
    private static final Logger logger = LoggerFactory.getLogger(ModaWebAutoConfiguration.class);

    @Bean
    public SystemController systemController() {
        logger.info("Init SystemController...");
        return new SystemController();
    }
}