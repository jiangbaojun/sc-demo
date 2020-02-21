package com.sc.provider.dept.config;

import com.netflix.hystrix.contrib.metrics.eventstream.HystrixMetricsStreamServlet;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: jiangbaojun
 * @Date: 2020/2/20 15:45
 */
@Configuration
public class ApplicationConfig {

    @Bean
    public ServletRegistrationBean getHystrixMetricsStreamServlet(){
        ServletRegistrationBean servletBean = new ServletRegistrationBean(new HystrixMetricsStreamServlet());
        servletBean.addUrlMappings("/actuator/hystrix.stream");
        return servletBean;
    }
}
