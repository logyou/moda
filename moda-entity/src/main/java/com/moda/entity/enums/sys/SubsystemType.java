package com.moda.entity.enums.sys;

import com.moda.entity.enums.BaseEnum;
import com.moda.entity.enums.EnumConverter;

/**
 * 子系统类型
 *
 * @author lyh
 * @create 2018-9-23
 **/
public enum SubsystemType implements BaseEnum {
    /**
     * PMS 移动端
     */
    PMS_MOBILE(1, "PMS 移动端"),
    /**
     * 客服管理子系统
     */
    CUSTOMER(2, "客服管理子系统"),
    /**
     * 公益管理子系统
     */
    PUBLIC_BENEFIT(3, "公益管理子系统"),
    /**
     * 后台管理子系统
     */
    ADMIN(4, "后台管理子系统"),
    /**
     * PMS PC端 完整版
     */
    PMS_PC_FULL(5, "PMS PC端 完整版"),
    /**
     * OTA 移动端
     */
    OTA_MOBILE(6, "OTA 移动端"),
    /**
     * PMS PC端 简化版
     */
    PMS_PC_SIMPLE(7, "PMS PC端 简化版"),
    /**
     * PAD
     */
    PAD(8, "PAD"),
    /**
     * 服务人员子系统
     */
    HOTEL_SERVICE(9, "服务人员子系统"),
    /**
     * 邸客互娱客房小程序
     */
    DEVKEEP_ROOM_MINI_APP(10, "邸客互娱客房小程序"),
    /**
     * 邸客运营系统
     */
    DEVKEEP_OPERATION(11, "邸客运营系统"),
    /**
     * 邸客CMS系统
     */
    DEVKEEP_CMS(12, "邸客CMS系统"),
    /**
     * 邸客合伙人PC端
     */
    DEVKEEP_PARTNER_PC_WEB(13, "邸客合伙人PC端"),
    /**
     * 邸客合伙人小程序端
     */
    DEVKEEP_PARTNER_MINI_APP(14, "邸客合伙人小程序端"),
    /**
     * 邸客后台管理系统
     */
    DEVKEEP_ADMIN(15, "邸客后台管理系统"),
    /**
     * 邸客内容管理系统
     */
    DEVKEEP_CONTENT(16, "邸客内容管理系统"),
    /**
     * 邸客设备管理系统
     */
    DEVKEEP_DEVICE(17, "邸客设备管理系统"),
    /**
     * 邸客设备管理系统
     */
    JOINT_PARTNER(18, "邸客联席合伙人"),
    /**
     * 设备管理小程序
     */
    DEVKEEP_DEVICE_MINI_APP(19, "设备管理小程序");

    private Integer value;
    private String text;

    SubsystemType(Integer value, String text) {
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

    public static SubsystemType valueOf(Integer value) {
        return EnumConverter.valueOf(SubsystemType.class, value);
    }
}
