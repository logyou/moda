package com.moda.demo.tst.service;

import com.moda.demo.tst.request.UserGetSimpleRequest;
import com.moda.demo.tst.response.UserGetSimpleResponse;
import com.moda.entity.persistence.service.BaseMyBatisService;

/**
 * @author lyh
 * @date 2019-04-28 18:05
 **/
public interface UserService<T> extends BaseMyBatisService<T> {
    UserGetSimpleResponse getSimple(UserGetSimpleRequest param);
}
