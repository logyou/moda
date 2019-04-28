package com.moda.entity.weixin;

import javax.xml.bind.annotation.XmlElement;

/**
 * 客服帐号
 *
 * @author lyh
 *
 */
public class KfTransInfo {
	private String kfAccount;// 客服帐号

	@XmlElement(name = "KfAccount")
	public String getKfAccount() {
		return kfAccount;
	}

	public void setKfAccount(String kfAccount) {
		this.kfAccount = kfAccount;
	}
}
