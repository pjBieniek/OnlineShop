package com.codecool.models;

import java.text.DecimalFormat;

public class Product {

    private Integer id;
    private String name;
    private DecimalFormat price;
    private Integer amount;
    private Boolean isAvailable;
    private Category category;

    public Product(String name, DecimalFormat price, Integer amount, Category category) {
        this.name = name;
        this.price = price;
        this.amount = amount;
        this.category = category;
    }

    public Integer getId() {
        return id;
    }

    public String toString(){
        return "";
    }
}
