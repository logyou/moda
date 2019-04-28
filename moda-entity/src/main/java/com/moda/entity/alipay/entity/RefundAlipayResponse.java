package com.moda.entity.alipay.entity;

import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

/**
 * 支付宝退款响应类
 *
 * @author thinkpad
 */
@XmlRootElement(name = "alipay")
public class RefundAlipayResponse implements Serializable {
    private static final long serialVersionUID = 7914096648540095807L;
    private String is_success;// 是否成功（T-成功，F-失败）
    private String error;// 错误信息

    public String getIs_success() {
        return is_success;
    }

    public void setIs_success(String is_success) {
        this.is_success = is_success;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
}
