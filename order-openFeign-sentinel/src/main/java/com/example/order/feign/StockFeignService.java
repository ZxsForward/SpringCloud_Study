package com.example.order.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * 2、添加feign接口和方法
 * name 指定调用的rest接口所对应的服务名
 * path 指定调用的rest接口所在的Controller指定的@RequestMapping
 *
 * 局部配置的两种方法
 * 1、configuration = FeignConfig.class
 * 2、在yml文件中添加feign:client:config:
 *
 * 在FeignConfig中加入@Configuration注解可使配置全局生效
 */
@FeignClient(name = "stock-service",path = "/stock",fallback = StockFeignServiceFallBack.class)
public interface StockFeignService {

    //声明需要调用的rest接口的方法
    @GetMapping("/reduct2")
    String reduct2();
}
