package com.example.order.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/order")
public class OrderNacosController {

    //通过restTemplate进行远程服务的调用，比如在当前项目中调用stock-nacos项目的方法
    @Autowired
    RestTemplate restTemplate;

    @GetMapping("/add")
    public String add(){
        System.out.println("下单成功");
        String msg = restTemplate.getForObject("http://stock-service/stock/reduct", String.class);
        return "Hello World，" + msg;
    }

    @GetMapping("/header")
    public String header(@RequestHeader("X-Request-red") String color){
        //此方法是在测试gateway的内置过滤器
        return color;
    }

    //下面的方法是为了测试gateway整合sentinel
    @GetMapping("/flow")
    public String flow(){
        return "正常访问";
    }

    @GetMapping("/flowThread")
    public String flowThread() throws InterruptedException {
        Thread.sleep(2000);
        return "线程正常访问";
    }

    @GetMapping("/get/{id}")
    public String getByID(@PathVariable int id){
        System.out.println("正常访问");
        return "正常访问";
    }
}
