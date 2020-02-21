package com.sc.zuul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * @Author: jiangbaojun
 * @Date: 2020/2/21 09:47
 */
@SpringBootApplication
@EnableZuulProxy
public class ZuulGateway_80 {
    public static void main(String[] args) {
        SpringApplication.run(ZuulGateway_80.class, args);
    }
}
