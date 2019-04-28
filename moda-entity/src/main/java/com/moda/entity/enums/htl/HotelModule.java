package com.moda.entity.enums.htl;

import com.moda.entity.enums.BaseEnum;
import com.moda.entity.enums.EnumConverter;

/**
 * 酒店模块
 *
 * @author lyh
 * @create 2018-10-17 16:03:09
 **/
public enum HotelModule implements BaseEnum {
    /**
     * 酒店宣传
     */
    HOTEL_PUBLICITY(1, "酒店宣传"),
    /**
     * 酒店介绍
     */
    HOTEL_INTRODUCE(2, "酒店介绍"),
    /**
     * 酒店设施
     */
    HOTEL_FACILITY(3, "酒店设施"),
    /**
     * 酒店服务
     */
    HOTEL_SERVICE(4, "酒店服务"),
    /**
     * 酒店银行账户
     */
    HOTEL_BANK_INFO(5, "酒店银行账户"),
    /**
     * 酒店LOGO图片
     */
    HOTEL_LOGO(6, "酒店LOGO"),
    /**
     * 酒店栏目
     */
    HOTEL_CATEGORY(7, "酒店栏目");

    private Integer value;
    private String text;

    HotelModule(Integer value, String text) {
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

    public static HotelModule valueOf(Integer value) {
        return EnumConverter.valueOf(HotelModule.class, value);
    }
}
