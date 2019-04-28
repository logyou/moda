package com.moda.entity.weixin;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * 微信支付申请退款回调响应结果
 *
 * @author lyh
 * @version 1.0 2016-06-06
 */
@XmlRootElement(name = "xml")
public class WxPayRefundNotifyResponse extends BasePayXmlResponse {
    private String req_info;//加密信息

    public String getReq_info() {
        return req_info;
    }

    public void setReq_info(String req_info) {
        this.req_info = req_info;
    }
}
