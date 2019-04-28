package com.moda.entity.enums.quy;

import com.moda.entity.enums.BaseEnum;
import com.moda.entity.enums.EnumConverter;

/**
 * 趣约消费类型
 *
 * @author lyh
 * @version 2019-1-15 16:51:54
 */
public enum QuyueConsumeRecordType implements BaseEnum {
    /**
     * 赠送礼物
     */
    GIFT(1, "赠送礼物"),
    /**
     * 视频聊天
     */
    VIDEO_CHAT(2, "视频聊天"),
    /**
     * 付费视频
     */
    PAY_VIDEO(3, "付费视频");

    private Integer value;
    private String text;

    QuyueConsumeRecordType(Integer value, String text) {
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

    public static QuyueConsumeRecordType valueOf(Integer value) {
        return EnumConverter.valueOf(QuyueConsumeRecordType.class, value);
    }
}
