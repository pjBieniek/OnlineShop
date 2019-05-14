package com.codecool.models;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class Basket {

    private Integer id;
    private Iterator iterator;
    private Map<Product, Integer> products; //HashMap

    public Iterator getIterator() {
        return iterator;
    }

    public void addProduct(Product product, Integer amount){
        //
    }

    public void deleteProduct(Product product){

    }
}
