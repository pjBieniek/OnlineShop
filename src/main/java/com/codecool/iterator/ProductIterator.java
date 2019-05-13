package com.codecool.iterator;

import com.codecool.models.Product;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

public class ProductIterator implements Iterator {
    private List<Product> productList = new ArrayList<Product>();
    private int index = 0;

    @Override
    public boolean hasNext() {
        return (index < productList.size());
    }

    @Override
    public Product next() {
        if (this.hasNext()){
            return productList.get(index++);
        } else{
            throw new NoSuchElementException();
        }
    }
}
