package com.moda.entity.enums.sys;

import com.moda.entity.enums.BaseEnum;
import com.moda.entity.enums.EnumConverter;

/**
 * 字典类型
 *
 * @author lyh
 * @version 2018-09-30
 */
public enum DictType implements BaseEnum {
    /**
     * 下单后多久未付款系统自动取消订单（单位：分钟）
     */
    ORDER_UNPAID_TIMEOUT(4, "未付款超时"),
    /**
     * 注册邀请随机赠送基金最小金额
     */
    USER_FUND_REGISTER_MIN(5, "注册基金最小金额"),
    /**
     * 注册邀请随机赠送基金最大金额
     */
    USER_FUND_REGISTER_MAX(6, "注册基金最小金额"),
    /**
     * 需提前多久才可以退订（单位：分钟）
     */
    ORDER_REFUND_TIMEOUT(10, "退订超时"),
    /**
     * 手机短信验证码有效时间（单位：分钟）
     */
    SMS_AUTHCODE_TIMEOUT(11, "验证码有效时间"),
    /**
     * 应用名称
     */
    APP_NAME(12, "应用名称"),
    /**
     * 订单详情地址
     */
    ORDER_INFO_DETAIL_URL(13, "订单详情地址"),
    /**
     * 发票快递费用
     */
    INVOICE_EXPRESS_FEE(14, "发票快递费用"),
    /**
     * 默认头像
     */
    DEFAULT_HEAD_URL(15, "默认头像"),
    /**
     * 首次关注微信公众号自动回复
     */
    FIRST_TIME_SUBSCRIBE_AUTO_REPLY(16, "首次关注微信公众号自动回复"),
    /**
     * 客控接口调用key
     */
    HOTEL_CONTROL_CMD_KEY(17, "客控接口调用key"),
    /**
     * 每天最多可以抽奖次数
     */
    EVERY_DAY_LOTTERY_MAX_TIMES(18, "每天最多可以抽奖次数"),
    /**
     * 每月最多可以提现次数
     */
    EVERY_MONTH_APPLY_CASH_MAX_TIMES(19, "每天最多可以抽奖次数"),
    /**
     * 每次最少提现金额
     */
    EVERY_TIME_APPLY_CASH_MIN_AMOUNT(20, "每次最少提现金额"),
    /**
     * 客控接口地址
     */
    HOTEL_CONTROL_API_URL(21, "客控接口地址"),
    /**
     * 每个用户最多可以购卡数量
     */
    MEMBERSHIP_CAD_MAX_BUY(22, "每个用户最多可以购卡数量"),
    /**
     * 退订房间手续费比例
     */
    REFUND_ROOM_FEE_RATE(23, "退订房间手续费比例"),
    /**
     * 微信客服默认回复信息
     */
    WEIXIN_CUSTOMER_SERVICE_DEFAULT_REPLY(24, "微信客服默认回复信息"),
    /**
     * 酒店提现手续费率
     */
    HOTEL_APPLY_CASH_FEE_RATE(25, "酒店提现手续费率"),
    /**
     * 时币兑换人民币汇率
     */
    TIME_COIN_EXCHANGE_CASH(26, "时币兑换人民币汇率"),
    /**
     * 时币折扣
     */
    TIME_COIN_DISCOUNT(27, "时币折扣"),
    /**
     * 一次性提成
     */
    ONE_TIME_COMMISSION(28, "一次性提成"),
    /**
     * 持续性提成
     */
    CONTINUOUS_COMMISSION(29, "持续性提成"),
    /**
     * 客控设备状态检测间隔时间（单位：秒）
     */
    SMART_CONTROL_CHECK_INTERVAL(30, "客控设备状态检测间隔时间"),
    /**
     * 客控设备出错时邮件通知地址（多个以逗号隔开）
     */
    SMART_CONTROL_ERROR_EMAIL_ADDRESS(31, "客控设备出错时邮件通知地址"), //
    INVITE_RECHARGE_TIME_COIN_REWARD_RATE(32, "邀请充值时币奖励比例"), //
    PARTNER_LEVEL(34, "合伙人级别"), //
    PARTNER_MARK_INCOME(35, "合伙人市场拓展收入分类"), //
    PARTNER_OPERATION_IMCOME(36, "合伙人运营收入分类"), //
    PARTNER_MODIFY_LOG_TYPE(37, "合伙人-修改日志类型"), //
    OC_ADMIN_MOBILE(38, "运营人员手机号"), //
    PARTNER_REMOTE_TEYP(39, "合伙人异地报备状态"), //
    CANCEL_ORDER_TIME(40, "合伙人盒子补贴收入分类"), //
    PARTNER_CASH_STATUS(41, "合伙人提现状态表"), //
    HOTEL_STATUS(42, "酒店状态"), //
    DK_BOX_PRICE(43, "盒子单价"), //
    JOIN_PARTNER_DK_BOX_PRICE(67, "联席合伙人的盒子单价"), //
    PARTNER_STATUS(44, "合伙人状态"), //
    PARTNER_SUBORDINATE_ROLE(45, "合伙人的下属人员角色"), //
    DK_BOX_MIN_BUY_COUNT(46, "盒子最低起订量"), //
    HOTEL_CASH_STATUS(47, "酒店提现状态"), //
    HOTEL_CASH_TYPE(48, "酒店提现类型"), //
    HOTEL_SIGN_STATUS(50, "签约信息审核状态"), //
    HOTEL_INCOME_TYPE(52, "酒店收入类型"), //
    HOTEL_CONTRACT_VERSION(53, "酒店合同版本"), //
    PARTNER_CONTGRACT_VERSION(54, "合伙人合同版本")//合伙人合同版本

    ;

    private Integer value;
    private String text;

    DictType(Integer value, String text) {
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

    public static DictType valueOf(Integer value) {
        return EnumConverter.valueOf(DictType.class, value);
    }
}
