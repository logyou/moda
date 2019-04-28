package com.moda.demo.tst.service.impl;

import com.moda.autoconfigure.sys.SysProperties;
import com.moda.demo.tst.service.DemoService;
import org.apache.dubbo.config.annotation.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

/**
 * 服务接口实现
 *
 * @author lyh
 * @version 2019-04-01 16:37:40
 */
@Service
@Transactional(readOnly = true, rollbackFor = Exception.class)
public class DemoServiceImpl implements DemoService {
    private Logger logger = LoggerFactory.getLogger(getClass());
    @Autowired
    private SysProperties sysProperties;

    @Override
    public String greet(String name) {
        logger.debug("sys.env: {},name: {}", sysProperties.getEnv(), name);
        return String.format("%s,Hello World!(From %s)", name, sysProperties.getEnv());
    }
}