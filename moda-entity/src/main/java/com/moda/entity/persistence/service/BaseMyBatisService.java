package com.moda.entity.persistence.service;

import java.util.List;

/**
 * Base MyBatis Service 接口
 *
 * @author lyh
 * @version 2018-10-3 18:54:43
 **/
public interface BaseMyBatisService<E> extends BaseService {
    /**
     * 根据主键ID查找一条记录
     *
     * @param id 主键ID
     * @return 一条记录或空
     */
    E get(Integer id);

    /**
     * 获取所有记录
     *
     * @return 多条记录或空
     */
    List<E> listAll();

    /**
     * 插入一条记录
     *
     * @param e 记录
     * @return 影响行数
     */
    int insert(E e);

    /**
     * 插入一条记录，同时返回新纪录，返回对象包含了主键ID
     *
     * @param e 记录
     * @return 新纪录
     */
    E insertWithReturn(E e);

    /**
     * 批量插入多条记录
     *
     * @param list 记录列表
     * @return 影响行数
     */
    int insertBatch(List<E> list);

    /**
     * 更新一条记录
     *
     * @param e 记录
     * @return 匹配行数
     */
    int update(E e);

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
     * @param e 条件
     * @return 一条记录或空
     */
    E getByCondition(E e);

    /**
     * 根据条件查找多条记录
     *
     * @param e 条件
     * @return 多条记录或空
     */
    List<E> listByCondition(E e);

    /**
     * 保存记录（插入或更新）
     * 如果主键ID不为空，则执行更新操作
     * 否则执行插入操作
     *
     * @param e 实体类
     * @return 受影响的条数
     */
    int save(E e);

    /**
     * 保存记录（插入或更新）
     * 如果主键ID不为空，则执行更新操作
     * 否则执行插入操作
     * 如果是新增的记录，则包含了主键ID
     *
     * @param e 实体类
     * @return 保存后的记录
     */
    E saveWithReturn(E e);
}
