package com.sc.provider.dept.config;

import org.springframework.context.annotation.Configuration;

/**
 * 添加hystrix.stream监控
 * @Author: jiangbaojun
 * @Date: 2020/2/20 15:45
 */
@Configuration
public class ApplicationConfig {

    /**
     * 在yml中配置开启即可，不推荐在这添加servlet
     */
//    @Bean
//    public ServletRegistrationBean getHystrixMetricsStreamServlet(){
//        ServletRegistrationBean servletBean = new ServletRegistrationBean(new HystrixMetricsStreamServlet());
//        servletBean.addUrlMappings("/actuator/hystrix.stream");
//        return servletBean;
//    }
}
