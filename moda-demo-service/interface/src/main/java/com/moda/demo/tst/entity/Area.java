package com.moda.demo.tst.entity;

import com.moda.entity.persistence.entity.BaseMyBatisEntity;

/**
 * @author lyh
 * @date 2019-04-28 18:05
 **/
public class Area extends BaseMyBatisEntity {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
