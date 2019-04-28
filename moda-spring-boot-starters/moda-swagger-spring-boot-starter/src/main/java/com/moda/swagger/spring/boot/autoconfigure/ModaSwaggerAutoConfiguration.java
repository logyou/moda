package com.moda.swagger.spring.boot.autoconfigure;

import com.github.xiaoymin.swaggerbootstrapui.annotations.EnableSwaggerBootstrapUI;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author lyh
 * @date 2019/04/26 0026 23:13
 **/
@Configuration
@EnableSwagger2
@EnableSwaggerBootstrapUI
@EnableConfigurationProperties(ModaSwaggerProperties.class)
@ConditionalOnClass(name = {
        "springfox.documentation.swagger2.annotations.EnableSwagger2",
        "com.github.xiaoymin.swaggerbootstrapui.annotations.EnableSwaggerBootstrapUI"
})
@ConditionalOnProperty(prefix = "swagger", value = "enable", havingValue = "true")
public class ModaSwaggerAutoConfiguration {
    private Logger logger = LoggerFactory.getLogger(ModaSwaggerAutoConfiguration.class);
    @Autowired
    private ModaSwaggerProperties modaSwaggerProperties;

    @Bean
    public Docket docket() {
        logger.info("Init SwaggerConfig.docket...");
        logger.info(modaSwaggerProperties.getBasePackage() + ":" + modaSwaggerProperties.isEnable());
        return new Docket(DocumentationType.SWAGGER_2)
                .enable(modaSwaggerProperties.isEnable())
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage(modaSwaggerProperties.getBasePackage()))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        logger.info("Init SwaggerConfig.apiInfo...");
        return new ApiInfoBuilder()
                .title(modaSwaggerProperties.getTitle())
                .description(modaSwaggerProperties.getDescription())
                .termsOfServiceUrl(modaSwaggerProperties.getTermsOfServiceUrl())
                .contact(new Contact(modaSwaggerProperties.getContact().getName(), modaSwaggerProperties.getContact().getUrl(), modaSwaggerProperties.getContact().getEmail()))
                .version(modaSwaggerProperties.getVersion())
                .build();
    }
}
