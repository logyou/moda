package com.moda.entity.enums.mat;

import com.moda.entity.enums.BaseEnum;
import com.moda.entity.enums.EnumConverter;

/**
 * 素材用途
 *
 * @author lyh
 * @create 2018-09-11 13:39
 **/
public enum MaterialSource implements BaseEnum {
    SYSTEM(1, "系统"),
    HOTEL(2, "酒店"),
    AROUND(3, "周边");

    private Integer value;
    private String text;

    MaterialSource(Integer value, String text) {
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

    public static MaterialSource valueOf(Integer value) {
        return EnumConverter.valueOf(MaterialSource.class, value);
    }
}
