package com.moda.entity.weixin;

/**
 * 消息类型：所有微信涉及到的消息类型统一管理
 */

public enum EventType {
    /**
     * 点击事件
     */
    CLICK("CLICK"),
    /**
     * URL跳转
     */
    VIEW("VIEW"),
    /**
     * 扫码推事件
     */
    SCANCODE_PUSH("scancode_push"),
    /**
     * 订阅消息
     */
    SUBSCRIBE("subscribe"),
    /**
     * 取消订阅
     */
    UNSUBSCRIBE("unsubscribe"),
    /**
     * 扫码
     */
    SCAN("SCAN");

    private String name;

    private EventType(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return this.name;
    }

    public static void main(String[] args) {
        System.out.println(EventType.CLICK);
    }
}
