package com.moda.demo;

import com.moda.demo.entity.User;
import com.moda.demo.service.UserService;
import com.moda.util.mapper.JsonMapper;
import org.apache.dubbo.config.annotation.Reference;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AppTest {
    private Logger logger = LoggerFactory.getLogger(getClass());
    @Reference
    private UserService userService;

    @Test
    public void test() {
        User user = new User();
        user.setName("周星星");
        User result = userService.saveUser(user);
        logger.info(JsonMapper.toJsonStringIndent(result));
    }
}
