package com.moda.entity.persistence.service.impl;

import com.moda.entity.persistence.dao.BaseMyBatisDao;
import com.moda.entity.persistence.entity.BaseMyBatisEntity;
import com.moda.entity.persistence.service.BaseMyBatisService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Base MyBatis Service 实现抽象类
 *
 * @author lyh
 * @date 2019-04-29 00:17:23
 **/
@Transactional(readOnly = true, rollbackFor = Exception.class)
public abstract class BaseMyBatisServiceImpl<D extends BaseMyBatisDao<E>, E extends BaseMyBatisEntity> implements BaseMyBatisService<E> {
    public final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    protected D dao;

    @Override
    public E get(Integer id) {
        return dao.get(id);
    }

    @Override
    public List<E> listAll() {
        return dao.listAll();
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public int insert(E e) {
        return dao.insert(e);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public int insertBatch(List<E> list) {
        return dao.insertBatch(list);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public int update(E e) {
        return dao.update(e);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public int delete(Integer id) {
        return dao.delete(id);
    }

    @Override
    public E getByCondition(E e) {
        return dao.getByCondition(e);
    }

    @Override
    public List<E> listByCondition(E e) {
        return dao.listByCondition(e);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public int save(E e) {
        if (e.getIsNewRecord()) {
            return insert(e);
        } else {
            return update(e);
        }
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public E insertWithReturn(E e) {
        insert(e);
        return e;
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public E saveWithReturn(E e) {
        save(e);
        return e;
    }
}
