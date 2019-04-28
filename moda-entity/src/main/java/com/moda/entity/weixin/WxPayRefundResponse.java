package com.moda.entity.weixin;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * 微信支付申请退款响应结果
 *
 * @author lyh
 * @version 1.0 2016-06-06
 *
 */
@XmlRootElement(name = "xml")
public class WxPayRefundResponse extends BasePayXmlResponse {
	private static final long serialVersionUID = -7630929602144921843L;
	private String transaction_id;// 微信订单号
	private String out_refund_no;// 商户退款单号
	private String refund_id;// 微信退款单号
	private String refund_channel;// 退款渠道
	private int refund_fee;// 申请退款金额
	private int total_fee;// 订单金额
	private int settlement_total_fee;// 应结订单金额
	private String fee_type;// 订单金额货币种类
	private int cash_fee;// 现金支付金额
	private int cash_refund_fee;// 现金退款金额

	public String getTransaction_id() {
		return transaction_id;
	}

	public void setTransaction_id(String transaction_id) {
		this.transaction_id = transaction_id;
	}

	public String getOut_refund_no() {
		return out_refund_no;
	}

	public void setOut_refund_no(String out_refund_no) {
		this.out_refund_no = out_refund_no;
	}

	public String getRefund_id() {
		return refund_id;
	}

	public void setRefund_id(String refund_id) {
		this.refund_id = refund_id;
	}

	public String getRefund_channel() {
		return refund_channel;
	}

	public void setRefund_channel(String refund_channel) {
		this.refund_channel = refund_channel;
	}

	public int getRefund_fee() {
		return refund_fee;
	}

	public void setRefund_fee(int refund_fee) {
		this.refund_fee = refund_fee;
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

	public int getCash_refund_fee() {
		return cash_refund_fee;
	}

	public void setCash_refund_fee(int cash_refund_fee) {
		this.cash_refund_fee = cash_refund_fee;
	}

}
