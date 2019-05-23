package com.codecool.dao;

import com.codecool.View.Viewer;
import com.codecool.models.Category;
import com.codecool.models.Product;

import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class ProductDaoSQL extends ProductDao{
    private Viewer view = new Viewer();
    private ResultSet results;
    private Connection c = null;
    private Statement stmt = null;
    private Integer id;
    private String name;
    private Float price;
    private Integer amount;
    private Boolean isAvailable;
    private String category;


    public void getAllProducts(){
        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:OnlineShopDATA.db");

            stmt = c.createStatement();
            String sql;
            sql = "SELECT * FROM Product";
            results = stmt.executeQuery(sql);

            while (results.next()){
                Integer id = results.getInt("ID");
                String name = results.getString("NAME");
                Float price = results.getFloat("PRICE");
                Integer amount = results.getInt("AMOUNT");
                Boolean isAvailable = results.getBoolean("isAVAILABLE");
                String category = results.getString("CATEGORY");


                view.display("id: " + id + "| name: " + name + "| price: " + price + "| amount: " + amount + "| Available?: " + isAvailable + "| category: " + category);
            }
            results.close();
            stmt.close();
            c.close();
        } catch (Exception e){
            System.out.println("\n...\n");
            System.out.println(e);
        } finally {
            view.display("\n");
        }
    }

    public Product getProductById(Integer number) {
         Integer id = 0;
         String name = "";
         BigDecimal price = BigDecimal.valueOf(0);
         Integer amount = 0;
         Boolean isAvailable = false;
         String category = "";
        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:OnlineShopDATA.db");

            stmt = c.createStatement();
            String sql;
            sql = "SELECT * FROM Product WHERE ID=" + number;
            results = stmt.executeQuery(sql);

            while (results.next()){
                id = results.getInt("ID");
                name = results.getString("NAME");
                price = results.getBigDecimal("PRICE");
                amount = results.getInt("AMOUNT");
                isAvailable = results.getBoolean("isAVAILABLE");
                category = results.getString("CATEGORY");

            }
            results.close();
            stmt.close();
            c.close();
        } catch (Exception e){
            System.out.println("\n...\n");
            System.out.println(e);
        }
        Category cat = new Category(category);
        Product product = new Product(id, name, price, amount, isAvailable, cat);
        return product;
    }

    public List<Integer> getProductsIds(){
        List<Integer> ids = new ArrayList<>();
        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:OnlineShopDATA.db");


            stmt = c.createStatement();
            String sql;
            sql = "SELECT * FROM Product";
            results = stmt.executeQuery(sql);

            while (results.next()){
                Integer id = results.getInt("ID");
                ids.add(id);
            }
            results.close();
            stmt.close();
            c.close();
        } catch (Exception e){
            System.out.println("\n...\n");
            System.out.println(e);
        }
        return ids;
    }

    public void updateProduct(){
        getDataFromUser();

        String sql = "UPDATE Product SET NAME = ? , " +
                "PRICE = ? ,  " + "AMOUNT = ? , " + "isAVAILABLE = ? , " +
                "CATEGORY = ? WHERE ID = ? ";

        try {
            Connection conn = this.connect();
            PreparedStatement pstmt = conn.prepareStatement(sql);

            pstmt.setString(1, name);
            pstmt.setFloat(2, price);
            pstmt.setInt(3, amount);
            pstmt.setBoolean(4, isAvailable);
            pstmt.setString(5, category);
            pstmt.setInt(6, id);
            pstmt.executeUpdate();
        } catch (SQLException e){
            view.display(e.getMessage());
        }
    }

    public void deleteProduct(){
        view.display("Enter product id: ");
        int id = view.getIntegerInput();
        String sql = "DELETE FROM Product WHERE ID =" + id;

        try {
            Connection conn = this.connect();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.executeUpdate();
        } catch (Exception e){
            view.display(e.getMessage());
        }
    }

    public void addProduct(){
        view.display("Adding... ");
        getDataFromUser();


        String sql = "INSERT INTO Product VALUES (" + id + ", '" + name + "', " + price + ", " + amount + ", " + isAvailable + ", '" + category + "')";


        try {
            Connection conn = this.connect();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.executeUpdate();

        } catch (Exception e){
            view.display(e.getMessage());
        }
    }

    private void getDataFromUser(){
        view.display("Enter product id: ");
        id = view.getIntegerInput();
        view.display("Enter new name: ");
        name = view.getStringInput();
        view.display("Enter new price: ");
        price = view.getFloatInput();
        view.display("Enter new amount: ");
        amount = view.getIntegerInput();
        view.display("Enter new availability yes/no: ");
        isAvailable = (view.getStringInput().equals("yes"));
        view.display("Enter new category: ");
        category = view.getStringInput();
    }

    private Connection connect(){
        String url = "jdbc:sqlite:OnlineShopDATA.db";
        Connection conn = null;
        try {
            Class.forName("org.sqlite.JDBC");
            conn = DriverManager.getConnection(url);
        } catch (Exception e){
            view.display(e.getMessage());
        }
        return conn;
    }

}
