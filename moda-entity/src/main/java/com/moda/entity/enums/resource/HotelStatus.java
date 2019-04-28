/**
 * bensue.com
 * Copyright (c) 2017 All Rights Reserved.
 */
package com.moda.entity.enums.resource;

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
 * 合伙人状态
 */
public enum HotelStatus implements BaseEnum {
                                             NEW(19, "新建"), //
                                             HOTEL_INFO_WIATING_APPEND(13, "酒店信息待完善"), //
                                             HOTEL_INFO_WAITING_AUDIT(14, "酒店信息待审核"), //
                                             HOTEL_INFO_AUDIT_FAIL(5, "酒店信息审核未通过"), //
                                             HOTEL_INFO_AUDIT_SUCCESS(20, "酒店信息审核通过"), //
                                             HOTEL_EQUIPMENT_WAIT_INSTALLED(1, "酒店设备待安装"), //
                                             HOTEL_EQUIPMENT_INSTALLED(2, "设备已安装待审核"), //
                                             HOTEL_EQUIPMENT_AUDIT_FAIL(9, "安装完成审核不通过"), //
                                             WAITING_OPEN_CHARGING(15, "等待开通计费"), //
                                             HOTEL_BILL_OPENED(3, "计费已开通"), //
                                             HOTEL_BILL_CLOSED(4, "计费已关闭"), //
                                             DISABLE(16, "禁用");

    private Integer value;
    private String  text;

    HotelStatus(Integer value, String text) {
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

    public static HotelStatus valueOf(Integer value) {
        return EnumConverter.valueOf(HotelStatus.class, value);
    }
}
