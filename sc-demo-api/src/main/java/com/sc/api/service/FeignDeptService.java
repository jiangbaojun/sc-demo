package com.sc.api.service;

import com.sc.api.entity.Dept;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

/**
 * feign接口
 * 方法的requestmapping注解值，必须和服务提供者的地址相匹配
 * @Author: jiangbaojun
 * @Date: 2020/2/20 09:19
 */
@Component
@FeignClient(value = "sc-demo-provider-dept", fallbackFactory = FeignDeptServiceFallbakFactory.class)
public interface FeignDeptService {

    @PostMapping("/provider/dept/add")
    public boolean addDept(Dept dept);

    @GetMapping("/provider/dept/get/{id}")
    public Dept queryById(@PathVariable("id") Long id);

    @GetMapping("/provider/dept/all")
    public List<Dept> queryAll();
}
