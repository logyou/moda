package com.moda.entity.enums.msg;

import com.moda.entity.enums.BaseEnum;
import com.moda.entity.enums.EnumConverter;

/**
 * 用户反馈类型
 *
 * @author lyh
 * @version 2018-12-21 14:13:29
 */
public enum UserFeedbackType implements BaseEnum {
    BUFFER_FREQUENTLY(1, "缓冲频繁"),
    CAN_NOT_PLAY(2, "无法播放"),
    SCAN_CODE_NO_RESPONSE(3, "扫码无响应"),
    CONTENT_IS_NOT_ENOUGH(4, "片源不够"),
    FLASH_BACK_FREQUENTLY(5, "闪退频繁"),
    OTHER(6, "其它");

    private Integer value;
    private String text;

    UserFeedbackType(Integer value, String text) {
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

    public static UserFeedbackType valueOf(Integer value) {
        return EnumConverter.valueOf(UserFeedbackType.class, value);
    }
}
