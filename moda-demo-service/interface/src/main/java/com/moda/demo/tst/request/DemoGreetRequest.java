package com.moda.demo.tst.request;

import com.moda.entity.rest.BaseRequest;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author lyh
 * @create 2019-04-02 17:36:58
 **/
public class DemoGreetRequest extends BaseRequest {
    @ApiModelProperty("姓名")
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
