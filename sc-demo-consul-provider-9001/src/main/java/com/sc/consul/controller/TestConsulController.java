package com.sc.consul.controller;

import com.sc.api.entity.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/provider/dept")
public class TestConsulController {

    @PostMapping("/hello")
    public String addDept(Dept dept){
        return "hello";
    }

    @GetMapping("/get/{id}")
    public Dept queryById(@PathVariable("id") Long id){
        Dept t = new Dept();
        t.setDname("小明");
        t.setDeptno(id);
        return t;
    }

}
