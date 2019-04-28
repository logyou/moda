package com.moda.entity.enums.sys;

import com.moda.entity.enums.BaseEnum;
import com.moda.entity.enums.EnumConverter;

/**
 * 消息类型
 *
 * @author lyh
 * @version 2018-12-5 14:52:30
 */
public enum MessageType implements BaseEnum {
    /**
     * 1-会员卡办理提醒；
     */
    BUY_CARD_REMIND(1, "会员卡办理提醒"),
    /**
     * 2-提现申请通知；
     */
    APPLY_CASH_REMIND(2, "提现申请通知"),
    /**
     * 3-任务审核提醒
     */
    TASK_AUDIT_REMIND(3, "任务审核提醒"),
    /**
     * 4-付款成功通知
     */
    PAY_SUCCESS_REMIND(4, "付款成功通知"),
    /**
     * 5-提现失败通知
     */
    APPLY_CASH_FAIL_REMIND(5, "提现失败通知"),
    /**
     * 6-客人退订通知
     */
    CUSTOMER_REFUND_REMIND(6, "客人退订通知"),
    /**
     * 7-酒店预订成功通知
     */
    HOTEL_BOOK_SUCCESS_REMIND(7, "酒店预订成功通知"),
    /**
     * 8-服务受理通知
     */
    SERVICE_ACCEPT_REMIND(8, "服务受理通知"),
    /**
     * 用户提交了发布周边广告申请，通知给相关审核人员
     */
    PUBLISH_AROUND_ADVERT(9, "发布周边广告审核通知"),
    HOTEL_SERVER_OFFLINE(10, "酒店服务器离线通知");

    private Integer value;
    private String text;

    MessageType(Integer value, String text) {
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

    public static MessageType valueOf(Integer value) {
        return EnumConverter.valueOf(MessageType.class, value);
    }
}
