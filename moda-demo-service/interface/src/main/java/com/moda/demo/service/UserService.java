package com.moda.demo.service;

import com.moda.demo.entity.User;
import com.moda.demo.request.UserGetSimpleRequest;
import com.moda.demo.request.UserListByStatusRequest;
import com.moda.demo.request.UserSearchRequest;
import com.moda.demo.response.UserGetSimpleResponse;
import com.moda.entity.persistence.page.Page;
import com.moda.entity.persistence.service.BaseService;

/**
 * @author lyh
 * @date 2019-04-28 18:05
 **/
public interface UserService extends BaseService {
    UserGetSimpleResponse getSimple(UserGetSimpleRequest param);

    Page<User> search(UserSearchRequest request);

    Page<User> listByStatus(UserListByStatusRequest request);

    User saveUser(User user);
}
