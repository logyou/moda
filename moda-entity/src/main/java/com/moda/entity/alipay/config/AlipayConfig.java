package com.moda.entity.alipay.config;


/**
 * 支付宝基础配置
 *
 * @author lyh
 * @version 1.0 2016-06-23
 */
public class AlipayConfig {
    /**
     * 支付宝公钥-从支付宝服务窗获取
     */
    public static final String ALIPAY_PUBLIC_KEY = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDDI6d306Q8fIfCOaTXyiUeJHkrIvYISRcc73s3vF1ZT7XN8RNPwJxo8pWaJMmvyTn9N4HQ632qJBVHf8sxHi/fEsraprwCtzvzQETrNRwVxLO5jVmRGi60j8Ue1efIlzPXV9je9mkjzOmdssymZkh2QhUrCmZYI/FCEa3/cNMW0QIDAQAB";

    /**
     * 签名编码-视支付宝服务窗要求
     */
    public static final String SIGN_CHARSET = "UTF-8";

    /**
     * 字符编码-传递给支付宝的数据编码
     */
    public static final String CHARSET = "UTF-8";

    /**
     * 签名类型-视支付宝服务窗要求
     */
    public static final String SIGN_TYPE = "RSA";

    /**
     * 数据格式
     */
    public static final String FORMAT = "json";

    /**
     * 支付宝网关
     */
    public static final String ALIPAY_GATEWAY = "https://openapi.alipay.com/gateway.do";

    /**
     * 授权访问令牌的授权类型
     */
    public static final String GRANT_TYPE = "authorization_code";
    /**
     * 合作身份者ID，以2088开头由16位纯数字组成的字符串
     */
    public static String PARTNER;
    /**
     * 收款支付宝账号，以2088开头由16位纯数字组成的字符串
     */
    public static String SELLER_ID;
    /**
     * 商户的私钥
     */
    public static String KEY;
    /**
     * 日志记录位置
     */
    public final static String LOG_PATH = "/data/";
    /**
     * 字符编码格式 目前支持 gbk 或 utf-8
     */
    public final static String INPUT_CHARSET = "utf-8";
    /**
     * 签名方式 MD5
     */
    public final static String MD5 = "MD5";
    /**
     * 签名方式 RSA
     */
    public final static String RSA = "RSA";
    /**
     * 支付类型。仅支持：1（商品购买）。
     */
    public final static String PAYMENT_TYPE = "1";
    /**
     * 成功
     */
    public final static String SUCCESS = "success";
    /**
     * 失败
     */
    public final static String FAIL = "fail";
    /**
     * 即时到帐支付移动版服务
     */
    public final static String SERVICE_TYPE_PAY_BY_WAP = "alipay.wap.create.direct.pay.by.user";
    /**
     * 即时到帐支付电脑版服务
     */
    public final static String SERVICE_TYPE_PAY_BY_PC = "create_direct_pay_by_user";
    /**
     * 即时到账批量退款有密接口
     */
    public final static String SERVICE_TYPE_REFUND_BY_PWD = "refund_fastpay_by_platform_pwd";
    /**
     * 即时到账批量退款无密接口
     */
    public final static String SERVICE_TYPE_REFUND_BY_NOPWD = "refund_fastpay_by_platform_nopwd";
    /**
     * 交易完成
     */
    public final static String TRADE_FINISHED = "TRADE_FINISHED";
    /**
     * 交易成功
     */
    public final static String TRADE_SUCCESS = "TRADE_SUCCESS";
}