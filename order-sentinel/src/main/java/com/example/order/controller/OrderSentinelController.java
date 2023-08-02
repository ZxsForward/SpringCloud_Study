package com.example.order.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orderSentinel")
public class OrderSentinelController {

    @GetMapping("/add")
    public String add(){
        System.out.println("下单成功");
        return "Hello World" ;
    }

    @GetMapping("flow")
    public String flow(){
        return "正常访问";
    }
}
