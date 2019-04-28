package com.moda.demo.tst.controller;

import com.moda.BaseController;
import com.moda.demo.tst.request.AreaGetSimpleRequest;
import com.moda.demo.tst.response.AreaGetSimpleResponse;
import com.moda.demo.tst.service.AreaService;
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
@Api(tags = "地区", description = "地区操作相关接口")
@RequestMapping(value = "/tst/area/", method = RequestMethod.POST)
public class AreaController extends BaseController {
    @Reference
    private AreaService areaService;

    @RequestMapping("getSimple")
    @ApiOperation(value = "地区信息", notes = "根据输入地区ID查询地区基本信息")
    public Result<AreaGetSimpleResponse> getSimple(@RequestBody AreaGetSimpleRequest param) {
        return success(areaService.getSimple(param));
    }

}
