package com.moda.entity.alipay.entity;

import java.io.Serializable;

/**
 * 支付宝支付响应基础类
 *
 * @author lyh
 * @version 1.0 2016-06-23
 *
 */
public class BaseAlipayResponse implements Serializable {
	private static final long serialVersionUID = 2137570446431954045L;
	private String notify_time;// 通知时间
	private String notify_type;// 通知时间
	private String notify_id;// 通知校验ID
	private String sign_type;// 签名方式
	private String sign;// 签名

	public String getNotify_time() {
		return notify_time;
	}

	public void setNotify_time(String notify_time) {
		this.notify_time = notify_time;
	}

	public String getNotify_type() {
		return notify_type;
	}

	public void setNotify_type(String notify_type) {
		this.notify_type = notify_type;
	}

	public String getNotify_id() {
		return notify_id;
	}

	public void setNotify_id(String notify_id) {
		this.notify_id = notify_id;
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
}
