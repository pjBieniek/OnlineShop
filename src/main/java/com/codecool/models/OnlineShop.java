package com.codecool.models;

import com.codecool.View.Viewer;


public class OnlineShop {
    public static void main(String[] args) {
        Viewer viewer = new Viewer();
        ShopRunner runner = new ShopRunner(viewer);
        runner.run();

    }
}
