package com.moda.entity.message.system;

import com.moda.entity.message.BaseMessage;

import java.util.Map;

/**
 * 手机短信
 *
 * @author lyh
 * @version 2018-8-29 18:08:27
 */
public class MobileMessage extends BaseMessage {
    /**
     * 手机号
     */
    private String mobile;
    /**
     * 内容
     */
    private String content;
    /**
     * 参数
     */
    private Map<String, Object> params;

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Map<String, Object> getParams() {
        return params;
    }

    public void setParams(Map<String, Object> params) {
        this.params = params;
    }
}
