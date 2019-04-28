package com.moda.util.uuid;

import java.util.Date;

import com.moda.util.date.DateUtils;
import com.moda.util.random.RandomUtils;

/**
 * 交易相关处理
 *
 * @author lyh
 * @date 2016-01-27
 */
public class TradeUtils {

    /**
     * 生成一个交易号（20位=yyyyMMddHHmmss+6位随机数）
     *
     * @return
     */
    public static String generateTradeNo() {
        return DateUtils.formatDate(new Date(), "yyyyMMddHHmmss") + RandomUtils.getRandom(6);
    }
}
