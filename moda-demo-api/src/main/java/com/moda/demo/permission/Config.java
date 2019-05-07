package com.moda.demo.permission;

import com.moda.util.spring.SpringContextHolder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * @author lyh
 * @date 2019/05/07 0007
 **/
@Configuration
@Import(SpringContextHolder.class)
public class Config {

    @Bean
    public AuthenticationProvider authenticationProvider() {
        return new AuthenticationProvider();
    }
}
