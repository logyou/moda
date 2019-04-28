package com.moda.entity.sms;

import java.io.Serializable;
import java.util.Map;

/**
 * 短信内容模板
 * Created by lyh on 2017/4/21/021.
 */
public class SmsContentTemplate implements Serializable {

    /**
     * 填充数据
     *
     * @param tpl    模板
     * @param params 参数
     * @return 内容
     */
    public static String fillData(String tpl, Map<String, Object> params) {
        String msg = tpl;
        if (params != null) {
            for (Map.Entry<String, Object> entry : params.entrySet()) {
                msg = msg.replace("#" + entry.getKey() + "#", (null == entry.getValue() ? "" : entry.getValue().toString()));
            }
        }
        return msg;
    }

    public static class SmsContentItem {
        private String key;
        private String text;

        public SmsContentItem() {

        }

        public SmsContentItem(String key, String text) {
            this.key = key;
            this.text = text;
        }

        public String getKey() {
            return key;
        }

        public void setKey(String key) {
            this.key = key;
        }

        public String getText() {
            return text;
        }

        public void setText(String text) {
            this.text = text;
        }
    }

    /**
     * 短信签名
     */
    public static final String SMS_SIGNATURE = "【邸客互娱】";

    /**
     * 注册验证码
     */
    public static final String SMS_CODE_REGISTER = "sms_code_register_";

    /**
     * 修改手机号验证码
     */
    public static final String SMS_CODE_MODIFY_MOBILE = "sms_code_modify_mobile_";

    /**
     * 修改支付密码验证码
     */
    public static final String SMS_CODE_MODIFY_PAY_PASSWORD = "sms_code_modify_pay_password_";

    /**
     * 忘记支付密码验证码
     */
    public static final String SMS_CODE_FORGET_PAY_PASSWORD = "sms_code_forget_pay_password_";

    /**
     * 忘记支付密码验证码标识
     */
    public static final String SMS_CODE_FORGET_PAY_PASSWORD_FLAG = "sms_code_forget_pay_password_flag_";

    /**
     * 修改登录密码验证码
     */
    public static final String SMS_CODE_MODIFY_LOGIN_PASSWORD = "sms_code_modify_login_password_";

    /**
     * 忘记登录密码验证码
     */
    public static final String SMS_CODE_FORGET_LOGIN_PASSWORD = "sms_code_forget_login_password_";

    /**
     * 忘记登录密码验证码标识
     */
    public static final String SMS_CODE_FORGET_LOGIN_PASSWORD_FLAG = "sms_code_forget_login_password_flag_";

    /**
     * 操作资金授权码验证码
     */
    public static final String SMS_CODE_OPERATE_CAPITAL = "sms_code_operate_capital_";

    /**
     * 申请提现授权码验证码
     */
    public static final String SMS_CODE_APPLY_CASH = "sms_code_apply_cash_";

    /**
     * 绑定提现帐号验证码
     */
    public static final String SMS_CODE_BIND_APPLY_CASH_ACCOUNT = "sms_code_bind_apply_cash_account_";

    /**
     * 一般验证码
     */
    public static final String SMS_CODE_NORMAL_CHECK_MOBILE = "sms_code_normal_check_mobile_";

    /**
     * 给用户发送会员卡验证码
     */
    public static final String SMS_SEND_MEMBERSHIP_CARD = "sms_send_membership_card_";

    /**
     * 客户支付成功后接收的短信通知模板
     */
    public static final String SMS_TEMPLATE_ROOM_SUCCESS_TO_CUSTOMER = SMS_SIGNATURE
            + "预订成功：您预订的#date#入住#detail#，已完成支付#amount#元。房间已预留，等待您的入住。  酒店地址：#address#      酒店电话：#hotelTel# 。 邸客互娱为您提供精彩互动之旅--扫码秒变遥控器，海量大片看不停。人工客服电话：#serviceTel#";
    public static final String SMS_TEMPLATE_ROOM_SUCCESS_TO_HOTEL = SMS_SIGNATURE
            + "您有一个新的住房订单等待确认：#date#入住#roomType#，已支付价格#amount#元。请前往#address#进行确认查看。";
    public static final String SMS_TEMPLATE_ROOM_SUCCESS_TO_ADMIN = SMS_SIGNATURE
            + "有一个新的订房订单等待确认。任务名称：#orderNo#还未确认，我们的用户还在等，请联系该酒店进行确认。备注：#hotelName#酒店联系电话--#hotelTel#";
    public static final String SMS_TEMPLATE_MARKET_AWARD_TO_WALLET = SMS_SIGNATURE
            + "亲，你这个月的转发任务已经完成，推广奖励#AwardAmount#已经打入你的本宿钱包中，注意查收哦。";
    public static final String SMS_TEMPLATE_MARKET_AWARD_TO_ACCOUNT = SMS_SIGNATURE
            + "亲，您的本宿#CardName#，提现#ApplyAmount#元已经到账，注意查收哦。";
    public static final String SMS_TEMPLATE_CARD_ACCOUNT_CASH_BACK = SMS_SIGNATURE
            + "亲，您的本宿#CardName#，今日第#MonthNo#期返现#ReturnAmount#元。在本宿钱包中查收哦。";
    public static final String SMS_TEMPLATE_CHECK_OUT_REMIND = SMS_SIGNATURE
            + "亲，还有半小时你的房间的时间就到了，如果要续订请联系前台。";

