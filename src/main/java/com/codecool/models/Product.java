package com.codecool.models;

import java.util.List;
import java.util.Random;
import java.Math.BigDecimal;

import com.codecool.dao.ProductDaoSQL;

public class Product implements Validator {

    private Integer id;
    private String name;
    private BigDecimal price;
    private Integer amount;
    private Boolean isAvailable;
    private String category;

    public Product(String name, BigDecimal price, Integer amount, Boolean isAvailable, String category) {
        id = generateId();
        this.name = name;
        this.price = price;
        this.amount = amount;
        this.isAvailable = isAvailable;
        this.category = category;
    }

    public Product(Integer id, String name, BigDecimal price, Integer amount, Boolean isAvailable, Category category) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.amount = amount;
        this.isAvailable = isAvailable;
        this.category = category;
    }

    public String toString(){
        return "id: " + id + ", name " + name + ", price: " + price + ", amount: " + amount + ", is aviable: " + isAvailable + ", category: " + category;
    }

    private Integer generateId() {
        ProductDaoSQL pds = new ProductDaoSQL();
        List<Integer> usedIds = pds.getProductsIds();
        boolean repeat = true;
        int randomId = 0;
        while (repeat) {
            randomId = getRandomNumber();
            if (!usedIds.contains(randomId)) {
                repeat = false;
            }
        }
        return randomId;
    }

    private int getRandomNumber() {

        int min = 0;
        int max = 99999;
        Random r = new Random();
        return r.nextInt((max - min) + 1) + min;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public Integer getAmount() {
        return amount;
    }

    public Boolean getAvailable() {
        return isAvailable;
    }

    public Category getCategory() {
        return category;
    }

    public void setAmount(Integer number) {
        amount = number;
    }
}
