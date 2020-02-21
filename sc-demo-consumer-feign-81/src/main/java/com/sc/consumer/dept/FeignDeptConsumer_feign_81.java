package com.sc.consumer.dept;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

/**
 * @Author: jiangbaojun
 * @Date: 2020/2/18 11:02
 */
@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients(basePackages = {"com.sc.api"})
@ComponentScan({"com.sc.api","com.sc.consumer.dept"})   //注意componentsScan的覆盖问题，会覆盖@SpringBootApplication包含的扫描，要将本工程的包加进来。或者使用ComponentScans注解
public class FeignDeptConsumer_feign_81 {
    public static void main(String[] args) {
        SpringApplication.run(FeignDeptConsumer_feign_81.class, args);
    }
}
