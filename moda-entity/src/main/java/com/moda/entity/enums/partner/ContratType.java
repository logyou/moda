/**
 * bensue.com
 * Copyright (c) 2017 All Rights Reserved.
 */
package com.moda.entity.enums.partner;

import com.moda.entity.enums.BaseEnum;
import com.moda.entity.enums.EnumConverter;

/**
 * 合同类型                      
 * @Description: 
 * @Copyright: bensue.com
 * @History:<br>
 *<li>Author: 梁华山</li>
 *<li>Date: 2018年12月5日</li>
 *
 */

public enum ContratType implements BaseEnum {
                                             PARTNER(1, "合伙人合同"), //
                                             HOTEL(2, "酒店合同"), //
                                             ADVERTER(3, "广告主合同")//
    ;

    private Integer value;
    private String  text;

    ContratType(Integer value, String text) {
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

    public static ContratType valueOf(Integer value) {
        return EnumConverter.valueOf(ContratType.class, value);
    }
}
