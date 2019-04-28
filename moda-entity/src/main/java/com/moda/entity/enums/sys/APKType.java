package com.moda.entity.enums.sys;

import com.moda.entity.enums.BaseEnum;
import com.moda.entity.enums.EnumConverter;

/**
 * 盒子状态
 * @author 梁华山
 * @version 2018-10-07
 */
public enum APKType implements BaseEnum {
                                         BOX_APK(1, "电视盒子APK") //

    ;

    private Integer value;
    private String  text;

    APKType(Integer value, String text) {
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

    public static APKType valueOf(Integer value) {
        return EnumConverter.valueOf(APKType.class, value);
    }
}