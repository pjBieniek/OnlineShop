package com.codecool.controllers;

import com.codecool.View.Viewer;
import com.codecool.models.Basket;


import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

public class ShopRunner {
    private Viewer view;
    private Basket basket;
    private boolean repeat = true;
    private String password;

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
                Admin admin = new Admin();
                if (adminLogin()){
                    admin.handleAdminMenu();
                }
                break;
            case 2:
                Basket basket = new Basket(view);
                Customer customer = new Customer(basket);
                customer.printCustomerMenu();
                break;
            case 3:
                repeat = false;
                break;
        }
    }

    private Boolean adminLogin(){
        try {
            this.password = Files.readString(Paths.get("/home/pawel/Dokumenty/codecool/Java/TW - 5 week/OnlineShop/src/resources/pass.txt"));
        } catch (IOException e){
            System.out.println(e.getMessage());
        }


        Scanner getPass = new Scanner(System.in);
        String pass = getPass.nextLine();

        if (pass.equals(password)){
            return true;
        } else {
            System.out.println("oops, wrong password");
            return false;
        }
    }
}
