package com.sc.consumer.dept.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @Author: jiangbaojun
 * @Date: 2020/2/18 10:47
 */
@Configuration
public class ApplicationConfig {

    /**
     * 生成restTemplate bean
     * 单节点方式
     * @return
     */
//    @Bean
//    public RestTemplate getRestTemplate(){
//        return new RestTemplate();
//    }
    /**
     * 生成restTemplate bean
     * 使用ribbon集群方式。通过服务提供者的应用名称，从eureka中获得可用的服务提供者节点
     * @return org.springframework.web.client.RestTemplate
     * @Author jiangbaojun
     * @Date 2020/2/19 10:26
     */
    @Bean
    @LoadBalanced
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }
}
