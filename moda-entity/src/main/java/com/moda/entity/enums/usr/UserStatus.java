package com.moda.entity.enums.usr;

import com.moda.entity.enums.BaseEnum;
import com.moda.entity.enums.EnumConverter;

/**
 * 用户状态
 *
 * @author lyh
 * @version 2018-9-21
 */
public enum UserStatus implements BaseEnum {
    /**
     * 禁用
     */
    DISABLE(0, "禁用"),
    /**
     * 正常
     */
    NORMAL(1, "正常");

    private Integer value;
    private String text;

    UserStatus(Integer value, String text) {
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

    public static UserStatus valueOf(Integer value) {
        return EnumConverter.valueOf(UserStatus.class, value);
    }
}
