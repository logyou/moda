package com.moda.demo.tst.service.impl;

import com.moda.demo.tst.dao.UserDao;
import com.moda.demo.tst.entity.User;
import com.moda.demo.tst.request.UserGetSimpleRequest;
import com.moda.demo.tst.response.UserGetSimpleResponse;
import com.moda.demo.tst.service.UserService;
import com.moda.entity.persistence.service.impl.BaseMyBatisServiceImpl;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author lyh
 * @date 2019-04-28 18:18
 **/
@Service
@Transactional(readOnly = true, rollbackFor = Exception.class)
public class UserServiceImpl extends BaseMyBatisServiceImpl<UserDao, User> implements UserService<User> {
    public UserServiceImpl(UserDao dao) {
        super(dao);
    }

    @Override
    public UserGetSimpleResponse getSimple(UserGetSimpleRequest param) {
        return dao.getSimple(param.getId());
    }
}
