package com.codecool.models;

import com.codecool.View.Viewer;

public class Customer {


    private String userName;
    private Basket basket;
    private Viewer view = new Viewer();

    public Customer(Basket basket) {
        this.basket = basket;
    }

    public void printUserMenu() {
        boolean repeat = true;
        Basket basket = new Basket();

        while(repeat) {
            view.clearScreen();
            view.display("Select from options below using numbers:\n[ 1 ] Add product to to basket\n[ 2 ] Edit product quantity"
                    + "\n[ 3 ] Delete product from basket\n[ 4 ] Show contents of basket\n[ 5 ] Place Your order\n[ 6 ] View previous orders"
                    + "\n[ 7 ] Show available products\n[ 8 ]\nShow category\n[ 10 ]  Check Availability\n[ 11 ] Rate product\n[ 12 ]"
                    + "\n[ 13 ] Show Statistics\n\nYour choice: ");
            int option = view.getIntegerInput();

            switch (option) {
                case 1:


            }
        }
    }
}