package com.moda.entity.weixin;

import java.io.Serializable;

/**
 * 微信公众号信息
 *
 * @author lyh
 * @version 1.1 2016-10-31
 */
public class WxAccount implements Serializable {
	private static final long serialVersionUID = -6315146640254918207L;
	private String account;// 公众号账号
	private String appId;// 公众号应用ID
	private String appSecret;// 公众号应用密钥
	private String mchId;// 公众号商户号
	private String apiSecret;// 公众号微信支付API密钥
	private String apiCert;// 公众号微信支付API证书

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getAppId() {
		return appId;
	}

	public void setAppId(String appId) {
		this.appId = appId;
	}

	public String getAppSecret() {
		return appSecret;
	}

	public String getMchId() {
		return mchId;
	}

	public void setMchId(String mchId) {
		this.mchId = mchId;
	}

	public String getApiSecret() {
		return apiSecret;
	}

	public void setApiSecret(String apiSecret) {
		this.apiSecret = apiSecret;
	}

	public void setAppSecret(String appSecret) {
		this.appSecret = appSecret;
	}

	public String getApiCert() {
		return apiCert;
	}

	public void setApiCert(String apiCert) {
		this.apiCert = apiCert;
	}
}