    //运营系统相关
    public static final String SMS_TEMPLATE_OC_NEW_REFUND_ORDER_TO_ADMIN = SMS_SIGNATURE
            + "运营后台有一笔新的退款订单，请及时处理！";
    public static final String SMS_TEMPLATE_OC_REFUND_ORDER_SUCCESS_TO_USER = SMS_SIGNATURE
            + "您在#hotelName#的#orderNo#订单退款成功，请及时查看！";
    public static final String SMS_TEMPLATE_OC_REFUND_ORDER_DENY_TO_USER = SMS_SIGNATURE
            + "您在#hotelName#的#orderNo#订单申请退款已被拒绝，如有疑问，请联系客服#serviceTel#！";
    public static final String SMS_TEMPLATE_OC_REFUND_ORDER_FAIL_TO_ADMIN = SMS_SIGNATURE
            + "运营后台有一笔订单，#reason#，退款失败，请及时处理！";

    public static final String SMS_TEMPLATE_CMS_CREATE_LOGIN_PASSWORD = SMS_SIGNATURE
            + "尊敬的邸客合作酒店，您的该手机为登录系统的帐号，初始密码为#password#，使用电脑端登录入口为：http://cms.devkeep.com/ 。";

    //合伙人
    public static final String SMS_TEMPLATE_CREATE_PARTNER_CITY = SMS_SIGNATURE
            + "亲爱的小伙伴，您的该手机已经设定为邸客互娱安装系统的账号。初始密码为#password#，安装设备时需用到账号及密码。";
    public static final String SMS_TEMPLATE_CREATE_PARTNER_INSTALL = SMS_SIGNATURE
            + "尊敬的邸客城市合伙人，您的该手机为登录合伙人系统的帐号，初始密码为#password#，为保障帐号安全建议你初次登录系统时修改您的密码。使用电脑端登陆入口为：http://p.devkeep.com/ 。手机端登陆时，请关注‘邸客互娱客房’公众号—我的—邸客合伙人，实时掌控收益情况。 ";
    public static final String SMS_TEMPLATE_CREATE_PARTNER_ACCOUNT = SMS_SIGNATURE
            + "亲爱的小伙伴，您的该手机为登录系统的帐号，初始密码为#password#，使用电脑端登录入口为：http://p.devkeep.com/ 。";
    public static final String SMS_TEMPLATE_CREATE_PARTNER = SMS_SIGNATURE
            + "该手机为登录合伙人系统的帐号，初始密码#password#，请关注‘邸客互娱客房’公众号—我的—合伙人。若具有安装权限可登录设备小程序。";

    //联席合伙人
    public static final String SMS_TEMPLATE_CREATE_JOINT_PARTNER_ACCOUNT = SMS_SIGNATURE
            + "尊敬的邸客联席合伙人，请登录‘邸客互娱客房’公众号-我的-邸客联席合伙人，该手机号为您的登录账号，初始密码为#password#。";
    public static final String SMS_TEMPLATE_CREATE_ALL_PARTNER_ACCOUNT = SMS_SIGNATURE
            + "尊敬的邸客合伙人，请登录‘邸客互娱客房’公众号-我的-邸客合伙人，该手机号为您的登录账号，初始密码为#password#。";

