package com.codecool.models;

import com.codecool.View.Viewer;
import com.codecool.controllers.AdminController;

public class Admin {
    private Viewer view = new Viewer();
    private AdminController shop;

    public Admin(AdminController shop) {
        this.shop = shop;
    }

    public void handleAdminMenu(){
        boolean repeat = true;


        while(repeat) {
            view.clearScreen();
            view.displayAdminMenu();
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
                    view.display("Enter product name: ");
                    String name = view.getStringInput();
                    shop.editProduct(name);

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
                    repeat = false;
                    break;
            }
        }

    }
}
