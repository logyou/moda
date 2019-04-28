package com.moda.entity.weixin;

/**
 * 调用微信wx.login以及jscode2session接口返回的实体信息
 *
 * @author lyh
 * @version 1.0 2018-8-8
 */
public class Jscode2session extends BaseJsonResponse {
    private String openid;
    private String session_key;
    private String unionid;

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public String getSession_key() {
        return session_key;
    }

    public void setSession_key(String session_key) {
        this.session_key = session_key;
    }

    public String getUnionid() {
        return unionid;
    }

    public void setUnionid(String unionid) {
        this.unionid = unionid;
    }
}
