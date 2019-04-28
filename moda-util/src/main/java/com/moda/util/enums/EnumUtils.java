package com.moda.util.enums;

import com.moda.entity.enums.BaseEnum;
import com.moda.entity.enums.EnumItem;

import java.util.ArrayList;
import java.util.List;

/**
 * 枚举工具
 *
 * @author lyh
 * @create 2018-08-29 10:54
 **/
public class EnumUtils {
    /**
     * 根据值获取枚举对象
     *
     * @param clazz 枚举类
     * @param value 值
     * @param <T>   枚举
     * @return T
     */
    public static <T extends BaseEnum> T getByValue(Class<T> clazz, Integer value) {
        for (T t : clazz.getEnumConstants()) {
            if (t.value().equals(value)) {
                return t;
            }
        }
        return null;
    }

    /**
     * 根据名称获取枚举对象
     *
     * @param clazz 枚举类
     * @param name  名称
     * @param <T>   枚举
     * @return T
     */
    public static <T extends BaseEnum> T getByName(Class<T> clazz, String name) {
        for (T t : clazz.getEnumConstants()) {
            if (t.name().equals(name)) {
                return t;
            }
        }
        return null;
    }

    /**
     * 根据描述获取枚举对象
     *
     * @param clazz 枚举类
     * @param text  描述
     * @param <T>   枚举
     * @return T
     */
    public static <T extends BaseEnum> T getByText(Class<T> clazz, String text) {
        for (T t : clazz.getEnumConstants()) {
            if (t.text().equals(text)) {
                return t;
            }
        }
        return null;
    }

    /**
     * 获取枚举所有项
     *
     * @param clazz 枚举类
     * @param <T>   枚举
     * @return List<EnumItem>
     */
    public static <T extends BaseEnum> List<EnumItem> getAll(Class<T> clazz) {
        List<EnumItem> items = new ArrayList<>();
        for (T item : clazz.getEnumConstants()) {
            EnumItem ei = new EnumItem();
            ei.setName(item.name());
            ei.setText(item.text());
            ei.setValue(item.value());
            items.add(ei);
        }
        return items;
    }
}
