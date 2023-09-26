package org.example.stock.service.impl;

import org.example.stock.mapper.StockMapper;
import org.example.stock.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StockServiceImpl implements StockService {

    @Autowired
    private StockMapper stockMapper;

    @Override
    public int reduct(int productId) {
        System.out.println("更新商品：" + productId);
        return stockMapper.reduct(productId);
    }
}
