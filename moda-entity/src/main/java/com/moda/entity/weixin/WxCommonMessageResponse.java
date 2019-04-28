package com.moda.entity.weixin;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * 微信通用消息响应类
 *
 * @author lyh
 * @version 1.0 2016-10-10
 *
 */
@XmlRootElement(name = "xml")
public class WxCommonMessageResponse extends BaseMessageXmlResponse {
	private static final long serialVersionUID = -2758637250007008709L;
}
