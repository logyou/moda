package com.moda.entity.message.push;

import java.io.Serializable;

/**
 * 推送消息
 *
 * @param <T> 消息内容
 * @author lyh
 * @version 2018-4-27
 */
public class PushImMessage<T> implements Serializable {
    private String deviceToken;//设备唯一编号
    private String fingerPrint;//消息指纹特征码
    private Integer playType;//消息类型
    private T content;//内容

    public T getContent() {
        return content;
    }

    public void setContent(T content) {
        this.content = content;
    }

    public String getDeviceToken() {
        return deviceToken;
    }

    public void setDeviceToken(String deviceToken) {
        this.deviceToken = deviceToken;
    }

    public String getFingerPrint() {
        return fingerPrint;
    }

    public void setFingerPrint(String fingerPrint) {
        this.fingerPrint = fingerPrint;
    }

    public Integer getPlayType() {
        return playType;
    }

    public void setPlayType(Integer playType) {
        this.playType = playType;
    }
}
