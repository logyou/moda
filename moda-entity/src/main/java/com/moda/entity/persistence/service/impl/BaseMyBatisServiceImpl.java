package com.moda.entity.persistence.service.impl;

import com.moda.entity.persistence.dao.BaseMyBatisDao;
import com.moda.entity.persistence.entity.BaseMyBatisEntity;
import com.moda.entity.persistence.service.BaseMyBatisService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Base MyBatis Service 实现抽象类
 *
 * @author lyh
 * @create 2018-9-26
 **/
@Transactional(readOnly = true, rollbackFor = Exception.class)
public abstract class BaseMyBatisServiceImpl<D extends BaseMyBatisDao<T>, T extends BaseMyBatisEntity> implements BaseMyBatisService<T> {
    public final Logger logger = LoggerFactory.getLogger(getClass());

    protected D dao;

    public BaseMyBatisServiceImpl(D dao) {
        this.dao = dao;
    }

    @Override
    public T get(Integer id) {
        return dao.get(id);
    }

    @Override
    public List<T> listAll() {
        return dao.listAll();
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public int insert(T t) {
        return dao.insert(t);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public int insertBatch(List<T> list) {
        return dao.insertBatch(list);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public int update(T t) {
        return dao.update(t);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public int delete(Integer id) {
        return dao.delete(id);
    }

    @Override
    public T getByCondition(T t) {
        return dao.getByCondition(t);
    }

    @Override
    public List<T> listByCondition(T t) {
        return dao.listByCondition(t);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public int save(T t) {
        if (t.getIsNewRecord()) {
            return insert(t);
        } else {
            return update(t);
        }
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public T insertWithReturn(T t) {
        insert(t);
        return t;
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public T saveWithReturn(T t) {
        save(t);
        return t;
    }
}
