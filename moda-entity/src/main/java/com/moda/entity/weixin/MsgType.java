package com.moda.entity.weixin;

/**
 * 消息类型：所有微信涉及到的消息类型统一管理
 */

public enum MsgType {
	Text("text"), // 文本消息
	News("news"), // 图文消息
	Location("location"), // 地理位置消息
	Image("image"), // 图片消息
	Voice("voice"), // 语音消息
	Video("video"), // 视频消息
	Event("event"), // 事件消息

	MPNEWS("mpnews"), // 群发图文消息

	TRANSFER_CUSTOMER_SERVICE("transfer_customer_service");// 消息转发到客服

	private String name;

	private MsgType(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return this.name;
	}

	public static void main(String[] args) {
		System.out.println(MsgType.TRANSFER_CUSTOMER_SERVICE);
	}
}
