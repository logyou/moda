package com.moda.entity.message.system;

import com.moda.entity.message.BaseMessage;

/**
 * 语音消息
 *
 * @author lyh
 * @version 2019-2-18 12:23:07
 */
public class VoiceMessage extends BaseMessage {
    /**
     * 被叫号码
     */
    private String callee;
    /**
     * 文字模板Id
     */
    private Integer templateId;
    /**
     * 模板变量替换的参数(多个变量按英文逗号分开)
     */
    private String param;

    public String getCallee() {
        return callee;
    }

    public void setCallee(String callee) {
        this.callee = callee;
    }

    public Integer getTemplateId() {
        return templateId;
    }

    public void setTemplateId(Integer templateId) {
        this.templateId = templateId;
    }

    public String getParam() {
        return param;
    }

    public void setParam(String param) {
        this.param = param;
    }
}
