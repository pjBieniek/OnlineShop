package com.codecool.models;

import com.codecool.View.*;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class Basket {

    Viewer view = new Viewer();
    private Integer id;
    private Iterator iterator;
    private Map<Product, Integer> products = new HashMap<>(); //HashMap

    public Iterator getIterator() {
        return iterator;
    }

    public void addProduct(Product product, Integer amount){
        products.put(product, amount);
    }

    public void deleteProduct(Product product){
        products.entrySet().removeIf(entry -> entry.getValue().equals(product));
    }

    public Map<Product, Integer> showBasket() {
        return products;
    }

    public Map<Product, Integer> getProducts() {
        return products;
    }

    public Product returnProductById(int id) {
        for (Map.Entry<Product, Integer> entry : products.entrySet()) {
            if (entry.getKey().getId() == id) {
                return entry.getKey();
            }
        }
        return new Product();
    }
}
