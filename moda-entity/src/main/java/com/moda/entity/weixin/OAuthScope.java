package com.moda.entity.weixin;

/**
 * 应用授权作用域
 * 
 * @author lyh
 * @version 1.0 2016-05-18
 *
 */
public enum OAuthScope {
	/**
	 * 不弹出授权页面，直接跳转，只能获取用户openid
	 */
	SNSAPI_BASE("snsapi_base"),
	/**
	 * 弹出授权页面，可通过openid拿到昵称、性别、所在地。并且，即使在未关注的情况下，只要用户授权，也能获取其信息
	 */
	SNSAPI_USERINFO("snsapi_userinfo");

	private String name;

	private OAuthScope(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return this.name;
	}

}
