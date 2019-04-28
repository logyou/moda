package com.moda.demo.tst.controller;

import com.moda.BaseController;
import com.moda.demo.tst.request.DemoGreetRequest;
import com.moda.demo.tst.response.DemoGreetResponse;
import com.moda.demo.tst.service.DemoService;
import com.moda.entity.rest.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * Controller
 *
 * @author lyh
 * @date 2019-04-02 17:36:58
 **/
@RestController
@Api(tags = "演示", description = "演示操作相关接口")
@RequestMapping(value = "/tst/demo/", method = RequestMethod.POST)
public class DemoController extends BaseController {
    @Reference
    private DemoService demoService;

    @RequestMapping("greet")
    @ApiOperation(value = "问候", notes = "根据输入的用户问候")
    public Result<DemoGreetResponse> greet(@RequestBody DemoGreetRequest param) {
        logger.info(param.getName());
        logger.debug(new Date().toString());
        DemoGreetResponse result = new DemoGreetResponse();
        result.setSay(demoService.greet(param.getName()));
        return success(result);
    }

}
