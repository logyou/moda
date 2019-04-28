package com.moda.entity.enums.vid;

import com.moda.entity.enums.BaseEnum;
import com.moda.entity.enums.EnumConverter;

/**
 * 视频下载状态
 *
 * @author lyh
 * @version 2018-12-21 14:13:29
 */
public enum VideoDownloadStatus implements BaseEnum {
    /**
     * 未下载
     */
    NOT_DOWNLOAD(0, "未下载"),
    /**
     * 已下载到本地
     */
    LOCAL_DOWNLOAD(1, "已下载到本地"),
    /**
     * 已上传到云端
     */
    CLOUD_UPLOAD(2, "已上传到云端"),
    /**
     * 云端已清理
     */
    CLOUD_CLEAR(3, "云端已清理");

    private Integer value;
    private String text;

    VideoDownloadStatus(Integer value, String text) {
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

    public static VideoDownloadStatus valueOf(Integer value) {
        return EnumConverter.valueOf(VideoDownloadStatus.class, value);
    }
}
