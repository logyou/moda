package com.moda.entity.weixin;

/**
 * 普通 Access Token
 * 
 * @author lyh
 * @version 1.0 2016-05-17
 *
 */
public class AccessToken extends BaseExpiresJsonResponse {
	private static final long serialVersionUID = -2695884585880032206L;
	private String access_token;// 接口访问凭证

	public String getAccess_token() {
		return access_token;
	}

	public void setAccess_token(String access_token) {
		this.access_token = access_token;
	}

}
