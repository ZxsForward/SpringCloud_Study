package com.example.order.config;

import com.example.interceptor.feign.CustomFeignInterceptor;
import feign.Contract;
import feign.Logger;
import feign.Request;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 全局配置：当使用@Configuration时，会将配置作用在所有的服务提供方
 * 局部配置：如果只想针对某一个服务进行配置，就不要加@Configuration
 */
//@Configuration
public class FeignConfig {
    /**
     * feign的日志级别：
     * NONE：没有日志记录
     * BASIC：记录请求方法、URL以及响应状态代码和执行时间
     * HEADERS：记录基本信息以及请求和响应头信息
     * FULL：记录基本信息以及请求和响应头信息、请求和响应体信息
     */
    @Bean
    public Logger.Level feignLoggerLevel(){
        return Logger.Level.FULL;
    }

    /**
     * 修改契约配置，使Spring Cloud支持Feign原生的注解
     * @return
     */
//    @Bean
//    public Contract feignContract(){
//        return new Contract.Default();
//    }

    /**
     * 超时时间配置，单位毫秒
     * @return
     */
//    @Bean
//    public Request.Options options(){
//        return new Request.Options(5000,10000);
//    }

    /**
     * 自定义拦截器
     * @return
     */
//    @Bean
//    public CustomFeignInterceptor customFeignInterceptor(){
//        return new CustomFeignInterceptor();
//    }
}
