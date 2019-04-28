package com.moda.entity.enums.htl;

import com.moda.entity.enums.BaseEnum;
import com.moda.entity.enums.EnumConverter;

/**
 * 宽带类型
 * @author 梁华山
 * @create 2018-10-17 16:03:09
 **/
public enum BandwidthType implements BaseEnum {
                       EXCLUSIVE_BROADBAND(1, "独享宽带"), //
                       SHARED_BROADBAND(2, "共享宽带");//

    private Integer value;
    private String  text;

    BandwidthType(Integer value, String text) {
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

    public static BandwidthType valueOf(Integer value) {
        return EnumConverter.valueOf(BandwidthType.class, value);
    }
}
