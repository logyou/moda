package com.moda.entity.enums.usr;

import com.moda.entity.enums.BaseEnum;
import com.moda.entity.enums.EnumConverter;

/**
 * 用户类型
 *
 * @author lyh
 * @version 1.1 2015-11-23
 */
public enum UserType implements BaseEnum {
    /**
     * 用户
     */
    USER(1, "用户"),
    /**
     * 员工
     */
    STAFF(2, "员工"),
    /**
     * 系统
     */
    SYSTEM(3, "系统");

    private Integer value;
    private String text;

    UserType(Integer value, String text) {
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

    public static UserType valueOf(Integer value) {
        return EnumConverter.valueOf(UserType.class, value);
    }
}
