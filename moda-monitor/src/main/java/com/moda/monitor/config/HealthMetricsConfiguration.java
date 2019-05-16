package com.moda.monitor.config;

import com.moda.monitor.checker.NacosChecker;
import com.moda.monitor.checker.ServiceChecker;
import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.Tags;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.health.CompositeHealthIndicator;
import org.springframework.boot.actuate.health.HealthAggregator;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author lyh
 * @date 2019-05-16
 **/
@Configuration
public class HealthMetricsConfiguration {
    private final static Logger logger = LoggerFactory.getLogger(HealthMetricsConfiguration.class);
    private CompositeHealthIndicator healthIndicator;
    @Autowired
    private ServiceChecker serviceChecker;
    @Autowired
    private NacosChecker nacosChecker;

    public HealthMetricsConfiguration(HealthAggregator healthAggregator,
                                      List<HealthIndicator> healthIndicators,
                                      MeterRegistry registry) {

        Map<String, HealthIndicator> map = new HashMap<>();
        for (int i = 0; i < healthIndicators.size(); i++) {
            map.put(Integer.toString(i), healthIndicators.get(i));
        }
        healthIndicator = new CompositeHealthIndicator(healthAggregator, map);

        //service status
        ServiceChecker.services.forEach((k, v) -> {
            v.forEach(instance -> {
                registry.gauge("service.health.status",
                        Tags.of("exported_application", k, "exported_instance", instance),
                        healthIndicator, h -> {
                            logger.info("service.health.status");
                            return serviceChecker.getStatus(instance);
                        });
            });
        });

        //nacos status
        NacosChecker.services.forEach((k, v) -> {
            v.forEach(instance -> {
                registry.gauge("service.health.status",
                        Tags.of("exported_application", k, "exported_instance", instance),
                        healthIndicator, h -> {
                            logger.info("nacos.health.status");
                            return nacosChecker.getStatus(instance);
                        });
            });
        });
    }
}