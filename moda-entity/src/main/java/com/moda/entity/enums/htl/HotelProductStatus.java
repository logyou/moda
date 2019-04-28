package com.moda.entity.enums.htl;

import com.moda.entity.enums.BaseEnum;
import com.moda.entity.enums.EnumConverter;

/**
 * 酒店商品状态
 *
 * @author lyh
 * @version 1.2 2018-3-13
 */
public enum HotelProductStatus implements BaseEnum {
    /**
     * 酒店商品状态
     */
    SOLD_OUT(0, "下架"),
    PUT_AWAY(1, "上架");

    private Integer value;
    private String text;

    HotelProductStatus(Integer value, String text) {
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

    public static HotelProductStatus valueOf(Integer value) {
        return EnumConverter.valueOf(HotelProductStatus.class, value);
    }
}
