package com.moda.entity.weixin;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * 微信统一下单响应结果
 * 
 * @author lyh
 * @version 1.0 2016-05-20
 *
 */
@XmlRootElement(name = "xml")
public class WxUnifiedOrderResponse extends BasePayXmlResponse {
	private static final long serialVersionUID = 2832426344736756486L;
	private String trade_type;// 交易类型
	private String prepay_id;// 预支付交易会话标识
	private String code_url;// 二维码链接

	public String getTrade_type() {
		return trade_type;
	}

	public void setTrade_type(String trade_type) {
		this.trade_type = trade_type;
	}

	public String getPrepay_id() {
		return prepay_id;
	}

	public void setPrepay_id(String prepay_id) {
		this.prepay_id = prepay_id;
	}

	public String getCode_url() {
		return code_url;
	}

	public void setCode_url(String code_url) {
		this.code_url = code_url;
	}
}
