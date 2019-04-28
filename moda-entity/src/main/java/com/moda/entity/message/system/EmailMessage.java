package com.moda.entity.message.system;

import com.moda.entity.message.BaseMessage;

/**
 * 邮件信息
 *
 * @author lyh
 * @version 2018-8-29 18:06:29
 */
public class EmailMessage extends BaseMessage {
    /**
     * 收件人，多个以逗号隔开
     */
    private String toAddress;
    /**
     * 主题
     */
    private String subject;
    /**
     * 内容
     */
    private String content;

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getToAddress() {
        return toAddress;
    }

    public void setToAddress(String toAddress) {
        this.toAddress = toAddress;
    }
}
