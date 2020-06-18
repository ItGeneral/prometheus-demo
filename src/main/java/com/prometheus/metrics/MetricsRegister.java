package com.prometheus.metrics;

import io.prometheus.client.Gauge;
import org.springframework.stereotype.Component;

/**
 * @author songjiuhua
 * Created by 2020/6/17 18:43
 */
@Component
public class MetricsRegister {

    private static final Gauge GAUGE = Gauge.build()
            .labelNames("name", "service")
            .name("spring_boot_prometheus_test").help("test").register();

    /**
     * 在内存中生成一个名为spring_boot_prometheus_test的指标
     * 标签有name和service
     */
    public void register(){
        GAUGE.labels("test-prometheus", "SpringBoot").set(10);
    }


}
