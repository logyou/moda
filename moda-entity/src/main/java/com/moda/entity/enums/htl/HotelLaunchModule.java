package com.moda.entity.enums.htl;

import com.moda.entity.enums.BaseEnum;
import com.moda.entity.enums.EnumConverter;

/**
 * 酒店精准模块
 * @author 梁华山
 * @create 2019-04-10 16:03:09
 **/
public enum HotelLaunchModule implements BaseEnum {
    /**
     * 酒店宣传
     */
    HOTEL_PUBLICITY(1, "酒店宣传"),
    /**
     * 欢迎词
     */
    HOTEL_WELCOME(2, "欢迎词");

    private Integer value;
    private String text;

    HotelLaunchModule(Integer value, String text) {
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

    public static HotelLaunchModule valueOf(Integer value) {
        return EnumConverter.valueOf(HotelLaunchModule.class, value);
    }
}
