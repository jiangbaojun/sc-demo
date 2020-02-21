package com.sc.consumer.dept.controller;

import com.sc.api.entity.Dept;
import com.sc.api.service.FeignDeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 服务消费者，使用feign
 * @Author: jiangbaojun
 * @Date: 2020/2/18 10:41
 */
@RestController
@RequestMapping("/consumer/feign/dept")
public class FeignDeptController {

    @Autowired
    private FeignDeptService service;

    @RequestMapping("/add")
    public boolean addDept(){
        return service.addDept(new Dept("xiaoqiang"));
    }

    @RequestMapping("/get/{id}")
    public Dept queryById(@PathVariable("id") Long id){
        return service.queryById(id);
    }

    @RequestMapping("/all")
    public List<Dept> queryAll(){
        return service.queryAll();
    }
}
