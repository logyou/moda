package com.moda.entity.annotation;

import java.lang.annotation.*;

/**
 * 登录验证注解
 *
 * @author lyh
 * @version 2018-8-30 10:16:25
 */
@Documented
@Inherited
@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface AuthLogin {
}
