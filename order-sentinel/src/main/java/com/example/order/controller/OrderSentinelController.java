package com.example.order.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.example.order.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orderSentinel")
public class OrderSentinelController {
    @GetMapping("flow")
//    @SentinelResource(value = "flow",blockHandler = "flowBlockHandler")
    public String flow(){
        return "正常访问";
    }

    public String flowBlockHandler(BlockException blockException){
        return "流控";
    }

    @GetMapping("flowThread")
    @SentinelResource(value = "flowThread",blockHandler = "flowBlockHandler")
    public String flowThread() throws InterruptedException {
        Thread.sleep(5000);
        return "线程正常访问";
    }

    @GetMapping("/add")
    public String add(){
        return "生成订单" ;
    }
    @GetMapping("/get")
    public String get(){
        return "查询订单" ;
    }

    @Autowired
    IOrderService service;
    @GetMapping("/test1")
    public String test1(){
        return service.getUser();
    }
    @GetMapping("/test2")
    public String test2(){
        return service.getUser();
    }

}
