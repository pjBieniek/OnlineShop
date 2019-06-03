package com.codecool.dao;

import com.codecool.View.Viewer;
import com.codecool.models.Category;
import com.codecool.models.Product;

import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDaoSQL implements ProductDao{
    private Viewer view = new Viewer();
    private ResultSet results;
    private Connection c = null;
    private Statement stmt = null;
    private Integer id;
    private String name;
    private BigDecimal price;
    private Integer amount;
    private Boolean isAvailable;
    private String categoryName;
    private Product newProduct;
    private List<Product> productsList = new ArrayList<>();


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

    public List<Product> getAllProducts(){
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
                BigDecimal price = results.getBigDecimal("PRICE");
                Integer amount = results.getInt("AMOUNT");
                Boolean isAvailable = results.getBoolean("isAVAILABLE");
                String category = results.getString("CATEGORY");
                newProduct = new Product(id, name, price, amount, isAvailable, new Category(category));
                productsList.add(newProduct);
//                view.display("id: " + id + "| name: " + name + "| price: " + price + "| amount: " + amount + "| Available?: " + isAvailable + "| category: " + category);
            }
            results.close();
            stmt.close();
            c.close();
        } catch (Exception e){
            System.out.println("\n...\n");
            System.out.println(e);
        }
        return productsList;
    }


    public void updateProduct(String currentName){

        getDataFromUser();

        String sql = "UPDATE Product SET NAME = ? , " +
                "PRICE = ? ,  " + "AMOUNT = ? WHERE NAME = ? ";

        try {
            Connection conn = this.connect();
            PreparedStatement pstmt = conn.prepareStatement(sql);

            pstmt.setString(1, name);
            pstmt.setBigDecimal(2, price);
            pstmt.setInt(3, amount);
            pstmt.setString(4, currentName);
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

    public void addProduct(Product product){
        this.id = product.getId();
        this.name = product.getName();
        this.price = product.getPrice();
        this.amount = product.getAmount();
        this.isAvailable = product.getAvailable();
        this.categoryName = product.getCategory().getName();
        String sql = "INSERT INTO Product VALUES (" + id + ", '" + name + "', " + price + ", " + amount + ", " + isAvailable + ", '" + categoryName + "')";


        try {
            Connection conn = this.connect();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.executeUpdate();

        } catch (Exception e){
            view.display(e.getMessage());
        }
    }

    private void getDataFromUser(){
        view.display("Enter new name: ");
        name = view.getStringInput();
        view.display("Enter new price: ");
        price = view.getBigDecimalInput();
        view.display("Enter new amount: ");
        amount = view.getIntegerInput();
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

    public Product getProductById(Integer number) {
        for (Product product : productsList) {
            if (product.getId() == number) {
                return product;
            }
        }
        return null;
    }

}