package com.moda.entity.message.push;

/**
 * 推送用户信息消息
 */
public class PushUserInfoMessage extends PushBaseMessage {
    private Integer id;//用户id
    private String headUrl;//用户头像地址
    private String nickName;//用户昵称

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getHeadUrl() {
        return headUrl;
    }

    public void setHeadUrl(String headUrl) {
        this.headUrl = headUrl;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }
}
