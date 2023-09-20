package com.example.order.feign;

import com.example.order.config.FeignConfig;
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
 *
 * feign的几个注意事项：
 *      1、feign接口必须和要远程调用的方法一致，包括注解、参数、url等
 *      2、feign接收参数时，需要指定参数，比如@PathVariable("id")、@RequestParam("id")等
 *      3、当参数请求为get并且参数有实体类时，feign会自动将get请求转为post请求
 *      4、使用feign传输对象时，必须使用@RequestBody注解（此项目当前版本的feign是必须）
 */
@FeignClient(name = "stock-service",path = "/stock",configuration = FeignConfig.class)
public interface StockFeignService {

    //声明需要调用的rest接口的方法
    @GetMapping("/reduct")
    String reduct();
}
