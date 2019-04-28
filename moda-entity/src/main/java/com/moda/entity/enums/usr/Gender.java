package com.moda.entity.enums.usr;

import com.moda.entity.enums.BaseEnum;
import com.moda.entity.enums.EnumConverter;

/**
 * 性别
 *
 * @author lyh
 * @version 2019-1-15 16:01:17
 */
public enum Gender implements BaseEnum {
    /**
     * 保密
     */
    SECRET(0, "保密"),
    /**
     * 男
     */
    MALE(1, "男"),
    /**
     * 女
     */
    FEMALE(2, "女");

    private Integer value;
    private String text;

    Gender(Integer value, String text) {
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

    public static Gender valueOf(Integer value) {
        return EnumConverter.valueOf(Gender.class, value);
    }
}
