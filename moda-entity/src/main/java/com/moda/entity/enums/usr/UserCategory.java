package com.moda.entity.enums.usr;

import com.moda.entity.enums.BaseEnum;
import com.moda.entity.enums.EnumConverter;

/**
 * 用户类别
 *
 * @author lyh
 * @version 2019-1-15 16:06:30
 */
public enum UserCategory implements BaseEnum {
    /**
     * 默认用户类别
     */
    USER(1, "普通用户"),
    /**
     * 充值购买过糖果的用户
     */
    STAFF(2, "糖果储值用户");

    private Integer value;
    private String text;

    UserCategory(Integer value, String text) {
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

    public static UserCategory valueOf(Integer value) {
        return EnumConverter.valueOf(UserCategory.class, value);
    }
}
