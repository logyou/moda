/**
 * bensue.com
 * Copyright (c) 2017 All Rights Reserved.
 */
package com.moda.entity.enums.settle;

import com.moda.entity.enums.BaseEnum;
import com.moda.entity.enums.EnumConverter;

/**
 * 一般实时任务类型                      
 * @Description: 
 * @Copyright: bensue.com
 * @History:<br>
 *<li>Author: 梁华山</li>
 *<li>Date: 2019年01月24日</li>
 *
 */

/**
 * 合伙人状态
 */
public enum NormalRealTimeTaskType implements BaseEnum {
                                                        REBUILD_PARTNER_RELATIONSHIP(1, "重组合伙人关系"), //
                                                        REWRITE_DEVICE_ORDER(3, "新绑定的盒子回写订单归属"), //
                                                        CAL_PARTNER_TEAM(4, "计算合伙人团队及人数"), //
                                                        CAL_PARTNER_NUMBER(5, "计算合伙人人数"), //
                                                        HOTEL_DATA_PERMISSION(6, "给合伙人下属酒店");

    private Integer value;
    private String  text;

    NormalRealTimeTaskType(Integer value, String text) {
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

    public static NormalRealTimeTaskType valueOf(Integer value) {
        return EnumConverter.valueOf(NormalRealTimeTaskType.class, value);
    }
}
