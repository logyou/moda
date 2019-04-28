package com.moda.entity.enums.trade;

import com.moda.entity.enums.BaseEnum;
import com.moda.entity.enums.EnumConverter;

/**
 * 支付交易类型
 *
 * @author lyh
 * @version 2018-11-26 20:07:21
 */
public enum TradeType implements BaseEnum {
    /**
     * 支付手机网站支付或微信H5支付
     */
    WAP_PAY(1, "手机网站支付"),
    /**
     * 支付宝电脑网站支付
     */
    PC_PAY(2, "电脑网站支付"),
    /**
     * 用户用支付宝或微信扫码二维码支付
     */
    QR_CODE_PAY(3, "扫码支付"),
    /**
     * JSAPI支付（或小程序支付）
     */
    JSAPI(4, "JSAPI支付（或小程序支付）");

    private Integer value;
    private String text;

    TradeType(Integer value, String text) {
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

    public static TradeType valueOf(Integer value) {
        return EnumConverter.valueOf(TradeType.class, value);
    }
}
