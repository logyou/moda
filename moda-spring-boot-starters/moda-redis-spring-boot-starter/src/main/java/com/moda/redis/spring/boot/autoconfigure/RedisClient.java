package com.moda.redis.spring.boot.autoconfigure;

import com.moda.util.mapper.JsonMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.util.StringUtils;

import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * Redis 客户端操作类
 * 基于 Spring Data Redis 的 StringRedisTemplate 封装
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

    /**
     * 设置字符串键值
     *
     * @param key   键名
     * @param value 键值
     */
    public void set(String key, String value) {
        stringRedisTemplate.opsForValue().set(key, value);
    }

    /**
     * 设置字符串键值
     *
     * @param key     键名
     * @param value   键值
     * @param timeout 失效时间（单位：秒）
     */
    public void set(String key, String value, long timeout) {
        stringRedisTemplate.opsForValue().set(key, value, timeout, TimeUnit.SECONDS);
    }

    /**
     * 获取字符串键值
     *
     * @param key 键名
     * @return 键值
     */
    public String get(String key) {
        return stringRedisTemplate.opsForValue().get(key);
    }

    /**
     * 设置 Hash 中字段的字符串类型的值
     * 对应获取方法 getHashStringField
     *
     * @param key   键名
     * @param field 字段
     * @param value 字符串类型值
     */
    public void setHashStringField(String key, String field, String value) {
        stringRedisTemplate.opsForHash().put(key, field, value);
    }

    /**
     * 获取 Hash 中指定字段的字符串类型的值
     * 对应设置方法 setHashStringField
     *
     * @param key   键名
     * @param field 字段
     * @return 字符串类型数据
     */
    public String getHashStringField(String key, String field) {
        return (String) stringRedisTemplate.opsForHash().get(key, field);
    }

    /**
     * 设置 Hash 中字段的对象类型的值
     * 对应获取方法 getHashObjectField
     *
     * @param key   键名
     * @param field 字段
     * @param value 对象类型值
     */
    public void setHashObjectField(String key, String field, Object value) {
        stringRedisTemplate.opsForHash().put(key, field, JsonMapper.toJsonString(value));
    }

    /**
     * 获取 Hash 中指定字段的对象类型的值
     * 对应设置方法 setHashObjectField
     *
     * @param key   键名
     * @param field 字段
     * @param t     类型
     * @param <T>   对象
     * @return 对象类型值
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
    public void setHashObject(String key, Map<String, Object> map, long timeout) {
        for (Map.Entry entry : map.entrySet()) {
            setHashObjectField(key, (String) entry.getKey(), map.get(entry.getKey()));
        }
        stringRedisTemplate.expire(key, timeout, TimeUnit.SECONDS);
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
