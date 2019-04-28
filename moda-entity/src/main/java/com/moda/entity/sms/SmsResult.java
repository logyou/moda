package com.moda.entity.sms;

import com.moda.entity.BaseEntity;

/**
 * 短信结果
 *
 * @author lyh
 * @version 2018-09-02
 */
public class SmsResult extends BaseEntity {
    private int code = -1;
    private String msg;
    private String detail;
    private Boolean isSuccess;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public Boolean getIsSuccess() {
        isSuccess = (this.code == 0);
        return isSuccess;
    }

    public void setIsSuccess(Boolean isSuccess) {
        this.isSuccess = isSuccess;
    }
}
