package com.moda.demo.service.impl;

import com.github.pagehelper.PageHelper;
import com.moda.demo.dao.UserDao;
import com.moda.demo.entity.User;
import com.moda.demo.entity.UserExample;
import com.moda.demo.request.UserGetSimpleRequest;
import com.moda.demo.request.UserListByStatusRequest;
import com.moda.demo.request.UserSearchRequest;
import com.moda.demo.response.UserGetSimpleResponse;
import com.moda.demo.service.UserService;
import com.moda.entity.persistence.page.Page;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author lyh
 * @date 2019-04-28 18:18
 **/
@Service
@Transactional(readOnly = true, rollbackFor = Exception.class)
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Override
    public UserGetSimpleResponse getSimple(UserGetSimpleRequest request) {
        User user = userDao.selectByPrimaryKey(request.getId());
        return userDao.getSimple(request.getId());
    }

    @Override
    public Page<User> search(UserSearchRequest request) {
        UserExample example = new UserExample();
        example.createCriteria().andMobileLike("%" + request.getMobile() + "%");
        PageHelper.startPage(request.getPageNo(), request.getPageSize(), request.isFirstPage());
        List<User> list = userDao.selectByExample(example);
        return Page.of(list);
    }

    @Override
    public Page<User> listByStatus(UserListByStatusRequest request) {
        PageHelper.startPage(request.getPageNo(), request.getPageSize(), request.isFirstPage());
        List<User> list = userDao.listByStatus(request.getStatus());
        return Page.of(list);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public User saveUser(User user) {
        userDao.insertSelective(user);
        return user;
    }
}
