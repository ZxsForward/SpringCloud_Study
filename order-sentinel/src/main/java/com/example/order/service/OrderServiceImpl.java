package com.example.order.service;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements IOrderService{
    @Override
    @SentinelResource(value = "getUser",blockHandler = "blockHandlerGetUser")
    public String getUser() {
        return "查询成功";
    }

    public String blockHandlerGetUser(BlockException e){
        return "流控用户";
    }
}
