package com.moda.entity.exception;

import com.moda.entity.rest.Status;

/**
 * 业务异常类，用于业务异常抛出
 *
 * @author lyh
 * @create 2018-08-27 03:53:28
 */
public class ServiceException extends RuntimeException {
    /**
     * 状态
     */
    private Integer status = Status.FAIL;
    /**
     * 参数
     */
    private Object parameter;

    public ServiceException() {
        super();
    }

    public ServiceException(String message) {
        super(message);
    }

    public ServiceException(Integer status) {
        super();
        this.status = status;
    }

    public ServiceException(Object parameter) {
        super();
        this.parameter = parameter;
    }

    public ServiceException(Throwable cause) {
        super(cause);
    }

    public ServiceException(Integer status, String message) {
        super(message);
        this.status = status;
    }

    public ServiceException(String message, Throwable cause) {
        super(message, cause);
    }

    public ServiceException(String message, Object parameter) {
        super(message);
        this.parameter = parameter;
    }

    public ServiceException(Integer status, String message, Object parameter) {
        super(message);
        this.status = status;
        this.parameter = parameter;
    }

    public ServiceException(String message, Throwable cause,
                            boolean enableSuppression,
                            boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public Integer getStatus() {
        return status;
    }

    public Object getParameter() {
        return parameter;
    }
}
