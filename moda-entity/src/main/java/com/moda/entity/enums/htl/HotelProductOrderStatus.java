package com.moda.entity.enums.htl;

import com.moda.entity.enums.BaseEnum;
import com.moda.entity.enums.EnumConverter;

/**
 * 订单状态
 *
 * @author lyh
 * @version 1.2 2018-3-13
 */
public enum HotelProductOrderStatus implements BaseEnum {
    /**
     * 待处理
     */
    PENDING(2, "待处理"),
    COMPLETE(11, "已完成"),
    Invalid(12, "已作废");

    private Integer value;
    private String text;

    HotelProductOrderStatus(Integer value, String text) {
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

    public static HotelProductOrderStatus valueOf(Integer value) {
        return EnumConverter.valueOf(HotelProductOrderStatus.class, value);
    }
}
