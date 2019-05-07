package com.moda.session.spring.boot.autoconfigure;

import com.moda.entity.exception.ServiceException;
import com.moda.entity.rest.BaseRequest;
import com.moda.entity.session.CurrentUser;
import com.moda.util.cache.JedisUtils;
import com.moda.util.lang.StringUtils;
import com.moda.util.mapper.JsonMapper;

import java.util.HashMap;
import java.util.Map;

/**
 * 用于维护 Session 上下文信息
 *
 * @author lyh
 * @create 2018-9-3
 **/
public class SessionContext {
    /**
     * Session 有效期（秒）
     */
    private Integer sessionTimeout = 72000;
    /**
     * Redis 前缀
     */
    private String redisKeyPrefix = "redisKeyPrefix";
    /**
     * Session 前缀
     */
    private static final String USER_SESSION_PREFIX = ":user:session:";
    /**
     * 当前登录信息的键
     */
    private static final String CURRENT_USER = "currentUser";

    public Integer getSessionTimeout() {
        return sessionTimeout;
    }

    public void setSessionTimeout(Integer sessionTimeout) {
        this.sessionTimeout = sessionTimeout;
    }

    public String getRedisKeyPrefix() {
        return redisKeyPrefix;
    }

    public void setRedisKeyPrefix(String redisKeyPrefix) {
        this.redisKeyPrefix = redisKeyPrefix;
    }

    public String getUserSessionPrefix() {
        return getRedisKeyPrefix() + USER_SESSION_PREFIX;
    }

    /**
     * 根据 access token 获取用户信息
     *
     * @param accessToken 访问凭证
     * @return 登录信息
     */
    private CurrentUser getUserByAccessToken(String accessToken) {
        if (StringUtils.isEmpty(accessToken)) {
            return null;
        }
        String key = getUserSessionPrefix() + accessToken;
        String json = JedisUtils.getMapField(key, CURRENT_USER);
        if (StringUtils.isEmpty(json)) {
            return null;
        }
        return JsonMapper.parseObject(json, CurrentUser.class);
    }

    /**
     * 根据 access token 获取用户信息
     *
     * @param param 参数
     * @return 登录信息
     */
    private CurrentUser getUserByAccessToken(BaseRequest param) {
        if (param == null) {
            return null;
        }
        return getUserByAccessToken(param.getAccessToken());
    }

    /**
     * 获取当前登录的用户信息
     *
     * @param accessToken 访问凭证
     * @return 登录信息
     */
    public CurrentUser getCurrentUser(String accessToken) {
        return getUserByAccessToken(accessToken);
    }

    /**
     * 获取当前登录的用户信息
     *
     * @param param 参数
     * @return 登录信息
     */
    public CurrentUser getCurrentUser(BaseRequest param) {
        return getUserByAccessToken(param);
    }

    /**
     * 获取当前登录用户的ID
     *
     * @param accessToken 访问凭证
     * @return 用户ID
     */
    public Integer getCurrentUserId(String accessToken) {
        CurrentUser user = getCurrentUser(accessToken);
        return user == null ? null : user.getId();
    }

    /**
     * 获取当前登录用户的ID
     *
     * @param param 参数
     * @return 用户ID
     */
    public Integer getCurrentUserId(BaseRequest param) {
        CurrentUser user = getCurrentUser(param);
        return user == null ? null : user.getId();
    }

    /**
     * 获取当前登录用户的用户名
     *
     * @param param 参数
     * @return 用户名
     */
    public String getCurrentUserName(BaseRequest param) {
        CurrentUser user = getCurrentUser(param);
        return user == null ? null : user.getUsername();
    }

    /**
     * 获取当前登录用户的用户名
     *
     * @param accessToken 访问凭证
     * @return 用户名
     */
    public String getCurrentUserName(String accessToken) {
        CurrentUser user = getCurrentUser(accessToken);
        return user == null ? null : user.getUsername();
    }

    /**
     * 设置当前登录的用户信息
     *
     * @param user 用户信息
     */
    public void setCurrentUser(CurrentUser user) {
        if (StringUtils.isNotEmpty(user.getAccessToken())) {
            String key = getUserSessionPrefix() + user.getAccessToken();
            Map<String, String> map = new HashMap<>(1);
            map.put(CURRENT_USER, JsonMapper.toJsonString(user));
            JedisUtils.setMap(key, map, getSessionTimeout());
        }
    }

    /**
     * 清除登录信息
     *
     * @param accessToken 访问凭证
     */
    public void clearCurrentUser(String accessToken) {
        if (StringUtils.isNotEmpty(accessToken)) {
            JedisUtils.del(getUserSessionPrefix() + accessToken);
        }
    }

    /**
     * 清除登录信息
     *
     * @param param 参数
     */
    public void clearCurrentUser(BaseRequest param) {
        if (param != null) {
            clearCurrentUser(param.getAccessToken());
        }
    }

    /**
     * 刷新当前登录的用户的失效时间
     *
     * @param accessToken 访问凭证
     */
    public void refreshCurrentUser(String accessToken) {
        if (StringUtils.isNotEmpty(accessToken)) {
            JedisUtils.expire(getUserSessionPrefix() + accessToken, getSessionTimeout());
        }
    }

    /**
     * 刷新当前登录的用户的失效时间
     *
     * @param param 参数
     */
    public void refreshCurrentUser(BaseRequest param) {
        if (param != null) {
            refreshCurrentUser(param.getAccessToken());
        }
    }

    /**
     * 设置属性
     *
     * @param accessToken 访问凭证
     * @param field       字段
     * @param value       值
     */
    public void setAttribute(String accessToken, String field, Object value) {
        if (StringUtils.isBlank(accessToken)) {
            throw new ServiceException("accessToken 不能为空");
        }
        if (StringUtils.isBlank(field)) {
            throw new ServiceException("field 不能为空");
        }
        if (CURRENT_USER.equalsIgnoreCase(field)) {
            throw new ServiceException("字段名[" + field + "]为保留字段，不能使用");
        }
        String key = getUserSessionPrefix() + accessToken;
        JedisUtils.setMapObjectField(key, field, JsonMapper.toJsonString(value));
    }

    /**
     * 获取属性
     *
     * @param accessToken 访问凭证
     * @param field       字段
     * @param t           类
     * @param <T>         值类型
     * @return T
     */
    public <T> T getAttribute(String accessToken, String field, Class<T> t) {
        if (StringUtils.isBlank(accessToken)) {
            throw new ServiceException("accessToken 不能为空");
        }
        if (StringUtils.isBlank(field)) {
            throw new ServiceException("field 不能为空");
        }
        String key = getUserSessionPrefix() + accessToken;
        String value = JedisUtils.getMapField(key, field);
        return JsonMapper.parseObject(value, t);
    }

    /**
     * 删除指定字段值
     *
     * @param accessToken 访问凭证
     * @param field       字段
     */
    public void removeAttribute(String accessToken, String field) {
        String key = getUserSessionPrefix() + accessToken;
        JedisUtils.delMapField(key, field);
    }
}
