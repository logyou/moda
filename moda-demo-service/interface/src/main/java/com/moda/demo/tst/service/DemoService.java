package com.moda.demo.tst.service;


import com.moda.entity.persistence.service.BaseService;

/**
 * 服务接口
 *
 * @author lyh
 * @version 2019-04-01 16:37:40
 */
public interface DemoService extends BaseService {
    String greet(String name);
}