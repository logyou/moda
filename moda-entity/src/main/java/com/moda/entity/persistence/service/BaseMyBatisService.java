package com.moda.entity.persistence.service;

import java.util.List;

/**
 * Base MyBatis Service 接口
 *
 * @author lyh
 * @version 2018-10-3 18:54:43
 **/
public interface BaseMyBatisService<T> extends BaseService {
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
     * 插入一条记录，同时返回新纪录，返回对象包含了主键ID
     *
     * @param t 记录
     * @return 新纪录
     */
    T insertWithReturn(T t);

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
     * 保存记录（插入或更新）
     * 如果主键ID不为空，则执行更新操作
     * 否则执行插入操作
     *
     * @param t 实体类
     * @return 受影响的条数
     */
    int save(T t);

    /**
     * 保存记录（插入或更新）
     * 如果主键ID不为空，则执行更新操作
     * 否则执行插入操作
     * 如果是新增的记录，则包含了主键ID
     *
     * @param t 实体类
     * @return 保存后的记录
     */
    T saveWithReturn(T t);
}
