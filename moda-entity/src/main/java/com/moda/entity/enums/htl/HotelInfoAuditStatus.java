package com.moda.entity.enums.htl;

import com.moda.entity.enums.BaseEnum;
import com.moda.entity.enums.EnumConverter;

/**
 * 酒店信息审核状态
 *
 * @author lyh
 * @create 2018-10-18 10:42:35
 **/
public enum HotelInfoAuditStatus implements BaseEnum {
    /**
     * 待审核
     */
    WAITING_AUDIT(1, "待审核"),
    /**
     * 审核通过
     */
    PASS_AUDIT(2, "审核通过"),
    /**
     * 审核不通过
     */
    FAIL_AUDIT(3, "审核不通过");

    private Integer value;
    private String text;

    HotelInfoAuditStatus(Integer value, String text) {
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

    public static HotelInfoAuditStatus valueOf(Integer value) {
        return EnumConverter.valueOf(HotelInfoAuditStatus.class, value);
    }
}
