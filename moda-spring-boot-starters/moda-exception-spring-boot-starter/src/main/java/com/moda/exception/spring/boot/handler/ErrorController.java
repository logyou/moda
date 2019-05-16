package com.moda.exception.spring.boot.handler;

import com.moda.entity.rest.Result;
import com.moda.web.spring.boot.controller.BaseController;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 * 全局错误处理
 *
 * @author lyh
 * @date 2019-5-6
 **/
@RestController
@RequestMapping("/error/")
public class ErrorController extends BaseController {

    @RequestMapping(value = "400")
    @ResponseStatus(HttpStatus.OK)
    public Result error400() {
        return fail("参数不正确！");
    }

    @RequestMapping(value = "401")
    @ResponseStatus(HttpStatus.OK)
    public Result error401() {
        return fail("未授权，请联系系统管理员！");
    }

    @RequestMapping(value = "403")
    @ResponseStatus(HttpStatus.OK)
    public Result error403() {
        return fail("禁止访问，请联系系统管理员！");
    }

    @RequestMapping(value = "404")
    @ResponseStatus(HttpStatus.OK)
    public Result error404() {
        return fail("您访问的服务地址不存在，请检查后重试！");
    }

    @RequestMapping(value = "415")
    @ResponseStatus(HttpStatus.OK)
    public Result error415() {
        return fail("不支持的参数类型， Content-Type 为 application/json ！");
    }

    @RequestMapping(value = "500")
    @ResponseStatus(HttpStatus.OK)
    public Result error500() {
        return fail("抱歉，服务器繁忙，请稍后重试！");
    }

    @RequestMapping(value = "429")
    @ResponseStatus(HttpStatus.OK)
    public Result error429() {
        return fail("您访问过于频繁，请先休息一会！");
    }
}
