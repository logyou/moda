package com.moda;

import com.moda.entity.rest.Result;
import com.moda.entity.rest.Status;
import com.moda.session.spring.boot.autoconfigure.SessionContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Controller 基类，所有 Controller 应继承该基类
 *
 * @author lyh
 * @date 2019-4-23 12:29:28
 **/
public abstract class BaseController {
    protected final Logger logger = LoggerFactory.getLogger(getClass());
    @Autowired(required = false)
    protected SessionContext sessionContext;

    protected <T> Result<T> result(Integer status, String msg, T data) {
        return new Result<>(status, msg, data);
    }

    protected <T> Result<T> result(Integer status, String msg) {
        return new Result<>(status, msg, null);
    }

    protected <T> Result<T> result(Integer status) {
        return new Result<>(status, null, null);
    }

    protected Result success() {
        return result(Status.SUCCESS, null, null);
    }

    protected Result success(String msg) {
        return result(Status.SUCCESS, msg, null);
    }

    protected <T> Result<T> success(T data) {
        return result(Status.SUCCESS, null, data);
    }

    protected <T> Result<T> success(String msg, T data) {
        return result(Status.SUCCESS, msg, data);
    }

    protected Result fail() {
        return result(Status.FAIL, null, null);
    }

    protected Result fail(String msg) {
        return result(Status.FAIL, msg, null);
    }

    protected <T> Result<T> fail(T data) {
        return result(Status.FAIL, null, data);
    }

    protected <T> Result<T> fail(String msg, T data) {
        return result(Status.FAIL, msg, data);
    }
}
