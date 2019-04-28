package com.moda.entity.enums.com;

import com.moda.entity.enums.BaseEnum;
import com.moda.entity.enums.EnumConverter;

/**
 * 启禁状态
 *
 * @author lyh
 * @version 2018-9-21
 */
public enum EnableStatus implements BaseEnum {
    /**
     * 禁用
     */
    DISABLED(0, "禁用"),
    /**
     * 启用
     */
    ENABLED(1, "启用");

    private Integer value;
    private String text;

    EnableStatus(Integer value, String text) {
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

    public static EnableStatus valueOf(Integer value) {
        return EnumConverter.valueOf(EnableStatus.class, value);
    }
}
