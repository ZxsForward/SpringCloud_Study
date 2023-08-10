package com.example.order.controller;

import com.example.order.feign.StockFeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orderOpenFeignSentinel")
public class OrderOpenFeignController {

    @Qualifier("com.example.order.feign.StockFeignService")
    @Autowired
    private StockFeignService stockFeignService;

    @GetMapping("/add")
    public String add(){
        System.out.println("下单成功");
        String s = stockFeignService.reduct2();
        return "Hello Feign，" + s;
    }
}
