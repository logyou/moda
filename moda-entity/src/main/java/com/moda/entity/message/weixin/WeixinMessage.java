package com.moda.entity.message.weixin;

import com.moda.entity.BaseEntity;

/**
 * 模板消息
 *
 * @author lyh
 * @create 2018/09/02 15:07
 **/
public class WeixinMessage extends BaseEntity {
    /**
     * 微信标识
     */
    private String weixinId;
    /**
     * 内容
     */
    private Object content;

    public String getWeixinId() {
        return weixinId;
    }

    public void setWeixinId(String weixinId) {
        this.weixinId = weixinId;
    }

    public Object getContent() {
        return content;
    }

    public void setContent(Object content) {
        this.content = content;
    }
}
