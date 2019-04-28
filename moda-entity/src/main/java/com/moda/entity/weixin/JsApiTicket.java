package com.moda.entity.weixin;

/**
 * 用于调用微信JS接口的临时票据
 * 
 * @author lyh
 * @version 1.0 2016-05-17
 */
public class JsApiTicket extends BaseExpiresJsonResponse {
	private static final long serialVersionUID = -7956465890979642853L;
	private String ticket;// 接口访问凭证

	public JsApiTicket() {
	}

	public JsApiTicket(String ticket, int expiresIn) {
		this.ticket = ticket;
		this.setExpires_in(expiresIn);
	}

	public String getTicket() {
		return ticket;
	}

	public void setTicket(String ticket) {
		this.ticket = ticket;
	}

}
