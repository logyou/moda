/**
 * bensue.com
 * Copyright (c) 2017 All Rights Reserved.
 */
package com.moda.entity.enums.partner;

import com.moda.entity.enums.BaseEnum;
import com.moda.entity.enums.EnumConverter;

/**
 * 合伙人合同版本
 * @Description: 
 * @Copyright: bensue.com
 * @History:<br>
 *<li>Author: 梁华山</li>
 *<li>Date: 2018年10月07日</li>
 *
 */

/**
 * 合伙人状态
 */
public enum PartnerContractVerson implements BaseEnum {
                                                       V1806(1, "1806版"), //
                                                       V1810(2, "1810版"), //
                                                       V1811(3, "1811版"), //
                                                       V1812(4, "1812版"), //
                                                       V1903(5, "1903版")//
    ;

    private Integer value;
    private String  text;

    PartnerContractVerson(Integer value, String text) {
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

    public static PartnerContractVerson valueOf(Integer value) {
        return EnumConverter.valueOf(PartnerContractVerson.class, value);
    }
}
