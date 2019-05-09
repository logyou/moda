package com.moda.redis.spring.boot.autoconfigure;

import com.moda.util.mapper.JsonMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.util.StringUtils;

import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * Redis 客户端操作
 *
 * @author lyh
 * @date 2019-05-09
 **/
public class RedisClient {
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    /**
     * 是否存在键名
     *
     * @param key 键名
     * @return true-存在；false-不存在
     */
    public Boolean hasKey(String key) {
        return stringRedisTemplate.hasKey(key);
    }

    /**
     * 设置过期时间
     *
     * @param key     键名
     * @param timeout 过期时间（单位：秒）
     * @return Boolean
     */
    public Boolean expire(String key, long timeout) {
        return stringRedisTemplate.expire(key, timeout, TimeUnit.SECONDS);
    }

    /**
     * 删除指定键名数据
     *
     * @param key 键名
     * @return Boolean
     */
    public Boolean delete(String key) {
        return stringRedisTemplate.delete(key);
    }

    public void set(String key, String value) {
        stringRedisTemplate.opsForValue().set(key, value);
    }

    public String get(String key) {
        return stringRedisTemplate.opsForValue().get(key);
    }

    public void set(String key, String value, long timeout) {
        stringRedisTemplate.opsForValue().set(key, value, timeout);
    }

    /**
     * 获取 Hash 中指定字段的字符串类型的值
     *
     * @param key   键名
     * @param field 字段
     * @return 字符串类型数据
     */
    public String getHashStringField(String key, String field) {
        return (String) stringRedisTemplate.opsForHash().get(key, field);
    }

    /**
     * 获取 Hash 中指定字段的对象类型的值
     *
     * @param key   键名
     * @param field 字段
     * @param t     类型
     * @param <T>   对象
     * @return 对象类型数据
     */
    public <T> T getHashObjectField(String key, String field, Class<T> t) {
        String json = (String) stringRedisTemplate.opsForHash().get(key, field);
        if (StringUtils.isEmpty(json)) {
            return null;
        }
        return JsonMapper.parseObject(json, t);
    }

    /**
     * 设置 Hash 值
     *
     * @param key     键名
     * @param map     MAP
     * @param timeout 超时时间（单位：秒）
     */
    public void setHashObject(String key, Map<String, String> map, long timeout) {
        stringRedisTemplate.opsForHash().putAll(key, map);
        stringRedisTemplate.expire(key, timeout, TimeUnit.SECONDS);
    }

    /**
     * 设置 Hash 字段的值
     *
     * @param key   键名
     * @param field 字段
     * @param value 字符串类型值
     */
    public void setHashStringField(String key, String field, String value) {
        stringRedisTemplate.opsForHash().put(key, field, value);
    }

    /**
     * 设置 Hash 字段的值
     *
     * @param key   键名
     * @param field 字段
     * @param value 对象类型值
     */
    public void setHashObjectField(String key, String field, Object value) {
        stringRedisTemplate.opsForHash().put(key, field, JsonMapper.toJsonString(value));
    }

    /**
     * 删除 Hash 中指定字段的值
     *
     * @param key   键名
     * @param field 字段
     * @return Long
     */
    public Long deleteHashField(String key, String field) {
        return stringRedisTemplate.opsForHash().delete(key, field);
    }

    /**
     * 判断 Hash 中指定的字段是否存在
     *
     * @param key   键名
     * @param field 字段
     * @return true-存在；false-不存在
     */
    public Boolean hasHashField(String key, String field) {
        return stringRedisTemplate.opsForHash().hasKey(key, field);
    }
}
