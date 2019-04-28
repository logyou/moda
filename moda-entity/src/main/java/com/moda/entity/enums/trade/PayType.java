package com.moda.entity.enums.trade;

import com.moda.entity.enums.BaseEnum;
import com.moda.entity.enums.EnumConverter;

/**
 * 支付方式
 *
 * @author lyh
 * @version 1.4 2017-05-02
 */
public enum PayType implements BaseEnum {
    /**
     * 支付方式
     */
    ALIPAY(1, "支付宝支付"),
    WXPAY(2, "微信支付"),
    BALANCE(3, "余额抵扣"),
    BONUS(4, "红包抵扣"),
    INTEGRAL(5, "积分抵扣"),
    CARD_ACCOUNT(6, "会员卡帐户支付"),
    CASH(7, "现金支付"),
    TIME_COIN(8, "时币支付"),
    SWEET(9, "糖果支付");

    private Integer value;
    private String text;

    PayType(Integer value, String text) {
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

    public static PayType valueOf(Integer value) {
        return EnumConverter.valueOf(PayType.class, value);
    }
}