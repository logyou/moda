package com.moda.entity.enums.gif;

import com.moda.entity.enums.BaseEnum;
import com.moda.entity.enums.EnumConverter;

/**
 * 一城一礼商品包裹状态
 *
 * @author lyh
 * @version 2019-2-26 20:30:13
 */
public enum CityProductPackageStatus implements BaseEnum {
    /**
     * 一城一礼商品包裹状态
     */
    UNUSED(0, "未使用"),
    USED(1, "已使用");

    private Integer value;
    private String text;

    CityProductPackageStatus(Integer value, String text) {
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

    public static CityProductPackageStatus valueOf(Integer value) {
        return EnumConverter.valueOf(CityProductPackageStatus.class, value);
    }
}
