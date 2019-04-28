package com.moda.entity.weixin;

/**
 * 微信二维码票据
 *
 * @author lyh
 * @version 1.0 2016-05-20
 *
 */
public class WxQrcodeResponse extends BaseJsonResponse {
	private static final long serialVersionUID = -6330854899530500452L;
	private String ticket;
	private long expire_seconds;
	private String url;

	public String getTicket() {
		return ticket;
	}

	public void setTicket(String ticket) {
		this.ticket = ticket;
	}

	public long getExpire_seconds() {
		return expire_seconds;
	}

	public void setExpire_seconds(long expire_seconds) {
		this.expire_seconds = expire_seconds;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
}
