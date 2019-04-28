package com.moda.entity.weixin;

/**
 * 用于微信支付请求基类
 *
 * @author lyh
 * @version 1.0 2016-05-18
 */
public class BasePayXmlRequest extends BaseXmlRequest {
    private static final long serialVersionUID = 6058001911476452058L;
    private String appid;// 公众账号ID
    private String mch_id;// 商户号
    private String device_info;// 设备号
    private String nonce_str;// 随机字符串
    private String sign;// 签名
    private String out_trade_no;// 商户订单号

    public String getAppid() {
        return appid;
    }

    public void setAppid(String appid) {
        this.appid = appid;
    }

    public String getMch_id() {
        return mch_id;
    }

    public void setMch_id(String mch_id) {
        this.mch_id = mch_id;
    }

    public String getDevice_info() {
        return device_info;
    }

    public void setDevice_info(String device_info) {
        this.device_info = device_info;
    }

    public String getNonce_str() {
        return nonce_str;
    }

    public void setNonce_str(String nonce_str) {
        this.nonce_str = nonce_str;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public String getOut_trade_no() {
        return out_trade_no;
    }

    public void setOut_trade_no(String out_trade_no) {
        this.out_trade_no = out_trade_no;
    }
}
