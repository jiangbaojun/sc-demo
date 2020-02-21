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
 * 没有加入ribbon，直接调用指定的消费者
 * @Author: jiangbaojun
 * @Date: 2020/2/18 10:41
 */
@RestController
@RequestMapping("/consumer/single/dept")
public class DeptController {

    @Autowired
    private RestTemplate restTemplate;

    private final String URL_PREDIX = "HTTP://127.0.0.1:8081/provider/dept";

    @RequestMapping("/add")
    public boolean addDept(){
        String dname = "xiaoming";
        return restTemplate.postForObject(URL_PREDIX+"/add", new Dept(dname),Boolean.class);
    }

    @RequestMapping("/get/{id}")
    public Dept queryById(@PathVariable Long id){
        return restTemplate.getForObject(URL_PREDIX+"/"+id,Dept.class);
    }

    @RequestMapping("/all")
    public List<Dept> queryAll(){
        return restTemplate.getForObject(URL_PREDIX+"/all",List.class);
    }
}
