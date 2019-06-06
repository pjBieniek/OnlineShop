package com.codecool;

import com.codecool.View.Viewer;
import com.codecool.controllers.ShopRunner;


public class OnlineShop {
    public static void main(String[] args) {
        Viewer viewer = new Viewer();
        ShopRunner runner = new ShopRunner(viewer);
        runner.run();

    }
}
