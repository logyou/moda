package com.moda.demo.tst.response;

import com.moda.entity.rest.BaseResponse;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author lyh
 * @date 2019-04-28 18:13
 **/
public class UserGetSimpleResponse extends BaseResponse {
    @ApiModelProperty("用户ID")
    private Integer id;
    @ApiModelProperty("昵称")
    private String nickname;
    @ApiModelProperty("手机号")
    private String mobile;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }
}
