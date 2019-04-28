package com.moda.entity.annotation;

import java.lang.annotation.*;

/**
 * 权限验证注解
 *
 * @author lyh
 * @version 2018-8-30 10:17:01
 */
@Documented
@Inherited
@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface AuthPermission {
    /**
     * 权限标识
     */
    String[] value();
}
