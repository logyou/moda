package com.moda.entity.weixin;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * 微信点击事件响应类
 *
 * @author lyh
 * @version 1.0 2016-10-10
 *
 */
@XmlRootElement(name = "xml")
public class WxClickMessageResponse extends BaseEventMessageXmlResponse {
	private static final long serialVersionUID = -4385834586729585578L;
}
