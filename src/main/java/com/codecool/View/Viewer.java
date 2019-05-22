package com.codecool.View;

import com.codecool.models.Category;
import com.codecool.models.Product;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Viewer {
    Scanner scanner = new Scanner(System.in);

    public void display(String content){
        System.out.println(content);
    }

    public void display(List<Product> content){
        for (Object element : content){
            System.out.println(element);
        }
    }

    public void display(Map<Product, Integer> content){
        for (Map.Entry<Product, Integer> entry : content.entrySet()) {
            System.out.println("Amount of: " + entry.getKey() + "is " + entry.getValue());
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

    public Float getFloatInput(){
        Float userInput = Float.parseFloat(scanner.nextLine());
        return userInput;
    }

}
