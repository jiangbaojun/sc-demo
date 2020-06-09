package com.sc.config.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @Author: jiangbaojun
 * @Date: 2020/2/21 11:20
 */
@SpringBootApplication
@EnableConfigServer
@EnableEurekaClient
public class CloudConfigServer_3344 {
    public static void main(String[] args) {
        SpringApplication.run(CloudConfigServer_3344.class, args);
    }
}
