package com.moda.entity.session;

import com.moda.entity.BaseEntity;

/**
 * 当前登录用户
 *
 * @author lyh
 * @date 2019-5-10
 */
public class CurrentUser extends BaseEntity {
    /**
     * 用户ID
     */
    protected Integer id;
    /**
     * 用户名
     */
    protected String username;
    /**
     * Access Token
     */
    protected String accessToken;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }
}
