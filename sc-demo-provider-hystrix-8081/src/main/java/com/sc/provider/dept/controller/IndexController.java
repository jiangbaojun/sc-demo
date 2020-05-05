package com.sc.provider.dept.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * 页面测试
 */
@Controller
public class IndexController {

    @RequestMapping("/")
    public String index(Model model, HttpServletRequest request){

    	model.addAttribute("paramName", request.getParameter("name"));
    	model.addAttribute("content", "Hello Thymeleaf8");
        System.out.println(request.getAttribute("basePath"));
        return "index";
    }
}