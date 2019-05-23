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
        boolean repeat = true;
        Basket basket = new Basket();
        CustomerController cc = new CustomerController();

        while(repeat) {
            view.clearScreen();
            view.displayCustomerMenu();
            int option = view.getIntegerInput();

            switch (option) {
                case 1:

                    break;
                case 2:

                    break;
                case 3:

                    break;
                case 4:

                    break;
                case 5:

                    break;
                case 6:

                    break;
                case 7:

                    break;
                case 8:

                    break;
                case 9:

                    break;
                case 10:

                    break;
                case 11:

                    break;
                case 12:
                    repeat = false;
                    break;


            }
        }
    }
}