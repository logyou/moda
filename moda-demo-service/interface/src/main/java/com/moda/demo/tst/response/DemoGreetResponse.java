package com.moda.demo.tst.response;

import com.moda.entity.rest.BaseResponse;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author lyh
 * @date 2019-04-25 17:03
 **/
public class DemoGreetResponse extends BaseResponse {
    @ApiModelProperty("问候语")
    private String say;

    public String getSay() {
        return say;
    }

    public void setSay(String say) {
        this.say = say;
    }
}
