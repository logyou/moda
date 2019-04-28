package com.moda.entity.message;

import com.moda.entity.BaseEntity;

/**
 * 微信消息
 *
 * @author lyh
 * @version 2018-09-02
 */
public class MessageTemplate extends BaseEntity {
    /**
     * 类型
     */
    private String type;
    /**
     * 内容
     */
    private Object content;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Object getContent() {
        return content;
    }

    public void setContent(Object content) {
        this.content = content;
    }
}
