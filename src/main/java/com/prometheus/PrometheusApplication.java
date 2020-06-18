package com.prometheus;

import com.prometheus.metrics.MetricsRegister;
import io.prometheus.client.exporter.MetricsServlet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

/**
 * @author songjiuhua
 * Created by 2020/6/17 18:42
 */
@SpringBootApplication
public class PrometheusApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(PrometheusApplication.class, args);
        MetricsRegister metricsRegister = context.getBean(MetricsRegister.class);
        metricsRegister.register();
    }

    /**
     * 配置一个servlet，将服务中的生成的指标通过http://localhost:8080/{context-path}/metrics暴露出去
     * @return
     */
    @Bean
    public ServletRegistrationBean<MetricsServlet> servletRegistrationBean() {
        MetricsServlet metricsServlet = new MetricsServlet();
        return new ServletRegistrationBean<>(metricsServlet, "/metrics");
    }

}
