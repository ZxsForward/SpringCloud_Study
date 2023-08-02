package com.example.product.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/stock")
public class StockNacosController {

    @Value("${server.port}")
    String port;

    @GetMapping("/reduct")
    public String reduct(){
        System.out.println("扣减库存");
        return "扣减库存：" + port;
    }
}
