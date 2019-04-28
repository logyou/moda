package com.moda.demo.tst.response;

import com.moda.entity.rest.BaseResponse;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author lyh
 * @date 2019-04-28 18:13
 **/
public class AreaGetSimpleResponse extends BaseResponse {
    @ApiModelProperty("ID")
    private Integer id;
    @ApiModelProperty("名称")
    private String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
