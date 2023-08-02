package com.example.order.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/order")
public class OrderController {

    //通过restTemplate进行远程服务的调用，比如在当前项目中调用stock项目的方法
    @Autowired
    RestTemplate restTemplate;

    @GetMapping("/add")
    public String add(){
        System.out.println("下单成功");
        String msg = restTemplate.getForObject("http://localhost:8011/stock/reduct", String.class);
        return "Hello World，" + msg;
    }
}
