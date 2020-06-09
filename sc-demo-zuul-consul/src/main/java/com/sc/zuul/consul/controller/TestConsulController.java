package com.sc.zuul.consul.controller;

import com.sc.api.entity.Dept;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/test")
public class TestConsulController {

    @PostMapping("/hello")
    public String addDept(Dept dept){
        return "hello";
    }

    @GetMapping("/get/{id}")
    public Dept queryById(@PathVariable("id") Long id, HttpServletRequest request){
        request.getSession().setAttribute("abc", "123");
        Dept t = new Dept();
        t.setDname("小明");
        t.setDeptno(id);
        return t;
    }

}
