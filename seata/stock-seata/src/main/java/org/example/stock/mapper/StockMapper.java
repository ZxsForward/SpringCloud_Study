package org.example.stock.mapper;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface StockMapper {
    int reduct(int productId);
}
