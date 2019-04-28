/**
 * bensue.com
 * Copyright (c) 2017 All Rights Reserved.
 */
package com.moda.entity.enums.resource;

import com.moda.entity.enums.BaseEnum;
import com.moda.entity.enums.EnumConverter;

/**
 * 酒店合同版本
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
public enum HotelContractVerson implements BaseEnum {
                                                     V1806(1, "1806版"), //
                                                     V1809(2, "1809版"), //
                                                     V1810(3, "1810版"), //
                                                     V1811(4, "1811版"), //联席合伙人
                                                     V1812(5, "1812版"), //天网合伙人
                                                     V1901(6, "1901版"), //1806版本合伙人超过起始设备数后的酒店只能加此版本，补贴2元/每天（有效入住）
                                                     V1903(7, "1903版");

    private Integer value;
    private String  text;

    HotelContractVerson(Integer value, String text) {
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

    public static HotelContractVerson valueOf(Integer value) {
        return EnumConverter.valueOf(HotelContractVerson.class, value);
    }
}
