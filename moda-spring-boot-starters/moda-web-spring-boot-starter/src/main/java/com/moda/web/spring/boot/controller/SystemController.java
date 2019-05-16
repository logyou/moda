package com.moda.web.spring.boot.controller;

import com.moda.autoconfigure.product.ProductProperties;
import com.moda.entity.rest.Result;
import com.moda.util.date.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * 系统信息 Controller
 *
 * @author lyh
 * @date 2019-4-23 12:21:18
 */
@RestController
@EnableConfigurationProperties(ProductProperties.class)
@RequestMapping(value = "sys")
public class SystemController extends BaseController {
    @Autowired
    private ProductProperties productProperties;

    /**
     * 获取系统信息
     *
     * @return 系统信息
     */
    @RequestMapping(value = "info")
    public Result info() {
        Map<String, String> map = new HashMap<>(2);
        map.put("productName", productProperties.getName());
        map.put("serverTime", DateUtils.formatDateTime(new Date()));
        return success("系统信息", map);
    }
}