package com.moda.entity.message.push;

/**
 * 推送视频信息消息
 *
 * @author lyh
 * @version 2018-10-11 19:40:10
 */
public class PushRemoteControlMessage extends PushBaseMessage {
    /**
     * 按键名称
     */
    private String keyName;

    public String getKeyName() {
        return keyName;
    }

    public void setKeyName(String keyName) {
        this.keyName = keyName;
    }
}
