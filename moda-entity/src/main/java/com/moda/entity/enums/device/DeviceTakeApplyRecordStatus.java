package com.moda.entity.enums.device;

import com.moda.entity.enums.BaseEnum;
import com.moda.entity.enums.EnumConverter;

/**
 * 设备提货申请记录状态
 *
 * @author lyh
 * @version 2018-8-21
 */
public enum DeviceTakeApplyRecordStatus implements BaseEnum {
                                                             APPLYING(1, "申请中"), //
                                                             DELIVERED(2, "已发货"), //
                                                             DENIED(3, "已拒绝");//

    private Integer value;
    private String  text;

    DeviceTakeApplyRecordStatus(Integer value, String text) {
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

    public static DeviceTakeApplyRecordStatus valueOf(Integer value) {
        return EnumConverter.valueOf(DeviceTakeApplyRecordStatus.class, value);
    }
}