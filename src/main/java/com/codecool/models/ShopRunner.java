package com.codecool.models;

import com.codecool.View.Viewer;

public class ShopRunner {
    Viewer view = new Viewer();
    public void run() {
        view.displayEntryScreen();
        System.out.println("DUPA");
    }
}
