package com.moda.demo.controller;

import com.moda.BaseController;
import com.moda.demo.entity.User;
import com.moda.demo.request.UserGetSimpleRequest;
import com.moda.demo.request.UserListByStatusRequest;
import com.moda.demo.request.UserSearchRequest;
import com.moda.demo.response.UserGetSimpleResponse;
import com.moda.demo.service.UserService;
import com.moda.entity.persistence.page.Page;
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
@RequestMapping(value = "/user/", method = RequestMethod.POST)
public class UserController extends BaseController {
    @Reference
    private UserService userService;

    @RequestMapping("getSimple")
    @ApiOperation(value = "用户信息", notes = "根据输入用户ID查询用户基本信息")
    public Result<UserGetSimpleResponse> getSimple(@RequestBody UserGetSimpleRequest param) {
        return success(userService.getSimple(param));
    }

    @RequestMapping("search")
    @ApiOperation(value = "用户信息", notes = "根据关键词搜索用户信息")
    public Result<Page<User>> search(@RequestBody UserSearchRequest request) {
        return success(userService.search(request));
    }

    @RequestMapping("listByStatus")
    @ApiOperation(value = "用户信息", notes = "根据状态搜索用户信息")
    public Result<Page<User>> listByStatus(@RequestBody UserListByStatusRequest request) {
        return success(userService.listByStatus(request));
    }
}
