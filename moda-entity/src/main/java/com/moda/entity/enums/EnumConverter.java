package com.moda.entity.enums;

/**
 * 枚举转换器
 *
 * @author lyh
 * @create 2018/08/29 23:39
 **/
public class EnumConverter {
    /**
     * 根据枚举值获取枚举对象
     *
     * @param clazz 枚举类
     * @param value 枚举值
     * @param <T>   枚举
     * @return T
     */
    public static <T extends BaseEnum> T valueOf(Class<T> clazz, Integer value) {
        for (T t : clazz.getEnumConstants()) {
            if (t.value().equals(value)) {
                return t;
            }
        }
        return null;
    }
}
