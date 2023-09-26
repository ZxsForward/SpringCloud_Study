package com.example.order.feign;

import org.springframework.stereotype.Component;

@Component
public class StockFeignServiceFallBack implements StockFeignService {
    @Override
    public String reduct2() {
        return "降级了！！！";
    }
}
