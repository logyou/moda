package com.moda.demo;

import com.moda.redis.spring.boot.autoconfigure.RedisClient;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AppTest {
    @Autowired
    private RedisClient redisClient;

    @Test
    public void test() {
        String key = "lyh";
        String field = "a";
        String value = "1";
        redisClient.deleteHashField(key, field);
        Assert.assertFalse(redisClient.hasHashField(key, field));
    }

    @Test
    public void del() {
        String key = "cc";
        String value = "12";
        redisClient.set(key, value);
        Assert.assertEquals(value, redisClient.get(key));
        redisClient.delete(key);
        Assert.assertFalse(redisClient.hasKey(key));
    }
}
