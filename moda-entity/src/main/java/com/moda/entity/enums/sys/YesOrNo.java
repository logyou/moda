package com.moda.entity.enums.sys;

import com.moda.entity.enums.BaseEnum;
import com.moda.entity.enums.EnumConverter;

/**
 * 是否状态
 *
 * @author lyh
 * @version 2018-8-31
 */
public enum YesOrNo implements BaseEnum {
    NO(0, "否"),
    YES(1, "是");

    private Integer value;
    private String text;

    YesOrNo(Integer value, String text) {
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

    public static YesOrNo valueOf(Integer value) {
        return EnumConverter.valueOf(YesOrNo.class, value);
    }
}
