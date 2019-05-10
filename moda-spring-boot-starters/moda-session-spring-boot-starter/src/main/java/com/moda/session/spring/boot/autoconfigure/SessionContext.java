package com.moda.session.spring.boot.autoconfigure;

import com.moda.autoconfigure.sys.SysProperties;
import com.moda.entity.rest.BaseRequest;
import com.moda.entity.session.CurrentUser;
import com.moda.redis.spring.boot.autoconfigure.RedisClient;
import com.moda.util.exception.ExceptionUtils;
import com.moda.util.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.Map;

/**
 * 用于维护 Session 上下文信息
 *
 * @author lyh
 * @date 2019-5-8
 **/
public class SessionContext {
    @Autowired
    private SessionContextProperties sessionContextProperties;
    @Autowired
    private SysProperties sysProperties;
    @Autowired
    private RedisClient redisClient;
    /**
     * Session 前缀
     */
    private static final String USER_SESSION_PREFIX = "user:session:";
    /**
     * 当前登录信息的键
     */
    private static final String CURRENT_USER = "currentUser";

    /**
     * 获取用户 Session 键名前缀
     *
     * @return 键名前缀
     */
    private String getUserSessionPrefix() {
        if (StringUtils.isEmpty(sysProperties.getRedisPrefix())) {
            return USER_SESSION_PREFIX;
        } else {
            return sysProperties.getRedisPrefix() + ":" + USER_SESSION_PREFIX;
        }
    }

    /**
     * 获取用户 Session 键名
     *
     * @param accessToken 用户凭证
     * @return 键名
     */
    private String getUserSessionKey(String accessToken) {
        return getUserSessionPrefix() + accessToken;
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
        return redisClient.getHashObjectField(getUserSessionKey(accessToken), CURRENT_USER, CurrentUser.class);
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
        if (StringUtils.isEmpty(user.getAccessToken())) {
            ExceptionUtils.throwServiceException("accessToken 不能为空");
        }
        Map<String, Object> map = new HashMap<>(1);
        map.put(CURRENT_USER, user);
        redisClient.setHashObject(getUserSessionKey(user.getAccessToken()), map, sessionContextProperties.getTimeout());
    }

    /**
     * 清除登录信息
     *
     * @param accessToken 访问凭证
     */
    public void clearCurrentUser(String accessToken) {
        if (StringUtils.isNotEmpty(accessToken)) {
            redisClient.delete(getUserSessionKey(accessToken));
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
        if (StringUtils.isBlank(accessToken)) {
            ExceptionUtils.throwServiceException("accessToken 不能为空");
        }
        if (StringUtils.isNotEmpty(accessToken)) {
            redisClient.expire(getUserSessionKey(accessToken), sessionContextProperties.getTimeout());
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
            ExceptionUtils.throwServiceException("accessToken 不能为空");
        }
        if (StringUtils.isBlank(field)) {
            ExceptionUtils.throwServiceException("field 不能为空");
        }
        if (CURRENT_USER.equalsIgnoreCase(field)) {
            ExceptionUtils.throwServiceException("字段名[" + field + "]为保留字段，不能使用");
        }
        redisClient.setHashObjectField(getUserSessionKey(accessToken), field, value);
    }

    /**
     * 设置属性
     *
     * @param param 参数
     * @param field 字段
     * @param value 值
     */
    public void setAttribute(BaseRequest param, String field, Object value) {
        if (param == null) {
            ExceptionUtils.throwServiceException("param 不能为空");
        }
        setAttribute(param.getAccessToken(), field, value);
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
            ExceptionUtils.throwServiceException("accessToken 不能为空");
        }
        if (StringUtils.isBlank(field)) {
            ExceptionUtils.throwServiceException("field 不能为空");
        }
        return redisClient.getHashObjectField(getUserSessionKey(accessToken), field, t);
    }

    /**
     * 获取属性
     *
     * @param param 参数
     * @param field 字段
     * @param t     类
     * @param <T>   值类型
     * @return T
     */
    public <T> T getAttribute(BaseRequest param, String field, Class<T> t) {
        if (param == null) {
            ExceptionUtils.throwServiceException("param 不能为空");
        }
        return getAttribute(param.getAccessToken(), field, t);
    }

    /**
     * 删除指定字段值
     *
     * @param accessToken 访问凭证
     * @param field       字段
     */
    public void removeAttribute(String accessToken, String field) {
        if (StringUtils.isBlank(accessToken)) {
            ExceptionUtils.throwServiceException("accessToken 不能为空");
        }
        if (StringUtils.isBlank(field)) {
            ExceptionUtils.throwServiceException("field 不能为空");
        }
        redisClient.deleteHashField(getUserSessionKey(accessToken), field);
    }

    /**
     * 删除指定字段值
     *
     * @param param 参数
     * @param field 字段
     */
    public void removeAttribute(BaseRequest param, String field) {
        if (param == null) {
            ExceptionUtils.throwServiceException("param 不能为空");
        }
        removeAttribute(param.getAccessToken(), field);
    }
}
