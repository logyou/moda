package com.moda.util.mapper;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * JSON 转换工具
 *
 * @author lyh
 * @create 2018-9-26
 **/
public class JsonMapper {
    private static final Logger logger = LoggerFactory.getLogger(JsonMapper.class);

    /**
     * 把对象转化为JSON字符串
     *
     * @param object 对象
     * @return JSON字符串
     */
    public static String toJsonString(Object object) {
        try {
            return JSON.toJSONString(object);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
        return null;
    }

    /**
     * 把JSON字符串转换为对象
     *
     * @param json JSON字符串
     * @param t    类型
     * @param <T>  类型
     * @return 对象
     */
    public static <T> T parseObject(String json, Class<T> t) {
        try {
            return JSON.parseObject(json, t);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
        return null;
    }

    /**
     * 把JSON字符串转换为列表
     *
     * @param json JSON字符串
     * @param t    类型
     * @param <T>  类型
     * @return 对象
     */
    public static <T> List<T> parseArray(String json, Class<T> t) {
        try {
            return JSON.parseArray(json, t);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
        return null;
    }

    /**
     * 把JSON字符串转换为列表
     *
     * @param json JSON字符串
     * @return 对象
     */
    public static JSONArray parseArray(String json) {
        try {
            return JSON.parseArray(json);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
        return null;
    }

    /**
     * 格式化输出字符串
     *
     * @param object 对象
     * @return JSON字符串
     */
    public static String toJsonStringIndent(Object object) {
        try {
            return JSON.toJSONString(object, true);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
        return null;
    }
}
