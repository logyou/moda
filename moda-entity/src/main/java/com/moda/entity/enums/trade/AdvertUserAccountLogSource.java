package com.moda.entity.enums.trade;

import com.moda.entity.enums.BaseEnum;
import com.moda.entity.enums.EnumConverter;

/**
 * 广告主账户操作记录来源
 *
 * @author lyh
 * @version 2019-1-9 16:37:36
 */
public enum AdvertUserAccountLogSource implements BaseEnum {
    /**
     * 运营人员在管理后台进行储值操作
     */
    OPERATOR_RECHARGE(1, "运营储值"),
    /**
     * 展示广告后扣费
     */
    ADVERT_CONSUME(2, "广告消费");

    private Integer value;
    private String text;

    AdvertUserAccountLogSource(Integer value, String text) {
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

    public static AdvertUserAccountLogSource valueOf(Integer value) {
        return EnumConverter.valueOf(AdvertUserAccountLogSource.class, value);
    }
}
