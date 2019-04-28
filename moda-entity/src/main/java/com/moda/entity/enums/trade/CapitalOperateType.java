package com.moda.entity.enums.trade;

import com.moda.entity.enums.BaseEnum;
import com.moda.entity.enums.EnumConverter;

/**
 * 资金操作类型
 *
 * @author lyh
 * @version 2019-1-9 16:37:36
 */
public enum CapitalOperateType implements BaseEnum {
    /**
     * 在原有资金的基础上存入金额
     */
    IN(1, "收入"),
    /**
     * 在原有资金的基础上消费金额
     */
    OUT(2, "支出");

    private Integer value;
    private String text;

    CapitalOperateType(Integer value, String text) {
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

    public static CapitalOperateType valueOf(Integer value) {
        return EnumConverter.valueOf(CapitalOperateType.class, value);
    }
}
