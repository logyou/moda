package com.moda.entity.enums.usr;

import com.moda.entity.enums.BaseEnum;
import com.moda.entity.enums.EnumConverter;

/**
 * 用户账户消费订单信息的消费平台图标枚举
 *
 * @author lyh
 * @version 2019-1-17 15:38:01
 */
public enum ConsumePlatformLogo implements BaseEnum {
    /**
     * 小程序图标
     */
    JOY_MINI_APP_LOGO(1, "http://imgcdn.devkeep.com/images/d88/d88d48fcce048ab5b6cbdac56eef6311.png"),
    GIFT_MINI_APP_LOGO(2, "http://imgcdn.devkeep.com/images/b2b/b2b44a3446524ed050429dc7552c341d.png"),
    QUYUE_MINI_APP_LOGO(3, "http://imgcdn.devkeep.com/images/61e/61e78642db7eff34b99b998261135863.png");

    private Integer value;
    private String text;

    ConsumePlatformLogo(Integer value, String text) {
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

    public static ConsumePlatformLogo valueOf(Integer value) {
        return EnumConverter.valueOf(ConsumePlatformLogo.class, value);
    }
}
