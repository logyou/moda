package com.moda.entity.enums.vid;

import com.moda.entity.enums.BaseEnum;
import com.moda.entity.enums.EnumConverter;

/**
 * 酒店服务器指令类型
 *
 * @author lyh
 * @version 2019-1-4 11:06:00
 */
public enum HotelServerCmdType implements BaseEnum {
    OPEN_SSH_PORT(1, "SSH连接开放端口"),
    REBOOT_SERVER(2, "重启服务器"),
    UPDATE_DOWNLOAD_PROGRAM(3, "更新下载程序"),
    UPDATE_VIDEO(4, "更新视频文件"),
    CLEAR_VIDEO(5, "清理视频文件");

    private Integer value;
    private String text;

    HotelServerCmdType(Integer value, String text) {
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

    public static HotelServerCmdType valueOf(Integer value) {
        return EnumConverter.valueOf(HotelServerCmdType.class, value);
    }
}
