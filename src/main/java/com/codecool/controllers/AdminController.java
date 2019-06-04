package com.codecool.controllers;

import com.codecool.View.Viewer;
import com.codecool.dao.ProductDao;
import com.codecool.dao.ProductDaoSQL;
import com.codecool.models.Category;
import com.codecool.models.Customer;
import com.codecool.models.FeaturedCategory;
import com.codecool.models.Product;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class AdminController {
    private ProductDaoSQL sql;
    private Viewer view;
    private List<List<String>> productsToPrint;
    private Product product;

    public AdminController(Viewer view){
        this.view = view;
        this.product = new Product();
        this.sql = new ProductDaoSQL(product, view);
    }

    public Category createCategory(){
        return null;
    }

    public FeaturedCategory createFeaturedCategory(){
        return null;
    }

    public void editProductName(Category category, String currentName){

    }

    public void deleteProduct(){
        sql.deleteProduct();
        updateData();
        view.display("\n\ndeleted succesfully.");
    }

    public void addNewProduct(){
        view.display("Enter new product's name: ");
        String name = view.getStringInput();
        view.display("Enter new product's price: ");
        BigDecimal price = view.getBigDecimalInput();
        view.display("Enter new product's amount: ");
        Integer amount = view.getIntegerInput();
        view.display("Product is unavailable now. Set product available? If so, Type 'y': ");
        Boolean isAvailable = view.getBooleanInput();
        view.display("And categry name?: ");
        String category = view.getStringInput();
        Category newCategory = new Category(category);
        Product newProduct = new Product(name, price, amount, isAvailable, newCategory);
        sql.addProduct(newProduct);
        updateData();
        view.display("\n\n" + name + " added succesfully");
    }

    public void editProduct(String name){
        sql.updateProduct(name);
        updateData();
        view.display("\n\n" + name + " edited succesfully");
    }

    public void deactivateProduct(Integer id){
        sql.deactivateProduct(id);
        updateData();
        view.display("\n\n" + id + " deactivated succesfully");
    }

    public void autoDeactivateProduct(){
        view.display("Enter product id: ");
        Integer id = view.getIntegerInput();
        product.setAuto(true);
        updateData();
        view.display("\n\n" + product.getName() + " deactivated succesfully");
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
        updateData();
        view.displayTable(productsToPrint);
    }

    private void updateData(){
        productsToPrint = view.productsToString(sql.getAllProducts());
    }
}
