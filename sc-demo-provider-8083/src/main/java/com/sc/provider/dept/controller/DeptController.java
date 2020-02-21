package com.sc.provider.dept.controller;

import com.sc.api.entity.Dept;
import com.sc.provider.dept.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 服务提供者
 * @Author: jiangbaojun
 * @Date: 2020/2/17 18:40
 */
@RestController
@RequestMapping("/provider/dept")
public class DeptController {
    @Autowired
    private DeptService deptService;

    @PostMapping("/add")
    public boolean addDept(@RequestBody Dept dept){
        return deptService.addDept(dept);
    }

    @GetMapping("/get/{id}")
    public Dept queryById(@PathVariable("id") Long id){
        return deptService.queryById(id);
    }

    @GetMapping("/all")
    public List<Dept> queryAll(){
        return deptService.queryAll();
    }
}
