package com.codecool.View;

import com.codecool.models.Product;

import java.util.List;
import java.util.Map;

public class Viewer {
    public void display(String content){
        System.out.println(content);
    }

    public void display(List<String> content){
        for (Object element : content){
            System.out.println(element);
        }
    }

    public void display(Map<Product, Integer> content){
        for (Map.Entry<Product, Integer> entry : content.entrySet()) {
            System.out.println("Amount of: " + entry.getKey() + "is " + entry.getValue());
        }
    }
}
