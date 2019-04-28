package com.moda.entity.enums.gif;

import com.moda.entity.enums.BaseEnum;
import com.moda.entity.enums.EnumConverter;

/**
 * 一城一礼商品状态
 *
 * @author lyh
 * @version 2019-2-26 20:30:13
 */
public enum CityProductStatus implements BaseEnum {
    /**
     * 一城一礼商品状态
     */
    SOLD_OUT(0, "下架"),
    PUT_AWAY(1, "上架");

    private Integer value;
    private String text;

    CityProductStatus(Integer value, String text) {
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

    public static CityProductStatus valueOf(Integer value) {
        return EnumConverter.valueOf(CityProductStatus.class, value);
    }
}
