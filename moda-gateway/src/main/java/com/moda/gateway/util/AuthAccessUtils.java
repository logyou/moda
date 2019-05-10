package com.moda.gateway.util;

import com.moda.autoconfigure.sys.SysProperties;
import com.moda.entity.app.ApplicationAccount;
import com.moda.entity.enums.sys.YesOrNo;
import com.moda.entity.rest.BaseRequest;
import com.moda.entity.rest.Result;
import com.moda.entity.rest.Status;
import com.moda.redis.spring.boot.autoconfigure.RedisClient;
import com.moda.util.cache.JedisUtils;
import com.moda.util.date.DateUtils;
import com.moda.util.lang.StringUtils;
import com.moda.util.mapper.JsonMapper;
import com.moda.util.security.Md5Utils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @author lyh
 * @date 2019-04-22 19:06
 **/
@Component
@EnableConfigurationProperties(SysProperties.class)
public class AuthAccessUtils {
    private static Logger logger = LoggerFactory.getLogger(AuthAccessUtils.class);
    /**
     * 时间戳有效期为5分钟
     */
    private final static Long TIMEOUT = 5L * 60 * 1000;
    private final static String APPLICATION_ACCOUNT = ":application:account:";
    private static ApplicationAccount account;
    @Autowired
    private SysProperties sysProperties;
    @Autowired
    private RedisClient redisClient;

    static {
        account = new ApplicationAccount();
        account.setAppId("test");
        account.setAppKey("123456");
        account.setStartTime(new Date());
        account.setEndTime(DateUtils.addYears(new Date(), 1));
        account.setStatus(1);
    }

    /**
     * 校验签名信息
     *
     * @param body 参数
     */
    public Result checkAccess(String uri, String body) {
        if (StringUtils.isBlank(body)) {
            return new Result(Status.FAIL, "缺少参数！");
        }
        logger.info(uri + System.lineSeparator() + body);
        BaseRequest entity = JsonMapper.parseObject(body, BaseRequest.class);
        if (entity == null) {
            return new Result(Status.FAIL, "参数格式错误！");
        }
        if (StringUtils.isEmpty(entity.getAppId())) {
            return new Result(Status.FAIL, "缺少应用ID！");
        }
        if (entity.getTimestamp() == null) {
            return new Result(Status.FAIL, "缺少时间戳！");
        }
        if (StringUtils.isEmpty(entity.getSign())) {
            return new Result(Status.FAIL, "缺少签名！");
        }
        if (entity.getTimestamp() > (System.currentTimeMillis() + TIMEOUT) ||
                entity.getTimestamp() < (System.currentTimeMillis() - TIMEOUT)) {
            return new Result(Status.FAIL, "时间戳已过期！");
        }

        //TODO 没有值时从Redis获取
        if (account == null) {
            //获取缓存中的应用账号
            String json = redisClient.get(sysProperties.getRedisPrefix() + APPLICATION_ACCOUNT + entity.getAppId());
            account = JsonMapper.parseObject(json, ApplicationAccount.class);
        }

        if (account == null) {
            return new Result(Status.FAIL, "无效的应用ID！");
        }
        Date now = new Date();
        if (now.before(account.getStartTime()) || now.after(account.getEndTime())) {
            return new Result(Status.FAIL, "应用账号已过期！");
        }
        if (!account.getStatus().equals(YesOrNo.YES.value())) {
            return new Result(Status.FAIL, "应用账号已被禁用！");
        }

        String raw = account.getAppId() + account.getAppKey() + entity.getTimestamp();
        String md5 = Md5Utils.md5(raw);
        if (StringUtils.isEmpty(md5)) {
            return new Result(Status.FAIL, "生成MD5签名失败！");
        }
        md5 = md5.toUpperCase();
        if (!md5.equals(entity.getSign())) {
            return new Result(Status.FAIL, "签名无效！");
        }

        return new Result(Status.SUCCESS);
    }
}
