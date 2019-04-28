package com.moda.entity.enums.prod;

import com.moda.entity.enums.BaseEnum;
import com.moda.entity.enums.EnumConverter;

/**
 * 产品类别
 *
 * @author lyh
 * @version 2018-11-26 18:23:41
 */
public enum ProductCategory implements BaseEnum {
    /**
     * 本宿客房
     */
    BENSUE_ROOM(1, "本宿客房"),
    /**
     * DK互娱客房
     */
    DK_HUYU_ROOM(2, "DK互娱客房"),
    /**
     * DK互娱电影
     */
    DK_HUYU_MOVIE(3, "DK互娱电影"),
    /**
     * DK互娱代金券
     */
    DK_HUYU_VOUCHER(4, "DK互娱代金券"),
    /**
     * 联席合伙人设备订单
     */
    JOINT_PARTNER_DEVICE(5, "联席合伙人设备订单"),
    /**
     * 周边广告订单
     */
    AROUND_ADVERTISING(6, "周边广告订单"),
    /**
     * 给用户账户充值的订单
     */
    USER_ACCOUNT_RECHARGE(7, "用户账户充值订单"),
    /**
     * 一城一礼订单
     */
    CITY_GIFT_ORDER(8, "一城一礼订单");

    private Integer value;
    private String text;

    ProductCategory(Integer value, String text) {
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

    public static ProductCategory valueOf(Integer value) {
        return EnumConverter.valueOf(ProductCategory.class, value);
    }
}