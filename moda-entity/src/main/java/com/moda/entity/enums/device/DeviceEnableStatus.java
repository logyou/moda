package com.moda.entity.enums.device;

import com.moda.entity.enums.BaseEnum;
import com.moda.entity.enums.EnumConverter;

/**
 * 设备启用状态
 *
 * @author lyh
 * @version 2019-1-28 18:22:50
 */
public enum DeviceEnableStatus implements BaseEnum {
    /**
     * 设备启用状态
     */
    DISABLED(0, "禁用"),
    ENABLED(1, "启用");

    private Integer value;
    private String text;

    DeviceEnableStatus(Integer value, String text) {
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

    public static DeviceEnableStatus valueOf(Integer value) {
        return EnumConverter.valueOf(DeviceEnableStatus.class, value);
    }
}