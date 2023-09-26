package org.example.order.service.impl;

import io.seata.spring.annotation.GlobalTransactional;
import org.example.order.feign.StockSeataService;
import org.example.order.mapper.OrderMapper;
import org.example.order.pojo.Order;
import org.example.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderMapper orderMapper;

    @Autowired
    private StockSeataService stockSeataService;

    @Override
    @GlobalTransactional
    public Order create(Order order) {
        //插入
        orderMapper.create(order);
        //扣减库存
        String reduct = stockSeataService.reduct(order.getProductId());

        //手动异常
        int a = 1/0;
        return order;
    }
}
