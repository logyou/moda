package com.moda.entity.rest;

import com.moda.entity.BaseEntity;

/**
 * 接口返回状态
 *
 * @author lyh
 * @create 2018-9-21
 **/
public class Status extends BaseEntity {
    /**
     * 未登录
     */
    public static final int NOT_LOGIN = -1;
    /**
     * 失败
     */
    public static final int FAIL = 0;
    /**
     * 成功
     */
    public static final int SUCCESS = 1;
    /**
     * 未设置登录密码
     */
    public static final int UNSET_LOGIN_PASSWORD = -2001;
    /**
     * 未设置支付密码
     */
    public static final int UNSET_PAY_PASSWORD = -2002;
    /**
     * 登录二维码已过期
     */
    public static final int LOGIN_QRCODE_ALREADY_EXPIRED = -2003;
    /**
     * 需要扫描房间屏幕上的二维码
     */
    public static final int NEED_SCAN_SCREEN_QR_CODE = -2004;
    /**
     * 无效的商户号
     */
    public static final int MCHNO_NOT_EXIST = -3001;
    /**
     * 无效的用户标识
     */
    public static final int USER_CODE_NOT_EXIST = -3002;
    /**
     * 未设置API秘钥
     */
    public static final int API_KEY_NOT_EXIST = -3003;
    /**
     * 签名错误
     */
    public static final int API_SIGN_ERROR = -3004;
    /**
     * 商户订单号重复
     */
    public static final int OUT_TRADE_NO_USED = -3005;
    /**
     * 糖果余额不足
     */
    public static final int SWEET_NOT_ENOUGH = -3006;
    /**
     * 红包已领完
     */
    public static final int RED_PACKET_FINISHED = -4001;
    /**
     * 红包已过期
     */
    public static final int RED_PACKET_EXPIRED = -4002;
}
