package com.moda.entity.enums.trade;

import com.moda.entity.enums.BaseEnum;
import com.moda.entity.enums.EnumConverter;

/**
 * 支付日志类型
 *
 * @author lyh
 * @version 1.1 2017-07-19
 */
public enum PayLogType implements BaseEnum {
    ORDER(1, "订单"),
    IN_STORE_GOODS(2, "店内商品"),
    IN_STORE_SERVICE(3, "店内服务"),
    INVOICE_EXPRESS_FEE(4, "发票费用"),
    BUY_MEMBERSHIP_CARD(5, "购买会员卡"),
    RECHARGE_BALANCE(6, "余额充值"),
    RECHARGE_TIME_COIN(7, "时币充值"),
    CHANGE_ROOM_ORDER(8, "换房订单"),
    OVERSTAY_ROOM_ORDER(9, "续住订单");

    private Integer value;
    private String  text;

    PayLogType(Integer value, String text) {
        this.value = value;
        this.text = text;
    }

    @Override
    public Integer value() {
        return value;
    }

    @Override
    public String text() {
        return text;
    }

    public static PayLogType valueOf(Integer value) {
        return EnumConverter.valueOf(PayLogType.class, value);
    }
}