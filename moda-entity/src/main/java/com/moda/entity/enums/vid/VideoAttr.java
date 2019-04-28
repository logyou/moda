package com.moda.entity.enums.vid;

import com.moda.entity.enums.BaseEnum;
import com.moda.entity.enums.EnumConverter;

/**
 * 视频属性
 *
 * @author lyh
 * @version 2018-10-5
 */
public enum VideoAttr implements BaseEnum {
    /**
     * 单片
     */
    SINGLE(1, "单片"),
    /**
     * 连续剧
     */
    SERIES(2, "连续剧");

    private Integer value;
    private String text;

    VideoAttr(Integer value, String text) {
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

    public static VideoAttr valueOf(Integer value) {
        return EnumConverter.valueOf(VideoAttr.class, value);
    }
}
