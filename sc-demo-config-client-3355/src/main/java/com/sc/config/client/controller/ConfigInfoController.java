package com.sc.config.client.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: jiangbaojun
 * @Date: 2020/2/21 14:20
 */
@RestController
@RefreshScope
public class ConfigInfoController {

    @Autowired
    Environment env;

    @Value("${spring.datasource.driver-class-name}")
    private String driverClassName;

    @Value("${spring.datasource.url}")
    private String url;

    @RequestMapping("/config/info")
    public String getInfo(){
        String[] pros = env.getActiveProfiles();
        for(String pro:pros){
            System.out.println(pro);
        }
        return "driver-class-name:"+driverClassName+
                System.getProperty("line.separator")+"url:"+url+
                System.getProperty("line.separator")+"name:"+env.getProperty("spring.name");
    }
}
