package com.moda.util.cache;

import com.moda.util.converter.ConvertUtils;
import com.moda.util.lang.ObjectUtils;
import com.moda.util.lang.StringUtils;
import com.moda.util.mapper.JsonMapper;
import com.moda.util.spring.SpringContextHolder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.util.*;

/**
 * Jedis Cache 工具类
 *
 * @author lyh
 * @version 2018-08-30 22:20:01
 */
public class JedisUtils {
    private static Logger logger = LoggerFactory.getLogger(JedisUtils.class);
    private static JedisPool jedisPool = SpringContextHolder.getBean(JedisPool.class);
    private static String NIL = "nil";

    /**
     * 获取资源
     *
     * @return Jedis
     */
    public static Jedis getResource() {
        try {
            return jedisPool.getResource();
        } catch (Exception e) {
            logger.error("getResource()", e);
            throw e;
        }
    }

    /**
     * 获取缓存
     *
     * @param key 键
     * @return 值
     */
    public static String get(String key) {
        Jedis jedis = null;
        String value = null;
        try {
            jedis = getResource();
            value = jedis.get(key);
            logger.debug("get {} ==> matched:{}", key, StringUtils.isNotEmpty(value));
        } catch (Exception e) {
            logger.error("get " + key, e);
        } finally {
            returnResource(jedis);
        }
        return value;
    }

    /**
     * 设置缓存
     *
     * @param key          键
     * @param value        值
     * @param cacheSeconds 超时时间，0为不超时
     * @return 响应状态码
     */
    public static String set(String key, String value, int cacheSeconds) {
        String result = null;
        Jedis jedis = null;
        try {
            jedis = getResource();
            result = jedis.set(key, value);
            logger.debug("status = {}", result);
            if (cacheSeconds != 0) {
                jedis.expire(key, cacheSeconds);
            }
            logger.info("set {} = {}", key, value);
        } catch (Exception e) {
            logger.error(String.format("set %s = %s", key, value), e);
        } finally {
            returnResource(jedis);
        }
        return result;
    }

    /**
     * 获取 int 类型值
     *
     * @param key          键
     * @param defaultValue 如果获取失败，默认返回的值
     * @return 整数值
     */
    public static int getInt(String key, int defaultValue) {
        return ConvertUtils.getInt(get(key), defaultValue);
    }

    /**
     * 存储 int 类型值
     *
     * @param key          键
     * @param value        值
     * @param cacheSeconds 超时时间，0为不超时
     * @return 结果
     */
    public static String setInt(String key, int value, int cacheSeconds) {
        return set(key, String.valueOf(value), cacheSeconds);
    }

    /**
     * 获取 Integer 类型值
     *
     * @param key          键
     * @param defaultValue 如果获取失败，默认返回的值
     * @return 整数值
     */
    public static Integer getInteger(String key, Integer defaultValue) {
        return ConvertUtils.getInteger(get(key), defaultValue);
    }

    /**
     * 获取从JSON字符串转换的对象
     *
     * @param key 键
     * @param t   类型
     * @param <T> 类型
     * @return 对象
     */
    public static <T> T getObjectFromJson(String key, Class<T> t) {
        return JsonMapper.parseObject(get(key), t);
    }

    /**
     * 获取从JSON字符串转换的列表
     *
     * @param key 键
     * @param t   类型
     * @param <T> 类型
     * @return 对象
     */
    public static <T> List<T> getArrayFromJson(String key, Class<T> t) {
        return JsonMapper.parseArray(get(key), t);
    }

    /**
     * 以JSON字符串形式存储对象
     *
     * @param key          键
     * @param value        值
     * @param cacheSeconds 超时时间，0为不超时
     * @return 结果
     */
    public static String setObjectToJson(String key, Object value, int cacheSeconds) {
        return set(key, JsonMapper.toJsonString(value), cacheSeconds);
    }

    /**
     * 获取缓存
     *
     * @param key 键
     * @return 值
     */
    public static Object getObject(String key) {
        Object value = null;
        Jedis jedis = null;
        try {
            jedis = getResource();
            if (jedis.exists(getBytesKey(key))) {
                value = toObject(jedis.get(getBytesKey(key)));
                logger.debug("getObject {} = {}", key, value);
            }
        } catch (Exception e) {
            logger.warn("getObject {} = {}", key, value, e);
        } finally {
            returnResource(jedis);
        }
        return value;
    }

