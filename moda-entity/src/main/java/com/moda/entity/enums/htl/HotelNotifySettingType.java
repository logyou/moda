package com.moda.entity.enums.htl;

import com.moda.entity.enums.BaseEnum;
import com.moda.entity.enums.EnumConverter;

/**
 * 订单状态
 *
 * @author lyh
 * @version 1.2 2018-3-13
 */
public enum HotelNotifySettingType implements BaseEnum {
    /**
     * 审核信息通知
     */
    AUDIT_INFO(1, "审核信息通知"),
    HOTEL_SHOP_ORDER(2, "酒店商城订单通知");

    private Integer value;
    private String text;

    HotelNotifySettingType(Integer value, String text) {
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

    public static HotelNotifySettingType valueOf(Integer value) {
        return EnumConverter.valueOf(HotelNotifySettingType.class, value);
    }
}
