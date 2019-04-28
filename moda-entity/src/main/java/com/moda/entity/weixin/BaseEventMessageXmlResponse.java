package com.moda.entity.weixin;

import javax.xml.bind.annotation.XmlElement;

/**
 * 微信事件消息响应基类
 *
 * @author lyh
 *
 */
public class BaseEventMessageXmlResponse extends BaseMessageXmlResponse {
	private static final long serialVersionUID = -1688293831914147124L;
	private String event;// 事件类型，CLICK
	private String eventKey;// 事件KEY值，与自定义菜单接口中KEY值对应

	@XmlElement(name = "Event")
	public String getEvent() {
		return event;
	}

	public void setEvent(String event) {
		this.event = event;
	}

	@XmlElement(name = "EventKey")
	public String getEventKey() {
		return eventKey;
	}

	public void setEventKey(String eventKey) {
		this.eventKey = eventKey;
	}
}
