package com.moda.util.security;

import com.moda.util.lang.StringUtils;
import org.apache.commons.codec.digest.DigestUtils;

import java.nio.charset.StandardCharsets;

/**
 * MD5 工具类
 *
 * @author lyh
 * @create 2018-08-31 10:06
 **/
public class Md5Utils {

    /**
     * 生产MD5
     *
     * @param text 文本
     * @return md5
     */
    public static String md5(String text) {
        if (StringUtils.isEmpty(text)) {
            return null;
        }
        return DigestUtils.md5Hex(text.getBytes(StandardCharsets.UTF_8));
    }
}
