package com.moda.entity.enums.device;

import com.moda.entity.enums.BaseEnum;
import com.moda.entity.enums.EnumConverter;

/**
 * 设备计费状态
 *
 * @author lyh
 * @version 2019-1-28 18:22:50
 */
public enum DeviceFeeStatus implements BaseEnum {
    /**
     * 设备计费状态
     */
    CLOSE_FEE(0, "计费关闭"),
    OPEN_FEE(1, "计费开通");

    private Integer value;
    private String text;

    DeviceFeeStatus(Integer value, String text) {
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

    public static DeviceFeeStatus valueOf(Integer value) {
        return EnumConverter.valueOf(DeviceFeeStatus.class, value);
    }
}