    /**
     * 设置缓存
     *
     * @param key          键
     * @param value        值
     * @param cacheSeconds 超时时间，0为不超时
     * @return
     */
    public static String setObject(String key, Object value, int cacheSeconds) {
        String result = null;
        Jedis jedis = null;
        try {
            jedis = getResource();
            result = jedis.set(getBytesKey(key), toBytes(value));
            if (cacheSeconds != 0) {
                jedis.expire(key, cacheSeconds);
            }
            logger.debug("setObject {} = {}", key, value);
        } catch (Exception e) {
            logger.warn("setObject {} = {}", key, value, e);
        } finally {
            returnResource(jedis);
        }
        return result;
    }

    /**
     * 获取List缓存
     *
     * @param key 键
     * @return 值
     */
    public static List<String> getList(String key) {
        List<String> value = null;
        Jedis jedis = null;
        try {
            jedis = getResource();
            if (jedis.exists(key)) {
                value = jedis.lrange(key, 0, -1);
                logger.debug("getList {} = {}", key, value);
            }
        } catch (Exception e) {
            logger.warn("getList {} = {}", key, value, e);
        } finally {
            returnResource(jedis);
        }
        return value;
    }

    /**
     * 获取List缓存
     *
     * @param key 键
     * @return 值
     */
    public static List<Object> getObjectList(String key) {
        List<Object> value = null;
        Jedis jedis = null;
        try {
            jedis = getResource();
            if (jedis.exists(getBytesKey(key))) {
                List<byte[]> list = jedis.lrange(getBytesKey(key), 0, -1);
                value = new ArrayList<>();
                for (byte[] bs : list) {
                    value.add(toObject(bs));
                }
                logger.debug("getObjectList {} = {}", key, value);
            }
        } catch (Exception e) {
            logger.warn("getObjectList {} = {}", key, value, e);
        } finally {
            returnResource(jedis);
        }
        return value;
    }

    /**
     * 设置List缓存
     *
     * @param key          键
     * @param value        值
     * @param cacheSeconds 超时时间，0为不超时
     * @return
     */
    public static long setList(String key, List<String> value, int cacheSeconds) {
        long result = 0;
        Jedis jedis = null;
        try {
            jedis = getResource();
            if (jedis.exists(key)) {
                jedis.del(key);
            }
            result = jedis.rpush(key, (String[]) value.toArray());
            if (cacheSeconds != 0) {
                jedis.expire(key, cacheSeconds);
            }
            logger.debug("setList {} = {}", key, value);
        } catch (Exception e) {
            logger.warn("setList {} = {}", key, value, e);
        } finally {
            returnResource(jedis);
        }
        return result;
    }

    /**
     * 设置List缓存
     *
     * @param key          键
     * @param value        值
     * @param cacheSeconds 超时时间，0为不超时
     * @return
     */
    public static long setObjectList(String key, List<Object> value, int cacheSeconds) {
        long result = 0;
        Jedis jedis = null;
        try {
            jedis = getResource();
            if (jedis.exists(getBytesKey(key))) {
                jedis.del(key);
            }
            List<byte[]> list = new ArrayList<>();
            for (Object o : value) {
                list.add(toBytes(o));
            }
            result = jedis.rpush(getBytesKey(key), (byte[][]) list.toArray());
            if (cacheSeconds != 0) {
                jedis.expire(key, cacheSeconds);
            }
            logger.debug("setObjectList {} = {}", key, value);
        } catch (Exception e) {
            logger.warn("setObjectList {} = {}", key, value, e);
        } finally {
            returnResource(jedis);
        }
        return result;
    }

    /**
     * 向List缓存中添加值
     *
     * @param key   键
     * @param value 值
     * @return
     */
    public static long listAdd(String key, String... value) {
        long result = 0;
        Jedis jedis = null;
        try {
            jedis = getResource();
            result = jedis.rpush(key, value);
            logger.debug("listAdd {} = {}", key, value);
        } catch (Exception e) {
            logger.warn("listAdd {} = {}", key, value, e);
        } finally {
            returnResource(jedis);
        }
        return result;
    }

