package com.moda.entity.enums.adv;

import com.moda.entity.enums.BaseEnum;
import com.moda.entity.enums.EnumConverter;

/**
 * 广告下单类型
 *
 * @author lyh
 * @create 2019-1-10 15:53:29
 **/
public enum AdvertOrderInfoOrderType implements BaseEnum {
    /**
     * 城市下单
     */
    CITY_ORDER(1, "城市下单"),
    /**
     * 总部下单
     */
    OFFICE_ORDER(2, "总部下单");

    private Integer value;
    private String text;

    AdvertOrderInfoOrderType(Integer value, String text) {
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

    public static AdvertOrderInfoOrderType valueOf(Integer value) {
        return EnumConverter.valueOf(AdvertOrderInfoOrderType.class, value);
    }
}
