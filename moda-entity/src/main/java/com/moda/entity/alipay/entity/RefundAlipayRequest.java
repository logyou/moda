package com.moda.entity.alipay.entity;


/**
 * 支付宝退款请求类
 *
 * @author lyh
 * @version 1.0 2016-06-23
 */
public class RefundAlipayRequest extends BaseAliPayRequest {
    private static final long serialVersionUID = -4698451501268999016L;
    private String seller_email;// 卖家支付宝账号
    private String seller_user_id;// 卖家用户ID
    private String refund_date;// 退款请求时间
    private String batch_no;// 退款批次号
    private String batch_num;// 总笔数
    private String detail_data;// 单笔数据集

    public String getSeller_email() {
        return seller_email;
    }

    public void setSeller_email(String seller_email) {
        this.seller_email = seller_email;
    }

    public String getSeller_user_id() {
        return seller_user_id;
    }

    public void setSeller_user_id(String seller_user_id) {
        this.seller_user_id = seller_user_id;
    }

    public String getRefund_date() {
        return refund_date;
    }

    public void setRefund_date(String refund_date) {
        this.refund_date = refund_date;
    }

    public String getBatch_no() {
        return batch_no;
    }

    public void setBatch_no(String batch_no) {
        this.batch_no = batch_no;
    }

    public String getBatch_num() {
        return batch_num;
    }

    public void setBatch_num(String batch_num) {
        this.batch_num = batch_num;
    }

    public String getDetail_data() {
        return detail_data;
    }

    public void setDetail_data(String detail_data) {
        this.detail_data = detail_data;
    }
}