    /**
     * 向List缓存中添加值
     *
     * @param key   键
     * @param value 值
     * @return
     */
    public static long listObjectAdd(String key, Object... value) {
        long result = 0;
        Jedis jedis = null;
        try {
            jedis = getResource();
            List<byte[]> list = new ArrayList<>();
            for (Object o : value) {
                list.add(toBytes(o));
            }
            result = jedis.rpush(getBytesKey(key), (byte[][]) list.toArray());
            logger.debug("listObjectAdd {} = {}", key, value);
        } catch (Exception e) {
            logger.warn("listObjectAdd {} = {}", key, value, e);
        } finally {
            returnResource(jedis);
        }
        return result;
    }

    /**
     * 获取缓存
     *
     * @param key 键
     * @return 值
     */
    public static Set<String> getSet(String key) {
        Set<String> value = null;
        Jedis jedis = null;
        try {
            jedis = getResource();
            if (jedis.exists(key)) {
                value = jedis.smembers(key);
                logger.debug("getSet {} = {}", key, value);
            }
        } catch (Exception e) {
            logger.warn("getSet {} = {}", key, value, e);
        } finally {
            returnResource(jedis);
        }
        return value;
    }

    /**
     * 获取缓存
     *
     * @param key 键
     * @return 值
     */
    public static Set<Object> getObjectSet(String key) {
        Set<Object> value = null;
        Jedis jedis = null;
        try {
            jedis = getResource();
            if (jedis.exists(getBytesKey(key))) {
                value = new HashSet<>();
                Set<byte[]> set = jedis.smembers(getBytesKey(key));
                for (byte[] bs : set) {
                    value.add(toObject(bs));
                }
                logger.debug("getObjectSet {} = {}", key, value);
            }
        } catch (Exception e) {
            logger.warn("getObjectSet {} = {}", key, value, e);
        } finally {
            returnResource(jedis);
        }
        return value;
    }

    /**
     * 设置Set缓存
     *
     * @param key          键
     * @param value        值
     * @param cacheSeconds 超时时间，0为不超时
     * @return
     */
    public static long setSet(String key, Set<String> value, int cacheSeconds) {
        long result = 0;
        Jedis jedis = null;
        try {
            jedis = getResource();
            if (jedis.exists(key)) {
                jedis.del(key);
            }
            int size = value.size();
            result = jedis.sadd(key, value.toArray(new String[size]));
            if (cacheSeconds != 0) {
                jedis.expire(key, cacheSeconds);
            }
            logger.debug("setSet {} = {}", key, value);
        } catch (Exception e) {
            logger.warn("setSet {} = {}", key, value, e);
        } finally {
            returnResource(jedis);
        }
        return result;
    }

    /**
     * 设置Set缓存
     *
     * @param key          键
     * @param value        值
     * @param cacheSeconds 超时时间，0为不超时
     * @return
     */
    public static long setObjectSet(String key, Set<Object> value, int cacheSeconds) {
        long result = 0;
        Jedis jedis = null;
        try {
            jedis = getResource();
            if (jedis.exists(getBytesKey(key))) {
                jedis.del(key);
            }
            Set<byte[]> set = new HashSet<>();
            for (Object o : value) {
                set.add(toBytes(o));
            }
            result = jedis.sadd(getBytesKey(key), (byte[][]) set.toArray());
            if (cacheSeconds != 0) {
                jedis.expire(key, cacheSeconds);
            }
            logger.debug("setObjectSet {} = {}", key, value);
        } catch (Exception e) {
            logger.warn("setObjectSet {} = {}", key, value, e);
        } finally {
            returnResource(jedis);
        }
        return result;
    }

    /**
     * 向Set缓存中添加值
     *
     * @param key   键
     * @param value 值
     * @return
     */
    public static long setSetAdd(String key, String... value) {
        long result = 0;
        Jedis jedis = null;
        try {
            jedis = getResource();
            result = jedis.sadd(key, value);
            logger.debug("setSetAdd {} = {}", key, value);
        } catch (Exception e) {
            logger.warn("setSetAdd {} = {}", key, value, e);
        } finally {
            returnResource(jedis);
        }
        return result;
    }

