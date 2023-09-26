package org.example.order.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.example.order.pojo.Order;

@Mapper
public interface OrderMapper {
    int create(Order order);
}
