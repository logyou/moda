package com.moda.monitor.controller;

import com.moda.entity.rest.Result;
import com.moda.web.spring.boot.controller.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Controller
 *
 * @author lyh
 * @date 2019-5-14
 **/
@RestController
@RequestMapping(value = "/export/")
public class ExportController extends BaseController {
    @Autowired
    private DiscoveryClient discoveryClient;

    @RequestMapping(value = "services")
    public Result services() {
        List<String> serviceIds = discoveryClient.getServices();
        serviceIds.forEach(id -> {
            List<ServiceInstance> instances = discoveryClient.getInstances(id);
            instances.forEach(instance -> {
                logger.info("{}:{}:{}/{}",
                        instance.getScheme(),
                        instance.getHost(),
                        instance.getPort(),
                        instance.getUri());
            });
        });
        return success(serviceIds);
    }
}
