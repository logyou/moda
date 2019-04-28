package com.moda.entity.rest;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * 修改
 *
 * @author lyh
 * @create 2018-09-20 13:58
 **/
public class BaseModifyDTO extends BaseDTO {
    /**
     * 操作人UID
     */
    @NotNull(message = "缺少操作人UID")
    @Min(value = 1, message = "操作人UID必须是大于0的整数")
    private Integer operatorUid;

    public Integer getOperatorUid() {
        return operatorUid;
    }

    public void setOperatorUid(Integer operatorUid) {
        this.operatorUid = operatorUid;
    }
}
