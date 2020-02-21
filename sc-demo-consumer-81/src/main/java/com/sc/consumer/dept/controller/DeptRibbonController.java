package com.sc.consumer.dept.controller;

import com.sc.api.entity.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * 服务消费者
 * 使用ribbon集群方式
 * @Author: jiangbaojun
 * @Date: 2020/2/18 10:41
 */
@RestController
@RequestMapping("/consumer/dept")
public class DeptRibbonController {

    @Autowired
    private RestTemplate restTemplate;

    //使用服务提供者的应用名称作为地址（yml文件中的spring.application.name）
    private final String URL_PREDIX = "HTTP://sc-demo-provider-dept/provider/dept";

    @RequestMapping("/add")
    public boolean addDept(){
        String dname = "xiaoming";
        return restTemplate.postForObject(URL_PREDIX+"/add", new Dept(dname),Boolean.class);
    }

    @RequestMapping("/get/{id}")
    public Dept queryById(@PathVariable Long id){
        return restTemplate.getForObject(URL_PREDIX+"/get/"+id,Dept.class);
    }

    @RequestMapping("/all")
    public List<Dept> queryAll(){
        return restTemplate.getForObject(URL_PREDIX+"/all",List.class);
    }
}
