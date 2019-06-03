package com.codecool.View;

import com.codecool.models.Category;
import com.codecool.models.Product;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Viewer {
    Scanner scanner = new Scanner(System.in);

    public void display(String content){
        System.out.println(content);
    }

    public void display(List<Product> content){
        for (Product element : content){
            System.out.println(element);
        }
    }

    public void display(Map<Product, Integer> content){
        for (Map.Entry<Product, Integer> entry : content.entrySet()) {
            System.out.println(entry.getValue() + " copies of: " + entry.getKey().getSimpleName());
        }
    }

    public void displayEntryScreen(){
        clearScreen();
        System.out.println("__________ ONLINE SHOP vol 0.1 __________\n");
        System.out.println();
    }

    public void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public String getStringInput(){
        boolean repeat = true;
        String userInput;
        while (repeat) {
            userInput = scanner.nextLine();
            return userInput;
//            if (validator(userInput) == true){
//                repeat = false;
//            }
//        }
//        return userInput;
        }
        return "";
    }

    public Integer getIntegerInput(){
        Integer userInput = Integer.parseInt(scanner.nextLine());
        return userInput;
    }

    public void displayAdminMenu(){
        display("(1) Create new product category");
        display("(2) Create new featured product category");
        display("(3) Deactivate product automatically");
        display("(4) Create new product");
        display("(5) Edit product");
        display("(6) Deactivate product");
        display("(7) Give limited discount on product");
        display("(8) See list of ongoing orders");
        display("(9) Collect feedback from customers");
        display("(10) Exit");
        display("\n Your choice: ");
    }

    public void displayCustomerMenu(){
        display("(1) Add to basket");
        display("(2) Edit product's quantity in basket");
        display("(3) Delete from basket");
        display("(4) See basket");
        display("(5) Display Products");
        display("(6) Exit");
        display("\n Your choice: ");

    }

    public void displayCredits(){
        display("Online shop made by : ");
        display("Michał, Kacper, Paweł");
    }
    public BigDecimal getFloatInput(){
        BigDecimal value = new BigDecimal(scanner.nextLine());
        return value;
    }

    public void displayTable(List<List<String>> table){
        List<String> headers = new ArrayList<>();
        headers.add("ID");
        headers.add("NAME");
        headers.add("PRICE");
        headers.add("AMOUNT");
        headers.add("isAVAILABLE");
        headers.add("CATEGORY");
        PrintTable newTable = new PrintTable(headers,  table , false);
        String tableToPrint = newTable.printTable();
        display(tableToPrint);
    }

    public List<List<String>> productsToString(List<Product> products){
        List<List<String>> list = new ArrayList<>();
        for (Product product : products) {
            List<String> temp = new ArrayList<>();
            temp.add(product.getId().toString());
            temp.add(product.getName());
            temp.add(product.getPrice().toString());
            temp.add(product.getAmount().toString());
            temp.add(product.getAvailable().toString());
            temp.add(product.getCategory().getName());

            list.add(temp);
        }
        return list;
    }

}
