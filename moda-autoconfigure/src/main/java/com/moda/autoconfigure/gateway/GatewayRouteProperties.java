package com.moda.autoconfigure.gateway;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.gateway.route.RouteDefinition;

/**
 * 网关配置信息
 *
 * @author lyh
 * @date 2019-04-22 23:44:33
 */
@ConfigurationProperties(prefix = "spring.cloud.gateway")
public class GatewayRouteProperties {
    private RouteDefinition[] routes;

    public RouteDefinition[] getRoutes() {
        return routes;
    }

    public void setRoutes(RouteDefinition[] routes) {
        this.routes = routes;
    }
}
