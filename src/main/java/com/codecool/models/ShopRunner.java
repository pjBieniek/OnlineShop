package com.codecool.models;

import com.codecool.View.Viewer;
import com.codecool.controllers.*;

public class ShopRunner {
    private Viewer view;
    private Basket basket;
    private boolean repeat = true;

    public ShopRunner(Viewer view){
        this.view = view;
        this.basket = new Basket(view);
    }

    public void run() {
        view.clearScreen();
        view.displayEntryScreen();
        while (repeat) {
            runMainMenu();
        }

    }

    private void runMainMenu() {
        int choice = 0;
        view.display("[ 1 ] Log in as Administrator\n[ 2 ] Log in as Customer\n[ 3 ] Exit program\n\nYour choice: ");
        choice = view.getIntegerInput();
        switch (choice) {
            case 1:
//                AdminController ac = new AdminController();
                Admin admin = new Admin(view);
                admin.handleAdminMenu();
                break;
            case 2:
                Basket basket = new Basket(view);
                Customer customer = new Customer(basket, view);
                customer.printCustomerMenu();
                break;
            case 3:
                repeat = false;
                break;
        }
    }
}
