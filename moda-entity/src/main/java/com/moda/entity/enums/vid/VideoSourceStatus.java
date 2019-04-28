package com.moda.entity.enums.vid;

import com.moda.entity.enums.BaseEnum;
import com.moda.entity.enums.EnumConverter;

/**
 * 视频源状态
 *
 * @author lyh
 * @version 2018-10-5
 */
public enum VideoSourceStatus implements BaseEnum {
    OFFLINE(0, "下线"),
    ONLINE(1, "上线");

    private Integer value;
    private String text;

    VideoSourceStatus(Integer value, String text) {
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

    public static VideoSourceStatus valueOf(Integer value) {
        return EnumConverter.valueOf(VideoSourceStatus.class, value);
    }
}
