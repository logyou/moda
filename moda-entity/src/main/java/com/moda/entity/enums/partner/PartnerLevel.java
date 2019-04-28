/**
 * bensue.com
 * Copyright (c) 2017 All Rights Reserved.
 */
package com.moda.entity.enums.partner;

import com.moda.entity.enums.BaseEnum;
import com.moda.entity.enums.EnumConverter;

/**
 *                       
 * @Description: 
 * @Copyright: bensue.com
 * @History:<br>
 *<li>Author: 梁华山</li>
 *<li>Date: 2018年5月11日</li>
 *
 */

/**
 * 合伙人级别 
 */
public enum PartnerLevel implements BaseEnum {
                                              //                                              PROVINCE(1, "省"), //
                                              PROVINCE(1, "市场发起人"), //
                                              CITY(2, "市"), //
                                              DISTRICT(3, "区县"), //
                                              NORMAL(4, "一般")//
    ;

    private Integer value;
    private String  text;

    PartnerLevel(Integer value, String text) {
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

    public static PartnerLevel valueOf(Integer value) {
        return EnumConverter.valueOf(PartnerLevel.class, value);
    }
}
