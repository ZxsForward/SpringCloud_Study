package com.example.order.controller;

import com.example.order.feign.ProductFeignService;
import com.example.order.feign.StockFeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orderOpenFeign")
public class OrderOpenFeignController {

//    3、自动注入并调用
    @Autowired
    private StockFeignService stockFeignService;

    @Autowired
    private ProductFeignService productFeignService;

    @GetMapping("/add")
    public String add(){
        System.out.println("下单成功");

        String s = stockFeignService.reduct();

        String p = productFeignService.get(1);

        return "Hello Feign，" + s + "，" + p;
    }
}
