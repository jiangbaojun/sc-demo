package com.sc.provider.dept.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.sc.api.entity.Dept;
import com.sc.provider.dept.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 服务提供者，使用hystrix熔断机制
 * 当服务不可用，如抛出异常时，执行fallbackMethod。此种方式在服务提供端处理
 * @Author: jiangbaojun
 * @Date: 2020/2/17 18:40
 */
@RestController
@RequestMapping("/provider/dept")
public class HystrixDeptController {
    @Autowired
    private DeptService deptService;

    /**
     * 测试服务熔断
     * @Author jiangbaojun
     * @Date 2020/2/20 11:24
     */
    @GetMapping("/get/{id}")
    @HystrixCommand(fallbackMethod = "queryByIdHystrix")
    public Dept queryById(@PathVariable("id") Long id){
        Dept dept = deptService.queryById(id);
        if(dept==null){
            throw new RuntimeException("该部门不存在，id："+id);
        }
        return dept;
    }

    private Dept queryByIdHystrix(Long id){
        return new Dept()
                .setDname("id:"+id+",不存在该信息，circuit break")
                .setDb_source("no database on mysql");
    }
}
