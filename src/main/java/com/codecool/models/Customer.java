package com.codecool.models;

import com.codecool.View.Viewer;
import com.codecool.controllers.CustomerController;

public class Customer {


    private String userName;
    private Basket basket;
    private Viewer view = new Viewer();

    public Customer(Basket basket) {
        this.basket = basket;
    }

    public void printCustomerMenu() {
        view.clearScreen();
        boolean repeat = true;
        Basket basket = new Basket();
        CustomerController cc = new CustomerController();

        while(repeat) {
            view.displayCustomerMenu();
            int option = view.getIntegerInput();

            switch (option) {
                case 1:
                    cc.addToBasket();
                    break;
                case 2:
                    cc.showBasket();
                    cc.editProductQuantity();
                    break;
                case 3:
                    cc.deleteFromBasket();
                    break;
                case 4:
                    cc.showBasket();
                    break;
                case 5:
                    cc.displayProducts();
                    break;
                case 6:
                    repeat = false;

            }
        }
    }
}