package com.example.ribbon;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 随机负载均衡策略
 */
@Configuration
public class RibbonRandomRuleConfig {

//    方法名必须叫iRule
    @Bean
    public IRule iRule(){
        return new RandomRule();
    }
}
