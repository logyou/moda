package com.moda.demo.request;

import com.moda.entity.rest.BaseRequest;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author lyh
 * @date 2019-04-29 18:22
 **/
public class UserSearchRequest extends BaseRequest {
    @ApiModelProperty("手机号")
    private String mobile;

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }
}
