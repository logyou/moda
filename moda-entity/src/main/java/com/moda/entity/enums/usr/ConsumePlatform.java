package com.moda.entity.enums.usr;

import com.moda.entity.enums.BaseEnum;
import com.moda.entity.enums.EnumConverter;

/**
 * 用户账户消费订单信息的消费平台枚举
 *
 * @author lyh
 * @version 2019-1-17 15:38:01
 */
public enum ConsumePlatform implements BaseEnum {
    /**
     * 小程序
     */
    JOY_MINI_APP(1, "邸客互娱"),
    GIFT_MINI_APP(2, "一城一礼"),
    QUYUE_MINI_APP(3, "盛世美颜");

    private Integer value;
    private String text;

    ConsumePlatform(Integer value, String text) {
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

    public static ConsumePlatform valueOf(Integer value) {
        return EnumConverter.valueOf(ConsumePlatform.class, value);
    }
}
