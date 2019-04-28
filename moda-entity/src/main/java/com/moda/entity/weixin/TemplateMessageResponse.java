package com.moda.entity.weixin;

/**
 * 发送模板消息响应结果
 * 
 * @author lyh
 * @version 1.0 2016-05-17
 *
 */
public class TemplateMessageResponse extends BaseJsonResponse {
	private static final long serialVersionUID = -6645497457818599688L;
	private long msgid;// 消息ID

	public long getMsgid() {
		return msgid;
	}

	public void setMsgid(long msgid) {
		this.msgid = msgid;
	}
}