    public static final String SMS_TEMPLATE_HOTEL_AUDIT_SIGN_FAIL = SMS_SIGNATURE + "尊敬的邸客合伙人，您提交的#hotelName#的签约信息未审核通过，详情请在电脑端查看。";
    public static final String SMS_TEMPLATE_HOTEL_AUDIT_COMPLETE_FAIL = SMS_SIGNATURE + "尊敬的邸客合作酒店，您的酒店信息完善审核未通过，详情请在电脑端查看。";
    public static final String SMS_TEMPLATE_HOTEL_AUDIT_COMPLETE_SUCCESS = SMS_SIGNATURE + "尊敬的邸客合作酒店，您的酒店信息完善审核已通过。";
    public static final String SMS_TEMPLATE_HOTEL_AUDIT_PARTNER_COMPLETE_FAIL = SMS_SIGNATURE + "尊敬的邸客合作酒店，您合作的#hotelName#提交的酒店信息完善审核未通过，详情请在电脑端查看。";
    public static final String SMS_TEMPLATE_HOTEL_AUDIT_PARTNER_COMPLETE_SUCCESS = SMS_SIGNATURE + "尊敬的邸客合伙人，您合作的#hotelName#提交的酒店信息完善审核已通过。";
    public static final String SMS_TEMPLATE_HOTEL_AUDIT_INSTALLED_FAIL = SMS_SIGNATURE + "尊敬的邸客合作酒店，您提交的设备已安装审核未通过，详情请在电脑端查看。";
    public static final String SMS_TEMPLATE_HOTEL_AUDIT_PARTNER_INSTALLED_FAIL = SMS_SIGNATURE + "尊敬的邸客合作酒店，您合作的#hotelName#提交的设备已安装审核未通过，详情请在电脑端查看。";
    public static final String SMS_TEMPLATE_HOTEL_INTALL_LOCAL_VIDEO_SERVER = SMS_SIGNATURE + "#hotelName#采用局域网方式，请线下联系确认！";
    public static final String SMS_TEMPLATE_HOTEL_START_CALC_INCOME = SMS_SIGNATURE + "尊敬的邸客合伙人，您合作的#hotelName#，已开通收益计费。";
    public static final String SMS_TEMPLATE_HOTEL_CREATE_ACCOUNT_SUCCESS = SMS_SIGNATURE + "尊敬的#hotelName#，您的该手机为登录系统的帐号，使用电脑端登录入口为：http://cms.devkeep.com/ 。";

    public static final String SMS_TEMPLATE_HOTEL_SERVER_OFFLINE = SMS_SIGNATURE + "#region##address#的#hotel#的服务器已离线，请及时处理。";

    /**
     * 忘记登录密码
     */
    public static final SmsContentItem SMS_CONTENT_ITEM_FORGET_LOGIN_PASSWORD = new SmsContentItem(
            SMS_CODE_FORGET_LOGIN_PASSWORD, SMS_SIGNATURE + "#code# (有效期#minute#分钟)，如非本人操作，请忽略本短信。");
    public static final SmsContentItem SMS_CONTENT_ITEM_SMS_CODE_REGISTER = new SmsContentItem(
            SMS_CODE_REGISTER, SMS_SIGNATURE + "#code# (有效期#minute#分钟)，如非本人操作，请忽略本短信。");
    public static final SmsContentItem SMS_CONTENT_ITEM_MODIFY_MOBILE = new SmsContentItem(
            SMS_CODE_MODIFY_MOBILE, SMS_SIGNATURE + "#code# (有效期#minute#分钟)，如非本人操作，请忽略本短信。");
    public static final SmsContentItem SMS_CONTENT_ITEM_MODIFY_LOGIN_PASSWORD = new SmsContentItem(
            SMS_CODE_MODIFY_LOGIN_PASSWORD, SMS_SIGNATURE + "#code# (有效期#minute#分钟)，如非本人操作，请忽略本短信。");
    public static final SmsContentItem SMS_CONTENT_ITEM_MODIFY_PAY_PASSWORD = new SmsContentItem(
            SMS_CODE_MODIFY_PAY_PASSWORD, SMS_SIGNATURE + "#code# (有效期#minute#分钟)，如非本人操作，请忽略本短信。");
    public static final SmsContentItem SMS_CONTENT_ITEM_FORGET_PAY_PASSWORD = new SmsContentItem(
            SMS_CODE_FORGET_PAY_PASSWORD, SMS_SIGNATURE + "#code# (有效期#minute#分钟)，如非本人操作，请忽略本短信。");
    public static final SmsContentItem SMS_CONTENT_ITEM_OPERATE_CAPITAL = new SmsContentItem(
            SMS_CODE_OPERATE_CAPITAL, SMS_SIGNATURE + "#code# (有效期#minute#分钟)，如非本人操作，请忽略本短信。");
    public static final SmsContentItem SMS_CONTENT_ITEM_APPLY_CASH = new SmsContentItem(
            SMS_CODE_APPLY_CASH, SMS_SIGNATURE + "#code# (有效期#minute#分钟)，如非本人操作，请忽略本短信。");
    public static final SmsContentItem SMS_CONTENT_ITEM_BIND_APPLY_CASH_ACCOUNT = new SmsContentItem(
            SMS_CODE_BIND_APPLY_CASH_ACCOUNT, SMS_SIGNATURE + "#code# (有效期#minute#分钟)，如非本人操作，请忽略本短信。");
    public static final SmsContentItem SMS_CONTENT_NORMAL_CHECK_MOBILE = new SmsContentItem(
        SMS_CODE_NORMAL_CHECK_MOBILE, SMS_SIGNATURE + "#code# (有效期#minute#分钟)，如非本人操作，请忽略本短信。");

}
