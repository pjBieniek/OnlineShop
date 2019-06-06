package com.codecool.models;

import com.codecool.View.Viewer;
import com.codecool.controllers.CustomerController;

public class Customer {


//    private String userName;
    private Basket basket;
//    private CustomerController cc; // <--
    private Viewer view;
    private boolean repeat = true;

    public Customer(Basket basket) {
        this.basket = basket;
        this.view = new Viewer();
//        this.cc = new CustomerController(basket, view); // <--
    }

    public void printCustomerMenu() {
        view.clearScreen();
        view.display("Hello customer!");
        Basket basket = new Basket(view);
//        CustomerController cc = new CustomerController();

        while(repeat) {
            view.displayCustomerMenu();
            CustomerController cc = new CustomerController(basket, view);
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