package com.moda.entity.message;

/**
 * 消息路由键
 *
 * @author lyh
 * @version 2018-09-02
 */
public class MessageRoutingKey {

    public final static String QUEUE_ORDER_CONFIRMATION_REMINDER_MESSAGE = "dk.queue.order.confirmation.reminder.message"; //订单确认提醒消息
    /**
     * 邮件消息
     */
    public final static String QUEUE_EMAIL_MESSAGE = "dk.queue.email.message";
    /**
     * 错误消息
     */
    public final static String QUEUE_ERROR_MESSAGE = "dk.queue.error.message";
    /**
     * 手机短信
     */
    public final static String QUEUE_MOBILE_MESSAGE = "dk.queue.mobile.message";
    /**
     * 语音消息
     */
    public final static String QUEUE_VOICE_MESSAGE = "dk.queue.voice.message";
    /**
     * 站内信
     */
    public final static String QUEUE_WEBSITE_MESSAGE = "dk.queue.website.message";

    /**
     * 公众号模板消息
     */
    public final static String QUEUE_OFFICIAL_ACCOUNT_TEMPLATE_MESSAGE = "dk.queue.official.account.template.message";
    /**
     * 小程序模板消息
     */
    public final static String QUEUE_MINI_PROGRAM_TEMPLATE_MESSAGE = "dk.queue.mini.program.template.message";
    /**
     * 推送实时消息
     */
    public final static String QUEUE_PUSH_IM_MESSAGE = "dk.queue.push.im.message";
    /**
     * 用户扫码屏幕上的二维码
     */
    public final static String QUEUE_USER_SCAN_BOX = "dk.queue.user.scan.box";
    /**
     * 盒子启动信息
     */
    public static final String QUEUE_BOX_BOOT_MESSAGE = "dk.queue.box.boot.message";
    /**
     * 联席合伙人设备订单支付成功
     */
    public static final String QUEUE_JOINT_PARTNER_DEVICE_PAID_SUCCESS = "dk.queue.joint.partner.device.paid.success";
    /**
     * 周边广告订单支付成功
     */
    public static final String QUEUE_AROUND_ADVERTISING_PAID_SUCCESS = "dk.queue.around.advertising.paid.success";
    /**
     * 用户账户充值订单支付成功
     */
    public static final String QUEUE_USER_ACCOUNT_RECHARGE_PAID_SUCCESS = "dk.queue.user.account.recharge.paid.success";
    /**
     * 一城一礼订单支付成功
     */
    public static final String QUEUE_CITY_GIFT_ORDER_PAID_SUCCESS = "dk.queue.city.gift.order.paid.success";
    /**
     * 取消一城一礼订单支付超时的订单
     */
    public static final String QUEUE_CANCEL_PAY_TIMEOUT_CITY_GIFT_ORDER = "dk.queue.cancel.pay.timeout.city.gift.order";
    /**
     * 检测一城一礼红包状态
     */
    public static final String QUEUE_CHECK_CITY_GIFT_RED_PACKET_STATUS = "dk.queue.check.city.gift.red.packet.status";
    /**
     * 检测酒店服务器
     */
    public static final String QUEUE_CHECK_HOTEL_SERVER = "dk.queue.check.hotel.server";

    /**
     * 联席合伙人广告位补贴
     */
    public static final String QUEUE_JOINT_PARTNER_ADVERT_SUBSIDY = "dk.queue.joint.partner.advert.subsidy";

    /**
     * 联席合伙人日结重新结算任务消息
     */
    public final static String QUEUE_JOINT_PARTNER_DAY_TASK_MESSAGE = "dk.queue.joint.partner.day.task";
    /**
     * 联席合伙人月结任务消息
     */
    public final static String QUEUE_JOINT_PARTNER_MONTH_TASK_MESSAGE = "dk.queue.joint.partner.month.task";

    public final static String QUEUE_BOX_SURVIVAL_LOG_MESSAGE = "dk.queue.box.survival.log";                    //存活日志消息
    public final static String QUEUE_BOX_OPERATION_LOG_MESSAGE = "dk.queue.box.operation.log";                  //操作日志消息
    public final static String QUEUE_MINIAPP_OPERATION_LOG_MESSAGE = "dk.queue.miniapp.operation.log";          //小程序用户操作日志消息

    public final static String QUEUE_NORMAL_REAL_TASK_MESSAGE = "dk.queue.normal.real.task";                    //一般实时任务
    public final static String QUEUE_NORMAL_DAY_TASK_MESSAGE = "dk.queue.normal.day.task";                     //一般每天任务
    public final static String QUEUE_SETTLE_REAL_TASK_MESSAGE = "dk.queue.settle.real.task";                    //实时结算任务
    public final static String QUEUE_SETTLE_DAY_TASK_MESSAGE = "dk.queue.settle.day.task";                     //每天结算任务
    public final static String QUEUE_SETTLE_MONTH_TASK_MESSAGE = "dk.queue.settle.month.task";                   //每月结算任务

}
