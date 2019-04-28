package com.moda.entity.enums;

/**
 * 枚举接口
 *
 * @author lyh
 * @create 2018-08-29 10:11
 **/
public interface BaseEnum {
    /**
     * 获取枚举名称
     *
     * @return 名称
     */
    String name();

    /**
     * 获取枚举值
     *
     * @return 值
     */
    Integer value();

    /**
     * 获取枚举描述
     *
     * @return 描述
     */
    String text();
}
