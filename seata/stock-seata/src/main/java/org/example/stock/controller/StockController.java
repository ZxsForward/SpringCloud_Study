package org.example.stock.controller;

import org.example.stock.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/stock")
public class StockController {

    @Autowired
    private StockService stockService;

    @RequestMapping("/reduct/{productId}")
    public String reduct(@PathVariable int productId){
        stockService.reduct(productId);
        return "扣减库存";
    }
}
