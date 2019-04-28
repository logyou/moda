package com.moda.entity.enums.adv;

import com.moda.entity.enums.BaseEnum;
import com.moda.entity.enums.EnumConverter;

/**
 * 广告来源
 *
 * @author lyh
 * @create 2018-10-17 17:08:24
 **/
public enum AdvertSource implements BaseEnum {
    /**
     * 广告库
     */
    ADVERT_LIBRARY(1, "广告库"),
    /**
     * 酒店
     */
    HOTEL(2, "酒店"),
    AROUND(3, "周边广告");

    private Integer value;
    private String text;

    AdvertSource(Integer value, String text) {
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

    public static AdvertSource valueOf(Integer value) {
        return EnumConverter.valueOf(AdvertSource.class, value);
    }
}
