package com.codecool.models;

import java.util.Iterator;
import java.util.List;

public class Basket {

    private Integer id;
    private Iterator iterator;
    private Map<Product, int> products; //HashMap

    public Iterator getIterator() {
        return iterator;
    }

    public void addProduct(Product product, Integer amount){
        //
    }

    public void deleteProduct(Product product){

    }
}
