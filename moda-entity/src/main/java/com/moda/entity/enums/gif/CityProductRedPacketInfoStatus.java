package com.moda.entity.enums.gif;

import com.moda.entity.enums.BaseEnum;
import com.moda.entity.enums.EnumConverter;

/**
 * 一城一礼商品包裹状态
 *
 * @author lyh
 * @version 2019-2-26 20:30:13
 */
public enum CityProductRedPacketInfoStatus implements BaseEnum {
    /**
     * 一城一礼商品包裹状态
     */
    ACTIVITY(1, "进行中"),
    FINISHED(2, "已领完"),
    EXPIRED(3, "已过期");

    private Integer value;
    private String text;

    CityProductRedPacketInfoStatus(Integer value, String text) {
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

    public static CityProductRedPacketInfoStatus valueOf(Integer value) {
        return EnumConverter.valueOf(CityProductRedPacketInfoStatus.class, value);
    }
}
