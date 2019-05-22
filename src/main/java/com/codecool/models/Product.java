package com.codecool.models;

import java.math.BigDecimal;

public class Product implements Validator {

    private Integer id;
    private String name;
    private BigDecimal price;
    private Integer amount;
    private Boolean isAvailable;
    private Category category;

    public Product(String name, BigDecimal price, Integer amount, Boolean isAvailable, Category category) {
        this.name = name;
        this.price = price;
        this.amount = amount;
        this.isAvailable = isAvailable;
        this.category = category;
    }

    public String toString(){
        return "id: " + id + ", name " + name + ", price: " + price + ", amount: " + amount + ", is aviable: " + isAvailable + ", category: " + category;
    }
}