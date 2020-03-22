package com.sc.config.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @Author: jiangbaojun
 * @Date: 2020/2/21 14:24
 */
@SpringBootApplication
@EnableEurekaClient
public class CloudConfigClient_3355 {
    public static void main(String[] args) {
        SpringApplication.run(CloudConfigClient_3355.class, args);
    }
}
