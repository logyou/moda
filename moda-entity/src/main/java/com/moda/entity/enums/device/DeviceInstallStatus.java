package com.moda.entity.enums.device;

import com.moda.entity.enums.BaseEnum;
import com.moda.entity.enums.EnumConverter;

/**
 * 设备安装状态
 *
 * @author lyh
 * @version 2019-1-28 18:22:50
 */
public enum DeviceInstallStatus implements BaseEnum {
    /**
     * 设备安装状态
     */
    UNINSTALL(0, "未安装"),
    INSTALLING(1, "安装中"),
    INSTALLED(2, "已安装"),
    UNTYING(4, "已解绑");

    private Integer value;
    private String text;

    DeviceInstallStatus(Integer value, String text) {
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

    public static DeviceInstallStatus valueOf(Integer value) {
        return EnumConverter.valueOf(DeviceInstallStatus.class, value);
    }
}