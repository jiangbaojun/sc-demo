package com.sc.consumer.dept;

import com.sc.consumer.myrule.RuleConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

/**
 * @Author: jiangbaojun
 * @Date: 2020/2/18 11:02
 */
@SpringBootApplication
@EnableEurekaClient
@RibbonClient(name = "sc-demo-provider-dept", configuration = RuleConfig.class)
public class DeptConsumer_81 {
    public static void main(String[] args) {
        SpringApplication.run(DeptConsumer_81.class, args);
    }
}
