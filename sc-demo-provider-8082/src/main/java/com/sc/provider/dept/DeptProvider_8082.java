package com.sc.provider.dept;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * 服务提供的启动，eureka客户端
 * @Author: jiangbaojun
 * @Date: 2020/2/17 18:46
 */
@SpringBootApplication
@EnableEurekaClient
public class DeptProvider_8082 {

    public static void main(String[] args) {
        SpringApplication.run(DeptProvider_8082.class, args);
    }
}
