package com.sc.provider.dept.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 发现eureka上有哪些注册的服务
 * @Author: jiangbaojun
 * @Date: 2020/2/17 18:40
 */
@RestController
public class DiscoveryController {
    @Autowired
    private DiscoveryClient discoveryClient;

    @GetMapping("eureka/app/discovery")
    public Object discovery(){
       List<String> services = discoveryClient.getServices();
       for(String serviceName:services){
           System.out.println(serviceName);
           List<ServiceInstance> list = discoveryClient.getInstances(serviceName);
           System.out.println(list);
       }
       return discoveryClient;
    }
}
