package com.moda.entity.enums.adv;

import com.moda.entity.enums.BaseEnum;
import com.moda.entity.enums.EnumConverter;

/**
 * 广告位类型
 *
 * @author lyh
 * @create 2018-10-14 17:11:34
 **/
public enum AdvertPlaceType implements BaseEnum {
    /**
     * 小程序端广告位
     */
    XCX(1, "小程序"),
    /**
     * 电视端广告位
     */
    TV(2, "电视");

    private Integer value;
    private String text;

    AdvertPlaceType(Integer value, String text) {
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

    public static AdvertPlaceType valueOf(Integer value) {
        return EnumConverter.valueOf(AdvertPlaceType.class, value);
    }
}
