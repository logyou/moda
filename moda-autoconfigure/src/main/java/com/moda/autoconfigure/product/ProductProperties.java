package com.moda.autoconfigure.product;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * 产品信息
 *
 * @author lyh
 * @version 2018-09-02
 */
@ConfigurationProperties(prefix = "spring.application")
public class ProductProperties {
    /**
     * 产品名称
     */
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
