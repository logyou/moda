package com.moda.entity.enums.trade;

import com.moda.entity.enums.BaseEnum;
import com.moda.entity.enums.EnumConverter;

/**
 * 腾讯的支付类型
 *
 * @author lyh
 * @version 1.0 2017-6-22
 */
public enum TenpayType  implements BaseEnum {
    JSAPI(1, "公众号支付"),
    NATIVE(2, "原生扫码支付"),
    APP(3, "APP支付"),
    MICROPAY(4, "刷卡支付");

    private Integer value;
    private String text;

    TenpayType(Integer value, String text) {
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

    public static TenpayType valueOf(Integer value) {
        return EnumConverter.valueOf(TenpayType.class, value);
    }
}