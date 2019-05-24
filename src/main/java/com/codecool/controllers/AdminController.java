package com.codecool.controllers;

import com.codecool.View.Viewer;
import com.codecool.dao.ProductDao;
import com.codecool.dao.ProductDaoSQL;
import com.codecool.models.Category;
import com.codecool.models.Customer;
import com.codecool.models.FeaturedCategory;
import com.codecool.models.Product;

import java.util.ArrayList;
import java.util.List;

public class AdminController {
    ProductDaoSQL sql = new ProductDaoSQL();
    Viewer view = new Viewer();
    public Category createCategory(){

     return null;
    }

    public FeaturedCategory createFeaturedCategory(){
        return null;
    }

    public void editProductName(Category category, String currentName){

    }

    public void deactivateAuto(Product product){

    }

    public void editProduct(String name){
        sql.updateProduct(name);
    }

    public void deactivateProduct(Integer id){

    }

    public void manageDiscount(Product product){

    }

    public void listOrders(){

    }

    public void getFeedback(){

    }

    public Customer getCustomer(){
        return null;
    }

    public void data(){
        List<List<String>> database;
        database = view.productsToString(sql.getAllProducts());
        view.displayTable(database);
        database.remove(database);
    }
}
