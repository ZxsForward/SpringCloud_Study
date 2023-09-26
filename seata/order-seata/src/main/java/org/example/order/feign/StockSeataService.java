package org.example.order.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name = "stock-seata",path = "/stock")
public interface StockSeataService {

    @RequestMapping("/reduct/{productId}")
    public String reduct(@PathVariable("productId") int productId);
}