    /**
     * 向Set缓存中添加值
     *
     * @param key   键
     * @param value 值
     * @return
     */
    public static long setSetObjectAdd(String key, Object... value) {
        long result = 0;
        Jedis jedis = null;
        try {
            jedis = getResource();
            Set<byte[]> set = new HashSet<>();
            for (Object o : value) {
                set.add(toBytes(o));
            }
            result = jedis.rpush(getBytesKey(key), (byte[][]) set.toArray());
            logger.debug("setSetObjectAdd {} = {}", key, value);
        } catch (Exception e) {
            logger.warn("setSetObjectAdd {} = {}", key, value, e);
        } finally {
            returnResource(jedis);
        }
        return result;
    }

    /**
     * 获取Map缓存
     *
     * @param key 键
     * @return 值
     */
    public static Map<String, String> getMap(String key) {
        Map<String, String> value = null;
        Jedis jedis = null;
        try {
            jedis = getResource();
            if (jedis.exists(key)) {
                value = jedis.hgetAll(key);
                logger.debug("getMap {} = {}", key, value);
            }
        } catch (Exception e) {
            logger.warn("getMap {} = {}", key, value, e);
        } finally {
            returnResource(jedis);
        }
        return value;
    }

    /**
     * 获取Map缓存
     *
     * @param key 键
     * @return 值
     */
    public static Map<String, Object> getObjectMap(String key) {
        Map<String, Object> value = null;
        Jedis jedis = null;
        try {
            jedis = getResource();
            if (jedis.exists(getBytesKey(key))) {
                value = new HashMap<>();
                Map<byte[], byte[]> map = jedis.hgetAll(getBytesKey(key));
                for (Map.Entry<byte[], byte[]> e : map.entrySet()) {
                    value.put(StringUtils.toString(e.getKey()), toObject(e.getValue()));
                }
                logger.debug("getObjectMap {} = {}", key, value);
            }
        } catch (Exception e) {
            logger.warn("getObjectMap {} = {}", key, value, e);
        } finally {
            returnResource(jedis);
        }
        return value;
    }

    /**
     * 获取Map缓存的字段值
     *
     * @param key 键
     * @return 值
     */
    public static String getMapField(String key, String field) {
        String value = null;
        Jedis jedis = null;
        try {
            jedis = getResource();
            if (jedis.exists(key)) {
                value = jedis.hget(key, field);
                logger.debug("getMapField {} {} = {}", key, field, value);
            }
        } catch (Exception e) {
            logger.error("getMapObjectField {} {} = {} failed", key, field, value);
            logger.error(e.getMessage(), e);
        } finally {
            returnResource(jedis);
        }
        return value;
    }

    /**
     * 获取Map缓存的字段值
     *
     * @param key 键
     * @return 值
     */
    public static Object getMapObjectField(String key, String field) {
        Object value = null;
        Jedis jedis = null;
        try {
            jedis = getResource();
            if (jedis.exists(getBytesKey(key))) {
                value = toObject(jedis.hget(getBytesKey(key), getBytesKey(field)));
                logger.debug("getMapObjectField {} = {}", key, value);
            }
        } catch (Exception e) {
            logger.warn("getMapObjectField {} = {}", key, value, e);
        } finally {
            returnResource(jedis);
        }
        return value;
    }

    /**
     * 设置Map缓存的字段值
     *
     * @param key 键
     * @return 值
     */
    public static Long setMapObjectField(String key, String field, Object value) {
        Long result = null;
        Jedis jedis = null;
        try {
            jedis = getResource();
            result = jedis.hset(getBytesKey(key), getBytesKey(field), getBytesKey(value));
            logger.debug("setMapObjectField {} = {}", key, field);
        } catch (Exception e) {
            logger.warn("setMapObjectField {} = {}", key, field, e);
        } finally {
            returnResource(jedis);
        }
        return result;
    }

