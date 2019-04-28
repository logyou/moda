package com.moda.entity.enums.htl;

import com.moda.entity.enums.BaseEnum;
import com.moda.entity.enums.EnumConverter;

/**
 * 酒店账户状态 1新建未提交;2账户未激活;3正常使用;4账户已禁用
 * @author 梁华山
 * @create 2018-12-07 16:03:09
 **/
public enum HotelAccountStatus implements BaseEnum {
    /**
     * 新建未提交
     */
    NEW(1, "新建未提交"),
    /**
     * 账户未激活
     */
    NOT_ACTIVATED(2, "账户未激活"),
    /**
     * 酒店设施图片
     */
    NORMAL(3, "正常使用"),
    /**
     * 酒店服务图片
     */
    DISABLE(4, "账户已禁用");

    private Integer value;
    private String text;

    HotelAccountStatus(Integer value, String text) {
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

    public static HotelAccountStatus valueOf(Integer value) {
        return EnumConverter.valueOf(HotelAccountStatus.class, value);
    }
}
