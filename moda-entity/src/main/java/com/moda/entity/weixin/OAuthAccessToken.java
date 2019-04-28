package com.moda.entity.weixin;

/**
 * 网页授权 access token
 * 
 * @author lyh
 * @version 1.0 2016-05-17
 *
 */
public class OAuthAccessToken extends AccessToken {
	private static final long serialVersionUID = 8505189817780675172L;
	private String refresh_token;// 用户刷新access_token
	private String openid;// 用户唯一标识
	private String scope;// 用户授权的作用域

	public String getRefresh_token() {
		return refresh_token;
	}

	public void setRefresh_token(String refresh_token) {
		this.refresh_token = refresh_token;
	}

	public String getOpenid() {
		return openid;
	}

	public void setOpenid(String openid) {
		this.openid = openid;
	}

	public String getScope() {
		return scope;
	}

	public void setScope(String scope) {
		this.scope = scope;
	}

}
