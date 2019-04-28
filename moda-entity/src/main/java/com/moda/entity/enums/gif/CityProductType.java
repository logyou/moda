package com.moda.entity.enums.gif;

import com.moda.entity.enums.BaseEnum;
import com.moda.entity.enums.EnumConverter;

/**
 * 一城一礼商品类型
 *
 * @author lyh
 * @version 2019-2-27 13:32:09
 */
public enum CityProductType implements BaseEnum {
    /**
     * 一城一礼商品类型
     */
    NORMAL(1, "常规商品"),
    LUCKY_BAG(2, "福袋");

    private Integer value;
    private String text;

    CityProductType(Integer value, String text) {
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

    public static CityProductType valueOf(Integer value) {
        return EnumConverter.valueOf(CityProductType.class, value);
    }
}
