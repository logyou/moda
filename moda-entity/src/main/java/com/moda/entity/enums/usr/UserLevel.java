package com.moda.entity.enums.usr;

import com.moda.entity.enums.BaseEnum;
import com.moda.entity.enums.EnumConverter;

/**
 * 用户级别
 *
 * @author lyh
 * @version 2018-10-2
 */
public enum UserLevel implements BaseEnum {
    /**
     * 系统用户
     */
    SYSTEM(1, "系统用户"),
    /**
     * 普通用户
     */
    NORMAL(2, "普通用户");

    private Integer value;
    private String text;

    UserLevel(Integer value, String text) {
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

    public static UserLevel valueOf(Integer value) {
        return EnumConverter.valueOf(UserLevel.class, value);
    }
}
