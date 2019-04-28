package com.moda.util.weixin;

import com.moda.entity.weixin.WxAccount;
import com.moda.util.codec.EncodeUtils;
import com.moda.util.date.DateUtils;
import com.moda.util.http.UrlUtils;
import com.moda.util.lang.StringUtils;
import com.moda.util.security.DigestUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Random;
import java.util.Set;
import java.util.SortedMap;

/**
 * 微信签名工具类
 *
 * @author lyh
 * @version 1.0 2016-05-16
 */
public class WxSignUtils {
    private static Logger log = LoggerFactory.getLogger(WxSignUtils.class);

    /**
     * 生成随机数
     *
     * @param length 长度
     * @return
     */
    public static String createNoncestr(int length) {
        String chars = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        String res = "";
        for (int i = 0; i < length; i++) {
            Random rd = new Random();
            res += chars.indexOf(rd.nextInt(chars.length() - 1));
        }
        return res;
    }

    /**
     * 生成随机数
     *
     * @return
     */
    public static String createNoncestr() {
        String chars = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        String res = "";
        for (int i = 0; i < 16; i++) {
            Random rd = new Random();
            res += chars.charAt(rd.nextInt(chars.length() - 1));
        }
        return res;
    }

    /**
     * 以秒为单位的时间戳
     *
     * @return
     */
    public static long getTimeStamp() {
        return DateUtils.getTimeInSeconds();
    }

    /**
     * 验证微信支付回调是否合法
     *
     * @param sm 参数
     * @return
     */
    public static boolean validPaySign(SortedMap<String, Object> sm, WxAccount wxAccount) {
        try {
            String sign = createPaySign(sm, wxAccount);
            log.info("---local-sign-->" + sign);
            log.info("--server-sign-->" + sm.get("sign"));
            return StringUtils.isNoneBlank(sign) && sign.equals(sm.get("sign"));
        } catch (Exception e) {
            log.error(e.getLocalizedMessage());
            e.printStackTrace();
        }
        return false;
    }

    public static byte[] stringToByteArray(String s) {
        return EncodeUtils.stringToByteArray(s, "UTF-8");
    }

    /**
     * 微信支付签名
     *
     * @param parameters
     * @param wxAccount
     * @return
     */
    public static String createPaySign(SortedMap<String, Object> parameters, WxAccount wxAccount) {
        StringBuffer sb = new StringBuffer();
        Set<Entry<String, Object>> es = parameters.entrySet();
        Iterator<Entry<String, Object>> it = es.iterator();
        while (it.hasNext()) {
            Entry<String, Object> entry = it.next();
            String k = entry.getKey();
            Object v = entry.getValue();
            if (null != v && !"".equals(v) && !"sign".equals(k) && !"key".equals(k)) {
                sb.append(k + "=" + v + "&");
            }
        }
        sb.append("key=" + wxAccount.getApiSecret());
        byte[] bytes = DigestUtils.md5(stringToByteArray(sb.toString()));
        return EncodeUtils.encodeHex(bytes).toUpperCase();
    }

    /**
     * JSAPI 签名
     *
     * @param map
     * @return
     */
    public static String createJsApiSign(SortedMap<String, Object> map) {
        String params = UrlUtils.createLinkString(map);
        byte[] bytes = DigestUtils.sha1(stringToByteArray(params));
        return EncodeUtils.encodeHex(bytes);
    }
}
