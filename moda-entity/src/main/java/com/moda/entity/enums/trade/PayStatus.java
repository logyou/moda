package com.moda.entity.enums.trade;

import com.moda.entity.enums.BaseEnum;
import com.moda.entity.enums.EnumConverter;

/**
 * 支付状态
 *
 * @author lyh
 * @version 1.1 2016-06-03
 *
 */
public enum PayStatus  implements BaseEnum {
	/**
	 * 未付款
	 */
	UNPAY( 0,"未付款"),
	/**
	 * 已付款
	 */
	PAID(1,"已付款"),
	/**
	 * 付款中
	 */
	PAYING(2,"付款中");

    private Integer value;
    private String  text;

    PayStatus(Integer value, String text) {
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

    public static PayStatus valueOf(Integer value) {
        return EnumConverter.valueOf(PayStatus.class, value);
    }
}
