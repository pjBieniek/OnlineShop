package com.codecool.models;
import com.codecool.dao.ProductDaoSQL;


public class OnlineShop {
    public static void main(String[] args) throws Exception {
        ShopRunner runner = new ShopRunner();
        runner.run();
        ProductDaoSQL shop = new ProductDaoSQL();
//        shop.getAllProducts
        shop.getAllProducts();
        shop.updateProduct();
        shop.getAllProducts();

    }
}
