package com.moda.demo.tst.entity;

import com.moda.entity.persistence.entity.BaseMyBatisEntity;

/**
 * @author lyh
 * @date 2019-04-28 18:05
 **/
public class User extends BaseMyBatisEntity {
    private String nickname;
    private String mobile;

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }
}
