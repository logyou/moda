/**
 * bensue.com
 * Copyright (c) 2017 All Rights Reserved.
 */
package com.moda.entity.enums.partner;

import com.moda.entity.enums.BaseEnum;
import com.moda.entity.enums.EnumConverter;

/**
 * 合同状态                      
 * @Description: 
 * @Copyright: bensue.com
 * @History:<br>
 *<li>Author: 梁华山</li>
 *<li>Date: 2018年12月5日</li>
 *
 */

public enum ConstractStatus implements BaseEnum {
                                                 NEW(1, "新建"), //
                                                 ENABLE(2, "启用"), //
                                                 DISABLE(3, "禁用")//
    ;

    private Integer value;
    private String  text;

    ConstractStatus(Integer value, String text) {
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

    public static ConstractStatus valueOf(Integer value) {
        return EnumConverter.valueOf(ConstractStatus.class, value);
    }
}
