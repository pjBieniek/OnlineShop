package com.codecool.models;

import com.codecool.View.Viewer;
import java.math.BigDecimal;


public interface Validator {

    Viewer view = new Viewer();

    default BigDecimal validateProductPrice(String price) {

        try {
            String s = String.format("%.2f", new BigDecimal(price));
            return new BigDecimal(s);
        } catch (Exception e) {
            view.display("Price must consist of numbers only and be grater than zero");
        }
        return null;
    }

    default Integer validateProductAmount(String amount) {

        try {
            int i = Integer.parseInt(amount);
            return i;
        } catch (Exception e) {
            view.display("Amount must consist of digits only");
        }
        return null;
    }

    default Boolean validateProductAvialability(String str) {
        if (str.toLowerCase().equals("y")) {
            return true;
        } else if (str.toLowerCase().equals("n")) {
            return false;
        } else {
            return null;
        }
    }

    default boolean validateProductCategory(String category) {
        return true;
    }

}
