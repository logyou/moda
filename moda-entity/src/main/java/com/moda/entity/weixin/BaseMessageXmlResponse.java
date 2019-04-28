package com.moda.entity.weixin;

import javax.xml.bind.annotation.XmlElement;

/**
 * 基础消息基类
 *
 * @author lyh
 * @version 1.0 2016-10-10
 */
public class BaseMessageXmlResponse extends BaseXmlResponse {
    private static final long serialVersionUID = 2017807731205933503L;
    private String toUserName;// 接收方
    private String fromUserName;// 发送方
    private long createTime;// 创建时间
    private String msgType;// 消息类型
    private Long msgId;// 消息id，64位整型

    @XmlElement(name = "ToUserName")
    public String getToUserName() {
        return toUserName;
    }

    public void setToUserName(String toUserName) {
        this.toUserName = toUserName;
    }

    @XmlElement(name = "FromUserName")
    public String getFromUserName() {
        return fromUserName;
    }

    public void setFromUserName(String fromUserName) {
        this.fromUserName = fromUserName;
    }

    @XmlElement(name = "CreateTime")
    public long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(long createTime) {
        this.createTime = createTime;
    }

    @XmlElement(name = "MsgType")
    public String getMsgType() {
        return msgType;
    }

    public void setMsgType(String msgType) {
        this.msgType = msgType;
    }

    @XmlElement(name = "MsgId")
    public Long getMsgId() {
        return msgId;
    }

    public void setMsgId(Long msgId) {
        this.msgId = msgId;
    }
}
