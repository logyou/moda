package com.moda.util.alipay;

import com.alipay.api.AlipayApiException;
import com.alipay.api.internal.util.AlipaySignature;
import com.moda.entity.alipay.config.AlipayConfig;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;

/**
 * 支付宝支付回调处理工具类
 *
 * @author lyh
 * @version 2018-11-26 17:39:05
 */
public class AlipayNotifyUtils {

    /**
     * 支付宝消息验证地址
     */
    private static final String HTTPS_VERIFY_URL = "https://mapi.alipay.com/gateway.do?service=notify_verify&";

    /**
     * 验证消息是否是支付宝发出的合法消息
     *
     * @param params 通知返回来的参数数组
     * @return 验证结果
     */
    public static boolean verify(Map<String, String> params, String partnerId, String apiKey) {
        // 判断responsetTxt是否为true，isSign是否为true
        // responsetTxt的结果不是true，与服务器设置问题、合作身份者ID、notify_id一分钟失效有关
        // isSign不是true，与安全校验码、请求时的参数格式（如：带自定义参数等）、编码格式有关
        String responseTxt = "true";
        if (params.get("notify_id") != null) {
            String notify_id = params.get("notify_id");
            responseTxt = verifyResponse(notify_id, partnerId);
        }
        String sign = "";
        if (params.get("sign") != null) {
            sign = params.get("sign");
        }
        boolean isSign = getSignVerify(params, sign, apiKey);

        if (isSign && responseTxt.equals("true")) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 根据反馈回来的信息，生成签名结果
     *
     * @param params 通知返回来的参数数组
     * @param sign   比对的签名结果
     * @return 生成的签名结果
     */
    private static boolean getSignVerify(Map<String, String> params, String sign, String apiKey) {
        // 过滤空值、sign与sign_type参数
        Map<String, String> sParaNew = AlipayCoreUtils.paraFilter(params);
        // 获取待签名字符串
        String preSignStr = AlipayCoreUtils.createLinkString(sParaNew);
        // 获得签名验证结果
        boolean isSign = false;
        String signType = params.get("sign_type");
        if (AlipayConfig.MD5.equals(signType)) {
            isSign = AlipayCoreUtils.verify(preSignStr, sign, apiKey, AlipayConfig.INPUT_CHARSET);
        } else if (AlipayConfig.RSA.equals(signType)) {
            isSign = getRSASignVerify(params, sign);
        }
        return isSign;
    }

    /**
     * 根据反馈回来的信息，生成 RSA 签名结果
     *
     * @param params 通知返回来的参数数组
     * @param sign   比对的签名结果
     * @return 生成的签名结果
     */
    private static boolean getRSASignVerify(Map<String, String> params, String sign) {
        //过滤空值、sign与sign_type参数
        Map<String, String> sParaNew = AlipayCoreUtils.paraFilter(params);
        //获取待签名字符串
        String preSignStr = AlipayCoreUtils.createLinkString(sParaNew);
        //获得签名验证结果
        boolean isSign = false;
        try {
            isSign = AlipaySignature.rsaCheckContent(preSignStr, sign, AlipayConfig.ALIPAY_PUBLIC_KEY, AlipayConfig.CHARSET);
        } catch (AlipayApiException e) {
            e.printStackTrace();
        }

        return isSign;
    }

    /**
     * 获取远程服务器ATN结果,验证返回URL
     *
     * @param notifyId 通知校验ID
     * @return 服务器ATN结果 验证结果集： invalid命令参数不对 出现这个错误，请检测返回处理中partner和key是否为空 true
     * 返回正确信息 false 请检查防火墙或者是服务器阻止端口问题以及验证时间是否超过一分钟
     */
    private static String verifyResponse(String notifyId, String partnerId) {
        // 获取远程服务器ATN结果，验证是否是支付宝服务器发来的请求
        String verifyUrl = HTTPS_VERIFY_URL + "partner=" + partnerId + "&notify_id=" + notifyId;
        return checkUrl(verifyUrl);
    }

    /**
     * 获取远程服务器ATN结果
     *
     * @param urlvalue 指定URL路径地址
     * @return 服务器ATN结果 验证结果集： invalid命令参数不对 出现这个错误，请检测返回处理中partner和key是否为空 true
     * 返回正确信息 false 请检查防火墙或者是服务器阻止端口问题以及验证时间是否超过一分钟
     */
    private static String checkUrl(String urlvalue) {
        String inputLine = "";

        try {
            URL url = new URL(urlvalue);
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            BufferedReader in = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
            inputLine = in.readLine().toString();
        } catch (Exception e) {
            e.printStackTrace();
            inputLine = "";
        }

        return inputLine;
    }
}
