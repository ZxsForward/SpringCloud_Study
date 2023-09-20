package com.example.order.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name = "product-service",path = "/product")
public interface ProductFeignService {

    //feign原生注解
//    @RequestLine("GET /{id}")
//    String get(@Param("id") Integer id);

    @RequestMapping("/{id}")
    String get(@PathVariable("id") Integer id);
}
