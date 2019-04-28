package com.moda.entity.weixin;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * 微信支付提交的订单信息
 *
 * @author lyh
 * @version 1.0 2016-05-18
 *
 */
@XmlRootElement(name = "xml")
public class WxUnifiedOrderRequest extends BasePayXmlRequest {
	private static final long serialVersionUID = -5649592359687076832L;
	private String body;// 商品描述
	private String detail;// 商品详情
	private String attach;// 附加数据
	private String fee_type;// 货币类型
	private Integer total_fee;// 总金额
	private String spbill_create_ip;// 终端IP
	private String time_start;// 交易起始时间
	private String time_expire;// 交易结束时间
	private String goods_tag;// 商品标记
	private String notify_url;// 通知地址
	private String trade_type;// 交易类型
	private String product_id;// 商品ID
	private String limit_pay;// 指定支付方式
	private String openid;// 用户标识

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	public String getAttach() {
		return attach;
	}

	public void setAttach(String attach) {
		this.attach = attach;
	}

	public String getFee_type() {
		return fee_type;
	}

	public void setFee_type(String fee_type) {
		this.fee_type = fee_type;
	}

	public Integer getTotal_fee() {
		return total_fee;
	}

	public void setTotal_fee(Integer total_fee) {
		this.total_fee = total_fee;
	}

	public String getSpbill_create_ip() {
		return spbill_create_ip;
	}

	public void setSpbill_create_ip(String spbill_create_ip) {
		this.spbill_create_ip = spbill_create_ip;
	}

	public String getTime_start() {
		return time_start;
	}

	public void setTime_start(String time_start) {
		this.time_start = time_start;
	}

	public String getTime_expire() {
		return time_expire;
	}

	public void setTime_expire(String time_expire) {
		this.time_expire = time_expire;
	}

	public String getGoods_tag() {
		return goods_tag;
	}

	public void setGoods_tag(String goods_tag) {
		this.goods_tag = goods_tag;
	}

	public String getNotify_url() {
		return notify_url;
	}

	public void setNotify_url(String notify_url) {
		this.notify_url = notify_url;
	}

	public String getTrade_type() {
		return trade_type;
	}

	public void setTrade_type(String trade_type) {
		this.trade_type = trade_type;
	}

	public String getProduct_id() {
		return product_id;
	}

	public void setProduct_id(String product_id) {
		this.product_id = product_id;
	}

	public String getLimit_pay() {
		return limit_pay;
	}

	public void setLimit_pay(String limit_pay) {
		this.limit_pay = limit_pay;
	}

	public String getOpenid() {
		return openid;
	}

	public void setOpenid(String openid) {
		this.openid = openid;
	}
}
