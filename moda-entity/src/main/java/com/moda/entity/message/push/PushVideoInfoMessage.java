package com.moda.entity.message.push;

import java.util.List;

/**
 * 推送视频信息消息
 */
public class PushVideoInfoMessage extends PushBaseMessage {
    /**
     * 操作类型
     */
    private Integer playOpt = 1;
    /**
     * 当前播放位置（毫秒）
     */
    private Long currentPosition;
    /**
     * 视频列表
     */
    private List<PushVideoDetailMessage> videos;

    public List<PushVideoDetailMessage> getVideos() {
        return videos;
    }

    public void setVideos(List<PushVideoDetailMessage> videos) {
        this.videos = videos;
    }

    public Long getCurrentPosition() {
        return currentPosition;
    }

    public void setCurrentPosition(Long currentPosition) {
        this.currentPosition = currentPosition;
    }

    public Integer getPlayOpt() {
        return playOpt;
    }

    public void setPlayOpt(Integer playOpt) {
        this.playOpt = playOpt;
    }
}
