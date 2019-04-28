package com.moda.entity.persistence.entity;

import com.moda.entity.BaseEntity;

/**
 * MyBatis Entity 基类
 *
 * @author lyh
 * @create 2018/8/25 21:54
 **/
public class BaseMyBatisEntity extends BaseEntity {
    /**
     * 主键ID
     */
    private Integer id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 是否是新记录（默认：false），调用setIsNewRecord()设置新记录，使用自定义ID。
     * 设置为true后强制执行插入语句，ID不会自动生成，需从手动传入。
     *
     * @return boolean
     */
    public boolean getIsNewRecord() {
        return getId() == null;
    }
}
