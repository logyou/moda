package com.moda.entity.enums.adv;

import com.moda.entity.enums.BaseEnum;
import com.moda.entity.enums.EnumConverter;

/**
 * 广告订单状态
 *
 * @author lyh
 * @create 2018-11-28 12:20:16
 **/
public enum AdvertOrderStatus implements BaseEnum {
    NEW(1, "新建"),//即备选排期
    LOCK_SCHEDULE(2, "锁点"),//
    PAID_SUCCESS(3, "已支付"),//
    DEPLOY(4,"发布"),//
    UNDERCARRIAGE(5,"下架"),//
    CANCEL(9,"取消")
    ;

    private Integer value;
    private String text;

    AdvertOrderStatus(Integer value, String text) {
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

    public static AdvertOrderStatus valueOf(Integer value) {
        return EnumConverter.valueOf(AdvertOrderStatus.class, value);
    }
}
