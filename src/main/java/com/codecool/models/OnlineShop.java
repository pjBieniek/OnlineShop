package com.codecool.models;
import java.sql.*;

public class OnlineShop {
    public static void main(String[] args) throws Exception {
        ShopRunner runner = new ShopRunner();
        runner.run();

        Connection c = null;

        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:test.db");
            System.out.println("Sqlite DB connected");
        } catch (Exception e){
            System.out.println("\n...\n");
            System.out.println(e);
        }


    }
}
