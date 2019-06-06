package com.codecool.models;

import com.codecool.View.*;
import com.codecool.iterator.ProductIterator;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class Basket {

    private Viewer view;
    private Integer id;
    private Iterator iterator;
    private Map<Product, Integer> products;

    public Basket(Viewer view){
        this.view = view;
        this.iterator = new ProductIterator();
        this.products = new HashMap<>();
    }

    public Iterator getIterator() {
        return iterator;
    }

    public void addProduct(Product product, Integer amount){
        products.put(product, amount);
    }

    public void deleteProduct(Product product){
        products.remove(product);
    }

    public void showBasket() {
        int i = 1;
        for (Map.Entry<Product, Integer> entry : products.entrySet()){
            view.display("\n[" + i + "] \n" + entry.getKey().getSimpleName() + " in magazine now");
            view.display("Amount in basket: " + entry.getValue().toString() + "\n");
            i++;
        }
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
