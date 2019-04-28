package com.moda.entity.persistence.dao;

import com.moda.entity.persistence.entity.BaseMyBatisEntity;

import java.util.List;

/**
 * MyBatis DAO 接口
 *
 * @author lyh
 * @create 2018-9-11
 **/
public interface BaseMyBatisDao<T extends BaseMyBatisEntity> extends BaseDao {
    /**
     * 根据主键ID查找一条记录
     *
     * @param id 主键ID
     * @return 一条记录或空
     */
    T get(Integer id);

    /**
     * 获取所有记录
     *
     * @return 多条记录或空
     */
    List<T> listAll();

    /**
     * 插入一条记录
     *
     * @param t 记录
     * @return 影响行数
     */
    int insert(T t);

    /**
     * 批量插入多条记录
     *
     * @param list 记录列表
     * @return 影响行数
     */
    int insertBatch(List<T> list);

    /**
     * 更新一条记录
     *
     * @param t 记录
     * @return 匹配行数
     */
    int update(T t);

    /**
     * 根据主键ID删除一条记录
     *
     * @param id 主键ID
     * @return 匹配行数
     */
    int delete(Integer id);

    /**
     * 根据条件查找一条记录
     *
     * @param t 条件
     * @return 一条记录或空
     */
    T getByCondition(T t);

    /**
     * 根据条件查找多条记录
     *
     * @param t 条件
     * @return 多条记录或空
     */
    List<T> listByCondition(T t);

    /**
     * 保存数据（插入或更新）
     * 如果主键ID不为空，则执行更新操作
     * 否则执行插入操作
     *
     * @param entity 实体类
     * @return 受影响的条数
     */
    default int save(T entity) {
        if (entity.getIsNewRecord()) {
            return insert(entity);
        } else {
            return update(entity);
        }
    }
}
