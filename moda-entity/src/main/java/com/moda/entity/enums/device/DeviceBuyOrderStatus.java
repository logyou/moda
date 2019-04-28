package com.moda.entity.enums.device;

import com.moda.entity.enums.BaseEnum;
import com.moda.entity.enums.EnumConverter;

/**
 * 设备菜单订单状态
 *
 * @author lyh
 * @version 1.02018-7-28
 */
public enum DeviceBuyOrderStatus implements BaseEnum {
                                                      WAP_PAY(1, "待付款"), //
                                                      WAIT_CONFIRM(2, "已付款待确认"), //
                                                      CAN_TAKE(3, "可提货"), //
                                                      COMPLETE_TAKE(4, "已提完货"), //
                                                      APPLY_TAKE(5, "提货申请中");

    private Integer value;
    private String  text;

    DeviceBuyOrderStatus(Integer value, String text) {
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

    public static DeviceBuyOrderStatus valueOf(Integer value) {
        return EnumConverter.valueOf(DeviceBuyOrderStatus.class, value);
    }
}