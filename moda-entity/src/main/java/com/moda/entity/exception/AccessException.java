package com.moda.entity.exception;

/**
 * 访问异常类，用于访问异常抛出
 *
 * @author lyh
 * @create 2018-9-21
 */
public class AccessException extends ServiceException {

    public AccessException() {
        super();
    }

    public AccessException(Integer status) {
        super(status);
    }

    public AccessException(String message) {
        super(message);
    }

    public AccessException(Object parameter) {
        super(parameter);
    }

    public AccessException(Throwable cause) {
        super(cause);
    }

    public AccessException(Integer status, String message) {
        super(status, message);
    }

    public AccessException(String message, Throwable cause) {
        super(message, cause);
    }

    public AccessException(String message, Object parameter) {
        super(message, parameter);
    }

    public AccessException(Integer status, String message, Object parameter) {
        super(status, message, parameter);
    }

    public AccessException(String message, Throwable cause,
                           boolean enableSuppression,
                           boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
