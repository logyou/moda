package com.moda.demo.request;

import com.moda.entity.rest.BaseRequest;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author lyh
 * @date 2019-04-29 18:22
 **/
public class UserListByStatusRequest extends BaseRequest {
    @ApiModelProperty("状态")
    private Integer status;

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
