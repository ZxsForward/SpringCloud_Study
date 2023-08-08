package com.example.order;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

//4、加入@EnableFeignClients注解

@SpringBootApplication
@EnableFeignClients
public class OrderOpenFeignSentinelApplication {

    public static void main(String[] args) {
        SpringApplication.run(OrderOpenFeignSentinelApplication.class,args);
    }

}