    /**
     * 设置Map缓存
     *
     * @param key          键
     * @param value        值
     * @param cacheSeconds 超时时间，0为不超时
     * @return 状态
     */
    public static String setMap(String key, Map<String, String> value, int cacheSeconds) {
        String result = null;
        Jedis jedis = null;
        try {
            jedis = getResource();
            if (jedis.exists(key)) {
                jedis.del(key);
            }
            result = jedis.hmset(key, value);
            if (cacheSeconds != 0) {
                jedis.expire(key, cacheSeconds);
                logger.debug("setMap {} expire {}", key, cacheSeconds);
            }
            logger.debug("setMap {} = {}", key, value);
        } catch (Exception e) {
            logger.error("setMap {} = {}", key, value);
            logger.error(e.getMessage(), e);
        } finally {
            returnResource(jedis);
        }
        return result;
    }

    /**
     * 设置Map缓存
     *
     * @param key          键
     * @param value        值
     * @param cacheSeconds 超时时间，0为不超时
     * @return
     */
    public static String setObjectMap(String key, Map<String, Object> value, int cacheSeconds) {
        String result = null;
        Jedis jedis = null;
        try {
            jedis = getResource();
            if (jedis.exists(getBytesKey(key))) {
                jedis.del(key);
            }
            Map<byte[], byte[]> map = new HashMap<>();
            for (Map.Entry<String, Object> e : value.entrySet()) {
                map.put(getBytesKey(e.getKey()), toBytes(e.getValue()));
            }
            result = jedis.hmset(getBytesKey(key), map);
            if (cacheSeconds != 0) {
                jedis.expire(key, cacheSeconds);
            }
            logger.debug("setObjectMap {} = {}", key, value);
        } catch (Exception e) {
            logger.warn("setObjectMap {} = {}", key, value, e);
        } finally {
            returnResource(jedis);
        }
        return result;
    }

    /**
     * 向Map缓存中添加值
     *
     * @param key   键
     * @param value 值
     * @return
     */
    public static String mapPut(String key, Map<String, String> value) {
        String result = null;
        Jedis jedis = null;
        try {
            jedis = getResource();
            result = jedis.hmset(key, value);
            logger.debug("mapPut {} = {}", key, value);
        } catch (Exception e) {
            logger.warn("mapPut {} = {}", key, value, e);
        } finally {
            returnResource(jedis);
        }
        return result;
    }

    /**
     * 向Map缓存中添加值
     *
     * @param key   键
     * @param value 值
     * @return
     */
    public static String mapObjectPut(String key, Map<String, Object> value) {
        String result = null;
        Jedis jedis = null;
        try {
            jedis = getResource();
            Map<byte[], byte[]> map = new HashMap<>();
            for (Map.Entry<String, Object> e : value.entrySet()) {
                map.put(getBytesKey(e.getKey()), toBytes(e.getValue()));
            }
            result = jedis.hmset(getBytesKey(key), map);
            logger.debug("mapObjectPut {} = {}", key, value);
        } catch (Exception e) {
            logger.warn("mapObjectPut {} = {}", key, value, e);
        } finally {
            returnResource(jedis);
        }
        return result;
    }

    /**
     * 移除Map缓存中的值
     *
     * @param key    键
     * @param mapKey 值
     * @return
     */
    public static long mapRemove(String key, String mapKey) {
        long result = 0;
        Jedis jedis = null;
        try {
            jedis = getResource();
            result = jedis.hdel(key, mapKey);
            logger.debug("mapRemove {}  {}", key, mapKey);
        } catch (Exception e) {
            logger.warn("mapRemove {}  {}", key, mapKey, e);
        } finally {
            returnResource(jedis);
        }
        return result;
    }

    /**
     * 移除Map缓存中的值
     *
     * @param key    键
     * @param mapKey 值
     * @return
     */
    public static long mapObjectRemove(String key, String mapKey) {
        long result = 0;
        Jedis jedis = null;
        try {
            jedis = getResource();
            result = jedis.hdel(getBytesKey(key), getBytesKey(mapKey));
            logger.debug("mapObjectRemove {}  {}", key, mapKey);
        } catch (Exception e) {
            logger.warn("mapObjectRemove {}  {}", key, mapKey, e);
        } finally {
            returnResource(jedis);
        }
        return result;
    }

