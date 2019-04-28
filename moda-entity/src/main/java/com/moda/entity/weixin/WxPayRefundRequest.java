package com.moda.entity.weixin;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * 微信支付申请退款请求
 *
 * @author lyh
 * @version 1.0 2016-06-06
 *
 */
@XmlRootElement(name = "xml")
public class WxPayRefundRequest extends BasePayXmlRequest {
	private static final long serialVersionUID = 6869203538791093529L;
	private String transaction_id;// 微信订单号
	private String out_refund_no;// 商户退款单号
	private int total_fee;// 总金额
	private int refund_fee;// 退款金额
	private String refund_fee_type;// 货币种类
	private String op_user_id;// 操作员
	private String notify_url;// 回调地址

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

	public int getTotal_fee() {
		return total_fee;
	}

	public void setTotal_fee(int total_fee) {
		this.total_fee = total_fee;
	}

	public int getRefund_fee() {
		return refund_fee;
	}

	public void setRefund_fee(int refund_fee) {
		this.refund_fee = refund_fee;
	}

	public String getRefund_fee_type() {
		return refund_fee_type;
	}

	public void setRefund_fee_type(String refund_fee_type) {
		this.refund_fee_type = refund_fee_type;
	}

	public String getOp_user_id() {
		return op_user_id;
	}

	public void setOp_user_id(String op_user_id) {
		this.op_user_id = op_user_id;
	}

	public String getNotify_url() {
		return notify_url;
	}

	public void setNotify_url(String notify_url) {
		this.notify_url = notify_url;
	}
}
