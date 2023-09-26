package org.example.order.pojo;

import lombok.Data;

@Data
public class Order {

    private int productId;
    private int status;
    private int totalAmount;
}
