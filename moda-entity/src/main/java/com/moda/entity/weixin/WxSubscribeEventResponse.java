package com.moda.entity.weixin;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * 关注/取消关注事件响应类
 *
 * @author lyh
 * @version 1.0 2016-10-10
 */
@XmlRootElement(name = "xml")
public class WxSubscribeEventResponse extends BaseMessageXmlResponse {
    private static final long serialVersionUID = 7347556941255728315L;
    private String event;// 事件类型，subscribe(订阅)、unsubscribe(取消订阅)
    private String eventKey;// 事件KEY值

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
