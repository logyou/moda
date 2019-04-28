package com.moda.entity.enums.trd;

import com.moda.entity.enums.BaseEnum;
import com.moda.entity.enums.EnumConverter;

/**
 * 订单状态
 *
 * @author lyh
 * @version 1.2 2018-3-13
 */
public enum OrderStatus implements BaseEnum {
    /**
     * 待付款
     */
    WAIT_PAY(1, "待付款"),
    /**
     * 已付款
     */
    PAID_SUCCESS(2, "已付款"),
    /**
     * 已入住
     */
    CHECK_IN(3, "已入住"),
    /**
     * 已离店
     */
    CHECK_OUT(4, "已离店"),
    /**
     * 已确认
     */
    ALREADY_CONFIRMED(6, "已确认"),
    /**
     * 结束观影
     */
    FINISH_WATCH_FILM(7, "结束观影"),
    /**
     * 已退订
     */
    RETURNED(8, "已退订"),
    /**
     * 已取消
     */
    CANCELED(9, "已取消");

    private Integer value;
    private String text;

    OrderStatus(Integer value, String text) {
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

    public static OrderStatus valueOf(Integer value) {
        return EnumConverter.valueOf(OrderStatus.class, value);
    }
}
