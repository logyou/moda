package com.moda.entity.weixin;

/**
 * 微信交易类型
 * 
 * @author lyh
 * @version 1.0 2016-05-19
 *
 */
public enum TradeType {
	NATIVE("NATIVE"),
	JSAPI("JSAPI");

	private String name;

	private TradeType(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return this.name;
	}
}
