package com.moda.entity.enums.usr;

import com.moda.entity.enums.BaseEnum;
import com.moda.entity.enums.EnumConverter;

/**
 * 用户账户日志来源
 *
 * @author lyh
 * @version 2019-1-16 10:59:46
 */
public enum UserAccountOperateLogSource implements BaseEnum {
    /**
     * 在线充值时
     */
    CASH_EXCHANGE(3, "现金兑换"),
    /**
     * 第三方消费
     */
    THIRD_CONSUME(7, "第三方消费");

    private Integer value;
    private String text;

    UserAccountOperateLogSource(Integer value, String text) {
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

    public static UserAccountOperateLogSource valueOf(Integer value) {
        return EnumConverter.valueOf(UserAccountOperateLogSource.class, value);
    }
}
