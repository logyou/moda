package com.moda.entity.enums.htl;

import com.moda.entity.enums.BaseEnum;
import com.moda.entity.enums.EnumConverter;

/**
 * 酒店精准-审核状态
 * @author 梁华山
 * @create 2019-04-10 16:03:09
 **/
public enum HotelLaunchAuditStatus implements BaseEnum {
    /**
     * 待审核
     */
    WAITING_AUDIT(1, "待审核"),
    /**
     * 审核通过
     */
    AUDIT_PASS(2, "审核通过"),
    /**
     * 审核不通过
     */
    AUDIT_FAILED(3, "审核不通过");

    private Integer value;
    private String text;

    HotelLaunchAuditStatus(Integer value, String text) {
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

    public static HotelLaunchAuditStatus valueOf(Integer value) {
        return EnumConverter.valueOf(HotelLaunchAuditStatus.class, value);
    }
}