    /**
     * 判断Map缓存中的Key是否存在
     *
     * @param key    键
     * @param mapKey 值
     * @return
     */
    public static boolean mapExists(String key, String mapKey) {
        boolean result = false;
        Jedis jedis = null;
        try {
            jedis = getResource();
            result = jedis.hexists(key, mapKey);
            logger.debug("mapExists {}  {}", key, mapKey);
        } catch (Exception e) {
            logger.warn("mapExists {}  {}", key, mapKey, e);
        } finally {
            returnResource(jedis);
        }
        return result;
    }

    /**
     * 判断Map缓存中的Key是否存在
     *
     * @param key    键
     * @param mapKey 值
     * @return
     */
    public static boolean mapObjectExists(String key, String mapKey) {
        boolean result = false;
        Jedis jedis = null;
        try {
            jedis = getResource();
            result = jedis.hexists(getBytesKey(key), getBytesKey(mapKey));
            logger.debug("mapObjectExists {}  {}", key, mapKey);
        } catch (Exception e) {
            logger.warn("mapObjectExists {}  {}", key, mapKey, e);
        } finally {
            returnResource(jedis);
        }
        return result;
    }

    /**
     * 删除缓存
     *
     * @param key 键
     * @return
     */
    public static long del(String key) {
        long result = 0;
        Jedis jedis = null;
        try {
            jedis = getResource();
            if (jedis.exists(key)) {
                result = jedis.del(key);
                logger.debug("del {}", key);
            } else {
                logger.debug("del {} not exists", key);
            }
        } catch (Exception e) {
            logger.warn("del {}", key, e);
        } finally {
            returnResource(jedis);
        }
        return result;
    }

    /**
     * 删除 hash 字段
     *
     * @param key   键
     * @param field 字段
     * @return 结果
     */
    public static long delMapField(String key, String field) {
        long result = 0;
        Jedis jedis = null;
        try {
            jedis = getResource();
            if (jedis.exists(key)) {
                result = jedis.hdel(key, field);
                logger.debug("delMapField {} {}", key, field);
            } else {
                logger.debug("delMapField {} {} not exists", key, field);
            }
        } catch (Exception e) {
            logger.error("delMapField {} {} failed", key, field);
            logger.error(e.getMessage(), e);
        } finally {
            returnResource(jedis);
        }
        return result;
    }

    /**
     * 删除缓存
     *
     * @param key 键
     * @return
     */
    public static long delObject(String key) {
        long result = 0;
        Jedis jedis = null;
        try {
            jedis = getResource();
            if (jedis.exists(getBytesKey(key))) {
                result = jedis.del(getBytesKey(key));
                logger.debug("delObject {}", key);
            } else {
                logger.debug("delObject {} not exists", key);
            }
        } catch (Exception e) {
            logger.warn("delObject {}", key, e);
        } finally {
            returnResource(jedis);
        }
        return result;
    }

    /**
     * 批量删除缓存（通配符 * ?）
     *
     * @param pattern 键
     * @return
     */
    public static long delLike(String pattern) {
        long result = 0;
        Jedis jedis = null;
        try {
            jedis = getResource();
            Set<String> keys = jedis.keys(pattern);
            for (String key : keys) {
                if (jedis.exists(key)) {
                    result = jedis.del(key);
                    logger.debug("del {}", key);
                } else {
                    logger.debug("del {} not exists", key);
                }
            }
        } catch (Exception e) {
            logger.warn("delLike {}", pattern, e);
        } finally {
            returnResource(jedis);
        }
        return result;
    }

    /**
     * 批量查询Key（通配符 * ?）
     *
     * @param pattern 键通配符
     * @return keys
     */
    public static Set<String> keys(String pattern) {
        Set<String> keys = null;
        Jedis jedis = null;
        try {
            jedis = getResource();
            keys = jedis.keys(pattern);
            return keys;
        } catch (Exception e) {
            logger.warn("keys {}", pattern, e);
        } finally {
            returnResource(jedis);
        }
        return keys;
    }

