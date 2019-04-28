package com.moda.entity.enums.rom;

import com.moda.entity.enums.BaseEnum;
import com.moda.entity.enums.EnumConverter;

/**
 * @author lyh
 * @create 2018-08-27 18:17
 **/
public enum CooperatorApplyRecordType implements BaseEnum {
                                                           MERCHANT(1, "商家申请"), //
                                                           INTELLIGENT(2, "达人申请"), //
                                                           SUPPLIER(3, "供应商申请"), //
                                                           VIP(4, "尊享会员申请")//
    ;

    private Integer value;
    private String  text;

    CooperatorApplyRecordType(Integer value, String text) {
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

    public static CooperatorApplyRecordType valueOf(Integer value) {
        return EnumConverter.valueOf(CooperatorApplyRecordType.class, value);
    }
}
