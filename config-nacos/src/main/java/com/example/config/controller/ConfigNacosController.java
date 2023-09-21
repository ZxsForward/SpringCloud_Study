package com.example.config.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/config")
@RefreshScope //Nacos自带动态刷新功能，但是要想在Controller等生效，需要加此注解
public class ConfigNacosController {

    @Value("${user.name}")
    private String userName;

    @GetMapping("/show")
    public String show(){
        return userName;
    }
}