    /**
     * 缓存是否存在
     *
     * @param key 键
     * @return
     */
    public static boolean exists(String key) {
        boolean result = false;
        Jedis jedis = null;
        try {
            jedis = getResource();
            result = jedis.exists(key);
            logger.debug("exists {}", key);
        } catch (Exception e) {
            logger.warn("exists {}", key, e);
        } finally {
            returnResource(jedis);
        }
        return result;
    }

    /**
     * 缓存是否存在
     *
     * @param key 键
     * @return
     */
    public static boolean existsObject(String key) {
        boolean result = false;
        Jedis jedis = null;
        try {
            jedis = getResource();
            result = jedis.exists(getBytesKey(key));
            logger.debug("existsObject {}", key);
        } catch (Exception e) {
            logger.warn("existsObject {}", key, e);
        } finally {
            returnResource(jedis);
        }
        return result;
    }

    /**
     * 归还资源
     *
     * @param jedis
     */
    public static void returnBrokenResource(Jedis jedis) {
        if (jedis != null) {
            jedis.close();
        }
    }

    /**
     * 释放资源
     *
     * @param jedis
     */
    public static void returnResource(Jedis jedis) {
        if (jedis != null) {
            jedis.close();
        }
    }

    /**
     * 获取byte[]类型Key
     */
    public static byte[] getBytesKey(Object object) {
        if (object instanceof String) {
            return StringUtils.getBytes((String) object);
        } else {
            return ObjectUtils.serialize(object);
        }
    }

    /**
     * Object转换byte[]类型
     */
    public static byte[] toBytes(Object object) {
        return ObjectUtils.serialize(object);
    }

    /**
     * byte[]型转换Object
     *
     * @return
     */
    public static Object toObject(byte[] bytes) {
        return ObjectUtils.unserialize(bytes);
    }

    /**
     * 设置过期剩余时间
     *
     * @param key          键
     * @param cacheSeconds 秒
     * @return 剩余时间
     */
    public static Long expire(String key, int cacheSeconds) {
        Long ttl = null;
        Jedis jedis = null;
        try {
            jedis = getResource();
            ttl = jedis.expire(key, cacheSeconds);
            logger.debug("expire {} = {}", key, cacheSeconds);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        } finally {
            returnResource(jedis);
        }
        return ttl;
    }

    /**
     * 获取剩余时间
     *
     * @param key 键
     * @return TTL
     */
    public static Long getTTL(String key) {
        Long ttl = null;
        Jedis jedis = null;
        try {
            jedis = getResource();
            ttl = jedis.ttl(key);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        } finally {
            returnResource(jedis);
        }
        return ttl;
    }

    /**
     * 一个或多个值 value 插入到列表 key 的表头
     *
     * @param key    键
     * @param values 值
     * @return count
     */
    public static Long lpush(String key, String... values) {
        Long count = null;
        Jedis jedis = null;
        try {
            jedis = getResource();
            count = jedis.lpush(key, values);
            logger.debug("lpush {} = {}", key, values);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        } finally {
            returnResource(jedis);
        }
        return count;
    }

    /**
     * 移除并返回列表 key 的头元素
     *
     * @param key 键
     * @return count
     */
    public static String lpop(String key) {
        String value = null;
        Jedis jedis = null;
        try {
            jedis = getResource();
            value = jedis.lpop(key);
            logger.debug("lpop {} = {}", key, value);
            if (NIL.equals(value)) {
                value = null;
            }
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        } finally {
            returnResource(jedis);
        }
        return value;
    }

    /**
     * 将 key 中储存的数字值增一
     *
     * @param key 键
     * @return 增一后结果
     */
    public static Long incr(String key) {
        Long value = null;
        Jedis jedis = null;
        try {
            jedis = getResource();
            value = jedis.incr(key);
            logger.debug("incr {} = {}", key, value);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        } finally {
            returnResource(jedis);
        }
        return value;
    }

    /**
     * 将 key 中储存的数字值减一
     *
     * @param key 键
     * @return 减一后结果
     */
    public static Long decr(String key) {
        Long value = null;
        Jedis jedis = null;
        try {
            jedis = getResource();
            value = jedis.decr(key);
            logger.debug("decr {} = {}", key, value);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        } finally {
            returnResource(jedis);
        }
        return value;
    }
}