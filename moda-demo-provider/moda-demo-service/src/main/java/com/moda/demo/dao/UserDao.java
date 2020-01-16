package com.moda.demo.dao;

import com.moda.demo.dao.generated.UserMapper;
import com.moda.demo.entity.User;
import com.moda.demo.response.UserGetSimpleResponse;

import java.util.List;

/**
 * @author lyh
 * @date 2019-04-28 18:19
 **/
public interface UserDao extends UserMapper {
    UserGetSimpleResponse getSimple(Integer id);

    List<User> listByStatus(Integer status);
}
