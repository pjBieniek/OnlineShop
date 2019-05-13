package com.codecool.models;

import java.util.List;

public class Category {

    private Integer id;
    private String name;
    private List<Product> products;

    public Category(String name) {
        this.name = name;
        
    }

    public List<Product> getProducts() {
        return products;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String toString(){
        return "" + getName() + "" + getId();
    }
}
