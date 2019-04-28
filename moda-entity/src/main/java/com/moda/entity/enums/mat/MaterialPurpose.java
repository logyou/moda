package com.moda.entity.enums.mat;

import com.moda.entity.enums.BaseEnum;
import com.moda.entity.enums.EnumConverter;

/**
 * 素材用途
 *
 * @author lyh
 * @create 2018-09-11 13:39
 **/
public enum MaterialPurpose implements BaseEnum {
    APP_HOME_ADVERT(1, "小程序首页广告"),
    BOX_HOME_ADVERT(2, "盒子开机视频广告");

    private Integer value;
    private String text;

    MaterialPurpose(Integer value, String text) {
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

    public static MaterialPurpose valueOf(Integer value) {
        return EnumConverter.valueOf(MaterialPurpose.class, value);
    }
}
