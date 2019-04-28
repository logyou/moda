package com.moda.entity.enums.trade;

import com.moda.entity.enums.BaseEnum;
import com.moda.entity.enums.EnumConverter;

/**
 * 申请退款处理状态
 *
 * @author lyh
 * @version 1.0 2018-6-8
 */
public enum ApplyRefundStatus implements BaseEnum {
                                                   APPLYING(1, "申请中"), //
                                                   REFUNDING(2, "退款中"), //
                                                   PASSED(3, "已退款"), //
                                                   DENIED(4, "已拒绝"), //
                                                   FAIL(5, "退款失败");
    private Integer value;
    private String  text;

    ApplyRefundStatus(Integer value, String text) {
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

    public static ApplyRefundStatus valueOf(Integer value) {
        return EnumConverter.valueOf(ApplyRefundStatus.class, value);
    }
}
