package com.moda.entity.weixin;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * 微信普通文本消息响应类
 *
 * @author lyh
 * @version 1.0 2016-10-10
 *
 */
@XmlRootElement(name = "xml")
public class WxTextMessageResponse extends BaseMessageXmlResponse {
	private static final long serialVersionUID = 1396770480578540714L;
	private String content;// 文本消息内容
	private KfTransInfo fTransInfo;

	@XmlElement(name = "Content")
	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@XmlElement(name = "TransInfo")
	public KfTransInfo getfTransInfo() {
		return fTransInfo;
	}

	public void setfTransInfo(KfTransInfo fTransInfo) {
		this.fTransInfo = fTransInfo;
	}
}
