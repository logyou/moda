package com.moda.entity.enums.device;

import com.moda.entity.enums.BaseEnum;
import com.moda.entity.enums.EnumConverter;

/**
 * 设备状态
 *
 * @author lyh
 * @version 1.0 2018-7-28
 */
public enum DeviceInfoStatus implements BaseEnum {
                                                  INACTIVE(1, "未激活"), //
                                                  ACTIVATED(2, "已激活"), //
                                                  USING(3, "正在使用"), //
                                                  DISABLED(4, "禁用");//

    private Integer value;
    private String  text;

    DeviceInfoStatus(Integer value, String text) {
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

    public static DeviceInfoStatus valueOf(Integer value) {
        return EnumConverter.valueOf(DeviceInfoStatus.class, value);
    }
}