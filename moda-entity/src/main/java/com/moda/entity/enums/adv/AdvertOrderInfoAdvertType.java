package com.moda.entity.enums.adv;

import com.moda.entity.enums.BaseEnum;
import com.moda.entity.enums.EnumConverter;

/**
 * 广告类型
 *
 * @author lyh
 * @create 2019-1-10 15:53:29
 **/
public enum AdvertOrderInfoAdvertType implements BaseEnum {
    AROUND(1, "周边广告"),
    CPT(2, "CPT广告"),
    CPM(3, "CPM广告"),
    CPC(4, "CPC广告");

    private Integer value;
    private String text;

    AdvertOrderInfoAdvertType(Integer value, String text) {
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

    public static AdvertOrderInfoAdvertType valueOf(Integer value) {
        return EnumConverter.valueOf(AdvertOrderInfoAdvertType.class, value);
    }
}
