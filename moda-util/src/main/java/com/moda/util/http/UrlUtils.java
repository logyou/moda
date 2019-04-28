package com.moda.util.http;

import com.moda.util.lang.StringUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 * URL 处理类
 *
 * @author lyh
 * @version 1.0 2016-05-16
 */
public class UrlUtils {
    /**
     * 对url添加或追加某一属性，可处理编码化url
     *
     * @param url
     * @param value 属性值
     * @param key   属性名
     * @return
     */
    public static String addUrlParams(String url, String key, String value) {
        if (StringUtils.isEmpty(url) || StringUtils.isEmpty(key) || StringUtils.isEmpty(value)) {
            return url;
        }

        String a = "";
        if (!url.contains("/")) {// 编码后的URL不可能存在/
            // 编码化url处理 %3F->? %3D->=
            if (url.contains("%3F") && !url.contains("%3D")) {
                a = "";
            } else if (url.contains("%3F") && url.contains("%3D")) {
                a = "%26";
            } else {
                a = "%3F";
            }
        } else {
            // 非编码化url处理
            if (url.contains("?") && !url.contains("=")) {// http://a.com?
                a = "";
            } else if (url.contains("?") && url.contains("=")) {// http://a.com?a=b
                a = "&";
            } else {
                a = "?";
            }
        }
        return url += (a + key + "=" + value);
    }

    /**
     * 把数组所有元素排序，并按照“参数=参数值”的模式用“&”字符拼接成字符串
     *
     * @param params 需要排序并参与字符拼接的参数组
     * @return 拼接后字符串
     */
    public static String createLinkString(Map<String, Object> params) {
        List<String> keys = new ArrayList<String>(params.keySet());
        Collections.sort(keys);
        String prestr = "";

        for (int i = 0; i < keys.size(); i++) {
            String key = keys.get(i);
            String value = String.valueOf(params.get(key));

            if (i == keys.size() - 1) {// 拼接时，不包括最后一个&字符
                prestr = prestr + key + "=" + value;
            } else {
                prestr = prestr + key + "=" + value + "&";
            }
        }

        return prestr;
    }
}
