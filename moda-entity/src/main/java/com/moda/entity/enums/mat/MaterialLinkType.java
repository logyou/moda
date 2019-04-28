package com.moda.entity.enums.mat;

import com.moda.entity.enums.BaseEnum;
import com.moda.entity.enums.EnumConverter;

/**
 * 素材链接类型
 *
 * @author lyh
 * @create 2018-09-11 13:39
 **/
public enum MaterialLinkType implements BaseEnum {
    WEBPAGE(1, "网页"),
    VIDEO(2, "视频"),
    IMAGE(3, "图片"),
    VOICE(4, "语音");

    private Integer value;
    private String text;

    MaterialLinkType(Integer value, String text) {
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

    public static MaterialLinkType valueOf(Integer value) {
        return EnumConverter.valueOf(MaterialLinkType.class, value);
    }
}
