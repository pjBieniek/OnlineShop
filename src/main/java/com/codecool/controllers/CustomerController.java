package com.codecool.controllers;

import com.codecool.dao.ProductDaoSQL;
import com.codecool.models.Basket;
import com.codecool.View.Viewer;
import com.codecool.models.Product;

import java.util.*;

public class CustomerController {

    private Viewer view;
    private Basket basket;
    private ProductDaoSQL pds;
    private Product product;

    public CustomerController(Basket basket, Viewer view){
        this.product = new Product();
        this.view = view;
        this.pds = new ProductDaoSQL(product, this.view);
        this.basket = basket;

    }

    public void addToBasket() {
        view.clearScreen();
        displayProducts();
        view.display("Enter id of a product You wish to add to Your basket");
        int id = view.getIntegerInput();
        Product product = pds.getProductById(id);
        view.display("How many items would you like to get?");
        Integer amount = view.getIntegerInput();
        basket.addProduct(product, amount);
    }

    public void editProductQuantity() {
        basket.showBasket();
        view.display("Enter product id: ");
        int i = view.getIntegerInput();
        view.display("How many copies would You like? ");
        int number = view.getIntegerInput();

        for (Map.Entry<Product, Integer> entry : basket.getProducts().entrySet()) {
            if (entry.getKey().getId() ==  i ) {
                entry.setValue(number);
            }
        }
    }

    public void deleteFromBasket() {
        view.display(basket.getProducts());
        view.display("Enter id of a product You want delete: ");
        int id = view.getIntegerInput();
        basket.deleteProduct(basket.returnProductById(id));
    }

    public void showBasket() {
        if (basket.getProducts().isEmpty()) {
            view.display("\nBasket is empty");
        } else {
            for (Map.Entry<Product, Integer> entry : basket.getProducts().entrySet()) {
                view.display("Amount: " + entry.getValue() + " | Title: " + entry.getKey().getName());
            }
        }
    }

    public void seePreviousOrders() {

    }

    public void showAvialableProducts() {

    }

    public void showCategory() {

    }

    public void checkAvialability() {
        Set<String> set = new HashSet<>();

    }

    public void rateProduct() {

    }

    public void showStatistics() {

    }

    public void displayProducts() {
//        List<List<String>> database;
//        database = view.productsToString(pds.getAllProducts());
//        view.displayTable(database);
//        database.remove(database);
        pds.productsToPrint();
    }

}
