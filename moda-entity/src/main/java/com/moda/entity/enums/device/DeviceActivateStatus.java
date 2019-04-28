package com.moda.entity.enums.device;

import com.moda.entity.enums.BaseEnum;
import com.moda.entity.enums.EnumConverter;

/**
 * 设备激活状态
 *
 * @author lyh
 * @version 2019-1-28 18:22:50
 */
public enum DeviceActivateStatus implements BaseEnum {
    /**
     * 设备激活状态
     */
    INACTIVE(0, "未激活"),
    ACTIVATED(1, "已激活");

    private Integer value;
    private String text;

    DeviceActivateStatus(Integer value, String text) {
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

    public static DeviceActivateStatus valueOf(Integer value) {
        return EnumConverter.valueOf(DeviceActivateStatus.class, value);
    }
}