package com.moda.entity.enums.usr;

import com.moda.entity.enums.BaseEnum;
import com.moda.entity.enums.EnumConverter;

/**
 * 用户账户类型
 *
 * @author lyh
 * @version 2019-1-15 19:18:58
 */
public enum UserAccountType implements BaseEnum {
    /**
     * 人民币
     */
    RMB(1, "人民币"),
    /**
     * 时币
     */
    TIME_COIN(2, "时币"),
    /**
     * 糖果
     */
    SWEET(3, "糖果");

    private Integer value;
    private String text;

    UserAccountType(Integer value, String text) {
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

    public static UserAccountType valueOf(Integer value) {
        return EnumConverter.valueOf(UserAccountType.class, value);
    }
}
