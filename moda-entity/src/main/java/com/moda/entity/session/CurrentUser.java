package com.moda.entity.session;

import com.moda.entity.BaseEntity;

/**
 * 当前登录用户
 *
 * @author lyh
 * @version 2018-09-20
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
     * 手机号
     */
    protected String mobile;
    /**
     * 姓名
     */
    protected String name;
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

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }
}
