package com.moda.entity.message.pay;

import com.moda.entity.message.BaseMessage;

/**
 * 订单支付成功消息体
 *
 * @author lyh
 * @create 2018-11-27 14:35
 **/
public class PaidSuccessMessage extends BaseMessage {
    /**
     * 订单ID
     */
    private Integer orderId;
    /**
     * 产品类别
     */
    private Integer productCategory;

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Integer getProductCategory() {
        return productCategory;
    }

    public void setProductCategory(Integer productCategory) {
        this.productCategory = productCategory;
    }
}
