package com.moda.entity.enums.device;

import com.moda.entity.enums.BaseEnum;
import com.moda.entity.enums.EnumConverter;

/**
 * 盒子状态
 * @author 梁华山
 * @version 2018-10-07
 */
public enum BoxStatus implements BaseEnum {
                                           NORMAL(0, "正常"), //
                                           REPEATED_RESTARTS(1, "反复重启"), //
                                           CRASH(2, "死机"), //
                                           PLAY_VIDEO_FAIL(3, "播放视频失败"), //
                                           PALY_AD_FAIL_HOME(4, "首页播放广告失败"), //
                                           PALY_AD_FAIL_OTHER_PAGE(5, "其他页播放广告失败"), //

    ;

    private Integer value;
    private String  text;

    BoxStatus(Integer value, String text) {
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

    public static BoxStatus valueOf(Integer value) {
        return EnumConverter.valueOf(BoxStatus.class, value);
    }
}