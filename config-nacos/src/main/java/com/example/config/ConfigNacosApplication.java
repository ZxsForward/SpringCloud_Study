package com.example.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.concurrent.TimeUnit;

@SpringBootApplication
public class ConfigNacosApplication {

    public static void main(String[] args) throws InterruptedException {
        ConfigurableApplicationContext run = SpringApplication.run(ConfigNacosApplication.class, args);
        while (true){
            String userName = run.getEnvironment().getProperty("user.name");
            String userConfig = run.getEnvironment().getProperty("user.config");
            System.out.println("user.name：" + userName);
            System.out.println("user.config：" + userConfig);
            TimeUnit.SECONDS.sleep(1);
        }
    }
}
