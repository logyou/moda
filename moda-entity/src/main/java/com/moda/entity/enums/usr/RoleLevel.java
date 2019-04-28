package com.moda.entity.enums.usr;

import com.moda.entity.enums.BaseEnum;
import com.moda.entity.enums.EnumConverter;

/**
 * 角色级别
 *
 * @author lyh
 * @version 2018-10-2
 */
public enum RoleLevel implements BaseEnum {
    /**
     * 系统角色
     */
    SYSTEM(1, "系统角色"),
    /**
     * 普通角色
     */
    NORMAL(2, "普通角色");

    private Integer value;
    private String text;

    RoleLevel(Integer value, String text) {
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

    public static RoleLevel valueOf(Integer value) {
        return EnumConverter.valueOf(RoleLevel.class, value);
    }
}
