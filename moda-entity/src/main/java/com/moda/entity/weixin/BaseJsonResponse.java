package com.moda.entity.weixin;

import com.moda.entity.BaseEntity;

/**
 * 用于微信接口响应的基础类
 *
 * @author lyh
 * @version 2018-9-18
 */
public class BaseJsonResponse extends BaseEntity {
    private Integer errcode;// 错误编码
    private String errmsg;// 错误消息

    /**
     * 错误编码
     *
     * @return
     * @see ErrCode
     */
    public Integer getErrcode() {
        return errcode;
    }

    public void setErrcode(Integer errcode) {
        this.errcode = errcode;
    }

    /**
     * 错误消息
     *
     * @return
     * @see ErrCode
     */
    public String getErrmsg() {
        if (errcode != null) {
            return String.format("%s（%s）", errmsg, ErrCode.errMsg(errcode));
        } else {
            return errmsg;
        }
    }

    public void setErrmsg(String errmsg) {
        this.errmsg = errmsg;
    }
}
