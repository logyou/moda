package com.moda.entity.rest;

import com.moda.entity.BaseEntity;
import io.swagger.annotations.ApiModelProperty;

/**
 * 接口返回结果
 *
 * @author lyh
 * @date 2019-4-25 17:59:28
 **/
public class Result<T> extends BaseEntity {
    /**
     * 状态
     */
    @ApiModelProperty("状态")
    private Integer status;
    /**
     * 消息
     */
    @ApiModelProperty("消息")
    private String message;
    /**
     * 数据
     */
    @ApiModelProperty("数据")
    private T data;

    public Result() {
    }

    public Result(Integer status) {
        this.status = status;
    }

    public Result(Integer status, String message) {
        this.status = status;
        this.message = message;
    }

    public Result(Integer status, String message, T data) {
        this.status = status;
        this.message = message;
        this.data = data;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
