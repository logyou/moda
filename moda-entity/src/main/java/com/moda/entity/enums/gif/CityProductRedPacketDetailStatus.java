package com.moda.entity.enums.gif;

import com.moda.entity.enums.BaseEnum;
import com.moda.entity.enums.EnumConverter;

/**
 * 一城一礼商品包裹状态
 *
 * @author lyh
 * @version 2019-2-26 20:30:13
 */
public enum CityProductRedPacketDetailStatus implements BaseEnum {
    /**
     * 一城一礼商品包裹状态
     */
    NOT_RECEIVE(1, "待领取"),
    RECEIVED(2, "已领取"),
    REFUNDED(3, "已退回");

    private Integer value;
    private String text;

    CityProductRedPacketDetailStatus(Integer value, String text) {
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

    public static CityProductRedPacketDetailStatus valueOf(Integer value) {
        return EnumConverter.valueOf(CityProductRedPacketDetailStatus.class, value);
    }
}
