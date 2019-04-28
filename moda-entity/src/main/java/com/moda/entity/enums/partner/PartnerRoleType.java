/**
 * bensue.com
 * Copyright (c) 2017 All Rights Reserved.
 */
package com.moda.entity.enums.partner;

import com.moda.entity.enums.BaseEnum;
import com.moda.entity.enums.EnumConverter;

/**
 * 合伙人团队角色类型                      
 * @Description: 
 * @Copyright: bensue.com
 * @History:<br>
 *<li>Author: 梁华山</li>
 *<li>Date: 2019年01月22日</li>
 *
 */

/**
 * 合伙人状态
 */
public enum PartnerRoleType implements BaseEnum {
                                                 BUSINESS(1, "商务人员"), //
                                                 INSTALLATION(2, "安装人员"); //

    private Integer value;
    private String  text;

    PartnerRoleType(Integer value, String text) {
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

    public static PartnerRoleType valueOf(Integer value) {
        return EnumConverter.valueOf(PartnerRoleType.class, value);
    }
}
