package com.moda.util.alipay;

import com.moda.entity.alipay.entity.ApAccount;
import com.moda.util.cache.JedisUtils;
import com.moda.util.mapper.JsonMapper;

/**
 * 微信配置缓存工具类
 *
 * @author lyh
 * @version 1.1 2016-10-31
 */
public class ApMemoryCacheClient {
    private final static String DEFAULT = "default";
    private final static String REDIS_KEY_PREFIX = "com:moda:cache:alipay";
    private final static String ALIPAY_ACCOUNT = REDIS_KEY_PREFIX + ":account:";
    private final static String ALIPAY_ACCOUNT_DEFAULT = REDIS_KEY_PREFIX + ":account:" + DEFAULT;

    /**
     * 添加一条支付宝信息
     *
     * @param account 支付宝信息
     */
    public static void addApAccount(ApAccount account) {
        if (account != null) {
            String key = ALIPAY_ACCOUNT + account.getPartnerId();
            JedisUtils.set(key, JsonMapper.toJsonString(account), 0);
            JedisUtils.set(ALIPAY_ACCOUNT_DEFAULT, JsonMapper.toJsonString(account), 0);
        }
    }

    /**
     * 根据合作ID获取支付宝信息
     *
     * @param partnerId 合作ID
     * @return 支付宝信息
     */
    public static ApAccount getApAccount(String partnerId) {
        String key = ALIPAY_ACCOUNT + partnerId;
        return JsonMapper.parseObject(JedisUtils.get(key), ApAccount.class);
    }

    /**
     * 获取默认的支付宝
     *
     * @return 支付宝信息
     */
    public static ApAccount getDefaultApAccount() {
        return getApAccount(DEFAULT);
    }

}
