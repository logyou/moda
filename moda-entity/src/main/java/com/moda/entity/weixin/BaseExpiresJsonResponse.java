package com.moda.entity.weixin;

import java.util.Calendar;

/**
 * 有失效期的结果
 *
 * @author lyh
 * @version 1.0 2016-05-17
 */
public class BaseExpiresJsonResponse extends BaseJsonResponse {
    private static final long serialVersionUID = -7225945939169966591L;
    private long createTime;// 创建时间，单位：秒 ，用于判断是否过期
    private int expires_in;// 凭证有效期，单位：秒

    public BaseExpiresJsonResponse() {
        createTime = Calendar.getInstance().getTimeInMillis() / 1000L;//秒
    }

    public long getCreateTime() {
        return createTime;
    }

    public int getExpires_in() {
        return expires_in;
    }

    public void setExpires_in(int expires_in) {
        this.expires_in = expires_in;
    }

    /**
     * 是否超时，微信默认7200s超时
     *
     * @return true-超时；false-没有超时
     */
    public boolean isExpires() {
        long now = Calendar.getInstance().getTimeInMillis() / 1000L;//秒
        return now - this.createTime + 10 >= this.expires_in; // 预留 10s
    }

    /**
     * 是否超时
     *
     * @return true-超时；false-没有超时
     */
    public boolean isExpires(Long expireTime) {
        long now = Calendar.getInstance().getTimeInMillis() / 1000L;//秒
        return now - this.createTime + 10 >= expireTime; // 预留 10s
    }

}
