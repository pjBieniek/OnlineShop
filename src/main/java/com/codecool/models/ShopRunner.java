package com.codecool.models;

import com.codecool.View.Viewer;
import com.codecool.controllers.*;

public class ShopRunner {
    Viewer view;
    private boolean repeat = true;

    public ShopRunner(Viewer view){
        this.view = view;
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
                Admin admin = new Admin();
                admin.handleAdminMenu();
                break;
            case 2:
                Basket basket = new Basket();
                Customer customer = new Customer(basket);
                customer.printCustomerMenu();
                break;
            case 3:
                repeat = false;
                break;
        }
    }
}
