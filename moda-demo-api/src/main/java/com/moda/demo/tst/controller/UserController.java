package com.moda.demo.tst.controller;

import com.moda.BaseController;
import com.moda.demo.tst.request.UserGetSimpleRequest;
import com.moda.demo.tst.response.UserGetSimpleResponse;
import com.moda.demo.tst.service.UserService;
import com.moda.entity.rest.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller
 *
 * @author lyh
 * @date 2019-04-02 17:36:58
 **/
@RestController
@Api(tags = "用户", description = "用户操作相关接口")
@RequestMapping(value = "/tst/demo/", method = RequestMethod.POST)
public class UserController extends BaseController {
    @Reference
    private UserService userService;

    @RequestMapping("user")
    @ApiOperation(value = "用户信息", notes = "根据输入用户ID查询用户基本信息")
    public Result<UserGetSimpleResponse> greet(@RequestBody UserGetSimpleRequest param) {
        return success(userService.getSimple(param));
    }

}
