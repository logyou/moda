package com.moda.demo.tst.request;

import com.moda.entity.rest.BaseRequest;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author lyh
 * @date 2019-04-28 18:10
 **/
public class AreaGetSimpleRequest extends BaseRequest {
    @ApiModelProperty("ID")
    private Integer id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
