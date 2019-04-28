package com.moda.util.weixin;

import com.moda.entity.weixin.AccessToken;
import com.moda.entity.weixin.JsApiTicket;
import com.moda.entity.weixin.OAuthAccessToken;
import com.moda.entity.weixin.WxAccount;
import com.moda.util.cache.JedisUtils;
import com.moda.util.mapper.JsonMapper;

/**
 * 微信配置缓存工具类
 *
 * @author lyh
 * @version 1.1 2016-10-31
 */
public class WxMemoryCacheClient {
    private final static String DEFAULT = "default";
    private final static String REDIS_KEY_PREFIX = "com:moda:cache:weixin";
    private final static String WEIXIN_ACCOUNT = REDIS_KEY_PREFIX + ":account:";
    private final static String WEIXIN_ACCOUNT_DEFAULT = REDIS_KEY_PREFIX + ":account:" + DEFAULT;
    private final static String WEIXIN_ACCESS_TOKEN = REDIS_KEY_PREFIX + ":accessToken:";
    private final static String WEIXIN_ACCESS_TOKEN_DEFAULT = REDIS_KEY_PREFIX + ":accessToken:" + DEFAULT;
    private final static String WEIXIN_JSAPITICKET = REDIS_KEY_PREFIX + ":jsApiTicket:";
    private final static String WEIXIN_JSAPITICKET_DEFAULT = REDIS_KEY_PREFIX + ":jsApiTicket:" + DEFAULT;
    private final static String WEIXIN_OPENID = REDIS_KEY_PREFIX + ":openId:";
    private final static String WEIXIN_OAUTH_ACCESS_TOKEN = REDIS_KEY_PREFIX + ":oAuthAccessToken:";
    private final static String WEIXIN_OAUTH_ACCESS_TOKEN_DEFAULT = REDIS_KEY_PREFIX + ":oAuthAccessToken:" + DEFAULT;

    /**
     * 添加一条公众号信息
     *
     * @param account 公众号信息
     */
    public static void addWxAccount(WxAccount account) {
        if (account != null) {
            String key = WEIXIN_ACCOUNT + account.getAccount();
            JedisUtils.set(key, JsonMapper.toJsonString(account), 0);
            JedisUtils.set(WEIXIN_ACCOUNT_DEFAULT, JsonMapper.toJsonString(account), 0);
        }
    }

    /**
     * 根据微信号获取公众号信息
     *
     * @param weixinId 微信号
     * @return
     */
    public static WxAccount getWxAccount(String weixinId) {
        String key = WEIXIN_ACCOUNT + weixinId;
        return JsonMapper.parseObject(JedisUtils.get(key), WxAccount.class);
    }

    /**
     * 获取默认的公众号
     *
     * @return
     */
    public static WxAccount getDefaultWxAccount() {
        return getWxAccount(DEFAULT);
    }

    /**
     * 添加一条AccessToken到缓存
     *
     * @param weixinId    微信号
     * @param accessToken
     */
    public static void addAccessToken(String weixinId, AccessToken accessToken) {
        if (accessToken != null) {
            String key = WEIXIN_ACCESS_TOKEN + weixinId;
            JedisUtils.set(key, JsonMapper.toJsonString(accessToken), accessToken.getExpires_in());
            JedisUtils.set(WEIXIN_ACCESS_TOKEN_DEFAULT, JsonMapper.toJsonString(accessToken), accessToken.getExpires_in());
        }
    }

    /**
     * 根据微信号从缓存中获取AccessToken
     *
     * @param weixinId 微信号
     * @return AccessToken
     */
    public static AccessToken getAccessToken(String weixinId) {
        String key = WEIXIN_ACCESS_TOKEN + weixinId;
        return JsonMapper.parseObject(JedisUtils.get(key), AccessToken.class);
    }

    /**
     * 获取默认的AccessToken
     *
     * @return AccessToken
     */
    public static AccessToken getDefaultAccessToken() {
        return getAccessToken(DEFAULT);
    }

    /**
     * 添加一条JsApiTicket到缓存
     *
     * @param weixinId 微信号
     * @param jsTicket JsApiTicket
     */
    public static void addJsApiTicket(String weixinId, JsApiTicket jsTicket) {
        if (jsTicket != null) {
            String key = WEIXIN_JSAPITICKET + weixinId;
            JedisUtils.set(key, JsonMapper.toJsonString(jsTicket), jsTicket.getExpires_in());
            JedisUtils.set(WEIXIN_JSAPITICKET_DEFAULT, JsonMapper.toJsonString(jsTicket), jsTicket.getExpires_in());
        }
    }

    /**
     * 根据微信号获取JsApiTicket
     *
     * @param weixinId
     * @return JsApiTicket
     */
    public static JsApiTicket getJsApiTicket(String weixinId) {
        String key = WEIXIN_JSAPITICKET + weixinId;
        return JsonMapper.parseObject(JedisUtils.get(key), JsApiTicket.class);
    }

    /**
     * 获取默认的JsApiTicket
     *
     * @return JsApiTicket
     */
    public static JsApiTicket getDefaultJsApiTicket() {
        return getJsApiTicket(DEFAULT);
    }

    public static String getOpenId(String sessionId) {
        String key = WEIXIN_OPENID + sessionId;
        return JedisUtils.get(key);
    }

    public static void setOpenId(String sessionId, String openId) {
        String key = WEIXIN_OPENID + sessionId;
        JedisUtils.set(key, openId, 0);
    }

    public static void addOAuthAccessToken(String weixinId, OAuthAccessToken token) {
        if (token != null) {
            String key = WEIXIN_OAUTH_ACCESS_TOKEN + weixinId;
            JedisUtils.set(key, JsonMapper.toJsonString(token), token.getExpires_in());
            JedisUtils.set(WEIXIN_OAUTH_ACCESS_TOKEN_DEFAULT, JsonMapper.toJsonString(token), token.getExpires_in());
        }
    }

    public static OAuthAccessToken getOAuthAccessToken(String openId) {
        String key = WEIXIN_OAUTH_ACCESS_TOKEN + openId;
        return JsonMapper.parseObject(JedisUtils.get(key), OAuthAccessToken.class);
    }

    public static OAuthAccessToken getDefaultOAuthAccessToken() {
        return getOAuthAccessToken(DEFAULT);
    }

}
