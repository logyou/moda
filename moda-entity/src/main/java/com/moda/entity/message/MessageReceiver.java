package com.moda.entity.message;

/**
 * 消息接收者接口，接收消息的类必须实现该接口
 *
 * @author lyh
 * @version 2018-09-02
 */
public interface MessageReceiver {
    void receive(MessageTemplate mt);
}
