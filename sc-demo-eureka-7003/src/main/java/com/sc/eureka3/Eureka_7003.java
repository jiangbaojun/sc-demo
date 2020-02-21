package com.sc.eureka3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @Author: jiangbaojun
 * @Date: 2020/2/18 12:30
 */
@SpringBootApplication
@EnableEurekaServer
public class Eureka_7003 {
    public static void main(String[] args) {
        SpringApplication.run(Eureka_7003.class, args);
    }
}
