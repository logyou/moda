package com.moda.entity.enums.resource;

import com.moda.entity.enums.BaseEnum;
import com.moda.entity.enums.EnumConverter;

/**
 * 设施类型
 *
 * @author lyh
 * @version 1.0 2016-09-09
 */
public enum AmenityType implements BaseEnum {
                                             /**
                                              * 1-房间设施；
                                              */
                                             ROOM_AMENITY(1, "房间设施"),
                                             /**
                                              * 2-酒店设施；
                                              */
                                             HOTEL_AMENITY(2, "酒店设施"),
                                             /**
                                              * 3-酒店服务
                                              */
                                             HOTEL_SERVICE(3, "酒店服务"),
                                             /**
                                              * 4-酒店服务
                                              */
                                             ROOM_TYPE_SERVICE(4, "房型设施"),
                                             /**
                                              * 5-场景标签
                                              */
                                             SCENE_TAGS(5, "场景标签"), SI_INDEX(6, "四大指数");

    private Integer value;
    private String  text;

    AmenityType(Integer value, String text) {
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

    public static AmenityType valueOf(Integer value) {
        return EnumConverter.valueOf(AmenityType.class, value);
    }
}
