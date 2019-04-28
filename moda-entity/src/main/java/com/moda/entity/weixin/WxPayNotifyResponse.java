package com.moda.entity.weixin;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * 微信支付回调响应结果
 *
 * @author lyh
 * @version 1.0 2016-06-03
 *
 */
@XmlRootElement(name = "xml")
public class WxPayNotifyResponse extends BasePayXmlResponse {
	private static final long serialVersionUID = 6095620380884408469L;
	private String openid;// 用户标识
	private String is_subscribe;// 用户是否关注公众账号，Y-关注，N-未关注，仅在公众账号类型支付有效
	private String trade_type;// 交易类型，JSAPI、NATIVE、APP
	private String bank_type;// 付款银行
	private int total_fee;// 订单总金额，单位为分
	private int settlement_total_fee;// 应结订单金额=订单金额-非充值代金券金额，应结订单金额<=订单金额。
	private String fee_type;// 货币类型，符合ISO4217标准的三位字母代码，默认人民币：CNY
	private int cash_fee;// 现金支付金额
	private String cash_fee_type;// 货币类型，符合ISO4217标准的三位字母代码，默认人民币：CNY
	private int coupon_fee;// 代金券金额，代金券金额<=订单金额，订单金额-代金券金额=现金支付金额
	private int coupon_count;// 代金券使用数量
	private int coupon_type_$n;// 代金券类型
	private String coupon_id_$n;// 代金券ID
	private int coupon_fee_$n;// 单个代金券支付金额
	private String transaction_id;// 微信支付订单号
	private String out_trade_no;// 商户订单号
	private String attach;// 商家数据包，原样返回
	private String time_end;// 支付完成时间

	public String getOpenid() {
		return openid;
	}

	public void setOpenid(String openid) {
		this.openid = openid;
	}

	public String getIs_subscribe() {
		return is_subscribe;
	}

	public void setIs_subscribe(String is_subscribe) {
		this.is_subscribe = is_subscribe;
	}

	public String getTrade_type() {
		return trade_type;
	}

	public void setTrade_type(String trade_type) {
		this.trade_type = trade_type;
	}

	public String getBank_type() {
		return bank_type;
	}

	public void setBank_type(String bank_type) {
		this.bank_type = bank_type;
	}

	public int getTotal_fee() {
		return total_fee;
	}

	public void setTotal_fee(int total_fee) {
		this.total_fee = total_fee;
	}

	public int getSettlement_total_fee() {
		return settlement_total_fee;
	}

	public void setSettlement_total_fee(int settlement_total_fee) {
		this.settlement_total_fee = settlement_total_fee;
	}

	public String getFee_type() {
		return fee_type;
	}

	public void setFee_type(String fee_type) {
		this.fee_type = fee_type;
	}

	public int getCash_fee() {
		return cash_fee;
	}

	public void setCash_fee(int cash_fee) {
		this.cash_fee = cash_fee;
	}

	public String getCash_fee_type() {
		return cash_fee_type;
	}

	public void setCash_fee_type(String cash_fee_type) {
		this.cash_fee_type = cash_fee_type;
	}

	public int getCoupon_fee() {
		return coupon_fee;
	}

	public void setCoupon_fee(int coupon_fee) {
		this.coupon_fee = coupon_fee;
	}

	public int getCoupon_count() {
		return coupon_count;
	}

	public void setCoupon_count(int coupon_count) {
		this.coupon_count = coupon_count;
	}

	public int getCoupon_type_$n() {
		return coupon_type_$n;
	}

	public void setCoupon_type_$n(int coupon_type_$n) {
		this.coupon_type_$n = coupon_type_$n;
	}

	public String getCoupon_id_$n() {
		return coupon_id_$n;
	}

	public void setCoupon_id_$n(String coupon_id_$n) {
		this.coupon_id_$n = coupon_id_$n;
	}

	public int getCoupon_fee_$n() {
		return coupon_fee_$n;
	}

	public void setCoupon_fee_$n(int coupon_fee_$n) {
		this.coupon_fee_$n = coupon_fee_$n;
	}

	public String getTransaction_id() {
		return transaction_id;
	}

	public void setTransaction_id(String transaction_id) {
		this.transaction_id = transaction_id;
	}

	public String getOut_trade_no() {
		return out_trade_no;
	}

	public void setOut_trade_no(String out_trade_no) {
		this.out_trade_no = out_trade_no;
	}

	public String getAttach() {
		return attach;
	}

	public void setAttach(String attach) {
		this.attach = attach;
	}

	public String getTime_end() {
		return time_end;
	}

	public void setTime_end(String time_end) {
		this.time_end = time_end;
	}

}
