package com.moda.autoconfigure.gateway;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * 网关配置信息
 *
 * @author lyh
 * @date 2019-04-22 23:44:33
 */
@ConfigurationProperties(prefix = "gateway")
public class GatewayProperties {
    /**
     * 是否开启验证签名（true-开启，false-关闭）
     */
    private boolean authAccess = true;

    public boolean isAuthAccess() {
        return authAccess;
    }

    public void setAuthAccess(boolean authAccess) {
        this.authAccess = authAccess;
    }
}
