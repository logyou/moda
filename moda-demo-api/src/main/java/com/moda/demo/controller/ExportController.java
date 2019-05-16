package com.moda.demo.controller;

import com.moda.entity.rest.Result;
import com.moda.web.spring.boot.controller.BaseController;
import io.micrometer.core.instrument.Metrics;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * Controller
 *
 * @author lyh
 * @date 2019-5-14
 **/
@RestController
@RequestMapping(value = "/export/")
public class ExportController extends BaseController {
    @RequestMapping(value = "test")
    public Result test(HttpServletRequest request, @RequestBody(required = false) String json) {
        Metrics.counter("spring_boot_requests_total", "app", "test-spring", "handler", request.getRequestURI()).increment();
        return success("OK");
    }
}
