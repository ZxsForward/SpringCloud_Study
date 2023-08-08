package com.example.order;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class OrderOpenFeignSentinelApplication {

    public static void main(String[] args) {
        SpringApplication.run(OrderOpenFeignSentinelApplication.class,args);
    }

}
