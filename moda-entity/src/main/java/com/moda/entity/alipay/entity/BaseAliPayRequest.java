package com.moda.entity.alipay.entity;

import java.io.Serializable;

/**
 * 支付宝支付请求基础类
 *
 * @author lyh
 * @version 1.0 2016-06-23
 *
 */
public class BaseAliPayRequest implements Serializable {
	private static final long serialVersionUID = -336302290538377300L;
	private String service;// 接口名称
	private String partner;// 合作者身份ID
	private String _input_charset;// 参数编码字符集
	private String sign_type;// 签名方式
	private String sign;// 签名
	private String notify_url;// 服务器异步通知页面路径

	public String getService() {
		return service;
	}

	public void setService(String service) {
		this.service = service;
	}

	public String getPartner() {
		return partner;
	}

	public void setPartner(String partner) {
		this.partner = partner;
	}

	public String get_input_charset() {
		return _input_charset;
	}

	public void set_input_charset(String _input_charset) {
		this._input_charset = _input_charset;
	}

	public String getSign_type() {
		return sign_type;
	}

	public void setSign_type(String sign_type) {
		this.sign_type = sign_type;
	}

	public String getSign() {
		return sign;
	}

	public void setSign(String sign) {
		this.sign = sign;
	}

	public String getNotify_url() {
		return notify_url;
	}

	public void setNotify_url(String notify_url) {
		this.notify_url = notify_url;
	}
}
