package com.codecool.models;

import com.codecool.View.Viewer;
import com.codecool.controllers.AdminController;
import com.codecool.dao.ProductDao;

import java.util.List;

public class Admin {
    private AdminController shop = new AdminController();
    private Viewer view = new Viewer();


    public Admin() {

    }

    public void handleAdminMenu(){
        boolean repeat = true;
        while(repeat) {
            view.clearScreen();
            view.displayAdminMenu();
            int option = view.getIntegerInput();

            switch (option) {
                case 1:
                    view.display("Press ENTER to proceed to menu");
                    view.getStringInput();
                    break;
                case 2:
                    view.display("Press ENTER to proceed to menu");
                    view.getStringInput();
                    break;
                case 3:
                    shop.deleteProduct();
                    view.display("Press ENTER to proceed to menu");
                    view.getStringInput();
                    break;
                case 4:
                    shop.addNewProduct();
                    view.display("Press ENTER to proceed to menu");
                    view.getStringInput();
                    break;
                case 5:
                    view.display("Enter product name: ");
                    String name = view.getStringInput();
                    shop.editProduct(name);
                    view.display("Press ENTER to proceed to menu");
                    view.getStringInput();
                    break;
                case 6:
                    view.display("Enter product id: ");
                    Integer id = view.getIntegerInput();
                    shop.deactivateProduct(id);
                    view.display("Press ENTER to proceed to menu");
                    view.getStringInput();
                    break;
                case 7:
                    shop.autoDeactivateProduct();
                    view.display("Press ENTER to proceed to menu");
                    view.getStringInput();
                    break;
                case 8:
                    view.display("Press ENTER to proceed to menu");
                    view.getStringInput();
                    break;
                case 9:
                    shop.data();
                    view.display("Press ENTER to proceed to menu");
                    view.getStringInput();
                    break;
                case 10:
                    repeat = false;
            }
        }

    }
}
