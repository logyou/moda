package com.moda.entity.enums.device;

import com.moda.entity.enums.BaseEnum;
import com.moda.entity.enums.EnumConverter;

/**
 * 盒子固件型号
 * @author 梁华山
 * @version 2018-10-07
 */
public enum BoxModel implements BaseEnum {
                                          RK322X_BOX(3, "rk322x-box"), //
                                          DK_BOX_03A(4, "DK-BOX-03A") //
    ;

    private Integer value;
    private String  text;

    BoxModel(Integer value, String text) {
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

    public static BoxModel valueOf(Integer value) {
        return EnumConverter.valueOf(BoxModel.class, value);
    }
}