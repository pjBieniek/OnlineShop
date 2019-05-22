package com.codecool.models;

import com.codecool.View.Viewer;
import com.codecool.controllers.AdminController;

public class Admin {
    private Viewer view = new Viewer();
    private AdminController shop;

    public Admin(AdminController shop) {
        this.shop = shop;
    }

    private void printMenu(){
        view.display("Printing menu: ");

    }
}
