package com.moda.entity.enums;

import com.moda.entity.BaseEntity;

/**
 * 枚举项实体类
 *
 * @author lyh
 * @create 2018-08-29 10:18
 **/
public class EnumItem extends BaseEntity {
    /**
     * 值
     */
    private Integer value;
    /**
     * 名称
     */
    private String name;
    /**
     * 描述
     */
    private String text;

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
