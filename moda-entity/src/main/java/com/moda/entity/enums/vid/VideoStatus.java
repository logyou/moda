package com.moda.entity.enums.vid;

import com.moda.entity.enums.BaseEnum;
import com.moda.entity.enums.EnumConverter;

/**
 * 视频状态
 *
 * @author lyh
 * @version 2018-10-5
 */
public enum VideoStatus implements BaseEnum {
    DISABLED(0, "禁用"),
    ENABLED(1, "启用");

    private Integer value;
    private String text;

    VideoStatus(Integer value, String text) {
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

    public static VideoStatus valueOf(Integer value) {
        return EnumConverter.valueOf(VideoStatus.class, value);
    }
}
