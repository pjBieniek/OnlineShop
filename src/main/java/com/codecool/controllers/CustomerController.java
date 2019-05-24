package com.codecool.controllers;

import com.codecool.dao.ProductDaoSQL;
import com.codecool.models.*;
import com.codecool.View.*;

import java.util.*;

public class CustomerController {

    private Viewer view = new Viewer();
    private Basket basket = new Basket();
    private ProductDaoSQL pds = new ProductDaoSQL();

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
        view.display(basket.getProducts());
        view.display("Enter product id: ");
        int id = view.getIntegerInput();
        view.display("How many copies would You like? ");
        int number = view.getIntegerInput();

        for (Map.Entry<Product, Integer> entry : basket.getProducts().entrySet()) {
            if (entry.getKey().getId() == id) {
                entry.setValue(number);
            }
        }
    }

    public void deleteFromBasket() {
        view.display(basket.getProducts());
        view.display("Enter id of a product You want to delete: ");
        int id = view.getIntegerInput();
        basket.deleteProduct(basket.returnProductById(id));
    }

    public void showBasket() {

        for (Map.Entry<Product, Integer> entry : basket.getProducts().entrySet()) {
            view.display("\n" + entry.getValue() + " pieces of: " + entry.getKey().getName() + "\n");
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
        List<List<String>> database;
        database = view.productsToString(pds.getAllProducts());
        view.displayTable(database);
        database.remove(database);
    }

}
