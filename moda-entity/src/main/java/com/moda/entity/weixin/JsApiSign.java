package com.moda.entity.weixin;

import java.util.Calendar;
import java.util.SortedMap;
import java.util.TreeMap;

/**
 * JS-SDK的页面必须先注入配置信息
 * 
 * @author lyh
 * @version 1.0 2016-05-18
 *
 */
public class JsApiSign {
	private String appId;
	private String timestamp;
	private String nonceStr;
	private String signature;

	public JsApiSign() {

	}

	public JsApiSign(String appId, String jsApiTicket, String url) {
//		String timestamp = Calendar.getInstance().getTimeInMillis()/1000L + "";
//		String nonceStr = WxSignUtils.createNoncestr();
//		SortedMap<String, Object> map = new TreeMap<String, Object>();
//		map.put("jsapi_ticket", jsApiTicket);
//		map.put("noncestr", nonceStr);
//		map.put("timestamp", timestamp);
//		map.put("url", url);
//		this.appId = appId;
//		this.nonceStr = nonceStr;
//		this.timestamp = timestamp;
//		this.signature = WxSignUtils.createJsApiSign(map);
	}

	public String getAppId() {
		return appId;
	}

	public void setAppId(String appId) {
		this.appId = appId;
	}

	public String getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}

	public String getNonceStr() {
		return nonceStr;
	}

	public void setNonceStr(String nonceStr) {
		this.nonceStr = nonceStr;
	}

	public String getSignature() {
		return signature;
	}

	public void setSignature(String signature) {
		this.signature = signature;
	}

}
