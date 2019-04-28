/**
 * bensue.com
 * Copyright (c) 2017 All Rights Reserved.
 */
package com.moda.entity.enums.resource;

import com.moda.entity.enums.BaseEnum;
import com.moda.entity.enums.EnumConverter;

/**
 * 酒店星级                      
 * @Description: 
 * @Copyright: bensue.com
 * @History:<br>
 *<li>Author: 梁华山</li>
 *<li>Date: 2019年01月21日</li>
 *
 */

/**
 * 合伙人状态
 */
public enum HotelStarLevel implements BaseEnum {
                                                ECONOMY(2, "经济/快捷"), //
                                                THREE_STAR(3, "三星/舒适"), //
                                                FOUR_STAR(4, "四星/高档"), //
                                                FIVE_STAR(5, "五星/豪华");

    private Integer value;
    private String  text;

    HotelStarLevel(Integer value, String text) {
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

    public static HotelStarLevel valueOf(Integer value) {
        return EnumConverter.valueOf(HotelStarLevel.class, value);
    }
}
