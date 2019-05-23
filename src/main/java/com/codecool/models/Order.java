package com.codecool.models;

import java.util.Date;

public class Order {

    private Integer id;
    private Basket basket;
    private Customer customer;
    private Date orderCreatedAt;
    private OrderStatus orderStatus;
    private Date orderPayAt;

    public Boolean pay() {
        return false;
    }
}
