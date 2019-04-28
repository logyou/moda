package com.moda.entity.enums.htl;

import com.moda.entity.enums.BaseEnum;
import com.moda.entity.enums.EnumConverter;

/**
 * 酒店精准-播放状态
 * @author 梁华山
 * @create 2019-04-10 16:03:09
 **/
public enum HotelLaunchPlayStatus implements BaseEnum {
    /**
     * 启动播放
     */
    ENABLE_PLAY(1, "启动播放"),
    /**
     * 禁止播放
     */
    DISABLE_PLAY(2, "禁止播放");

    private Integer value;
    private String text;

    HotelLaunchPlayStatus(Integer value, String text) {
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

    public static HotelLaunchPlayStatus valueOf(Integer value) {
        return EnumConverter.valueOf(HotelLaunchPlayStatus.class, value);
    }
}
