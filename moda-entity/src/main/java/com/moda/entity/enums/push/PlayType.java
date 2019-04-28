package com.moda.entity.enums.push;

import com.moda.entity.enums.BaseEnum;
import com.moda.entity.enums.EnumConverter;

/**
 * 推送消息类型
 *
 * @author lyh
 * @create 2018-10-11 20:14:34
 **/
public enum PlayType implements BaseEnum {
    /**
     * 视频消息
     */
    VIDEO(1, "视频消息"),
    /**
     * 用户消息
     */
    USER(11, "用户消息"),
    /**
     * 遥控器消息
     */
    REMOTE_CONTROL(15, "遥控器消息"),
    /**
     * 应用升级消息
     */
    APP_UPGRADE(21, "应用升级消息");

    private Integer value;
    private String text;

    PlayType(Integer value, String text) {
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

    public static PlayType valueOf(Integer value) {
        return EnumConverter.valueOf(PlayType.class, value);
    }
}
