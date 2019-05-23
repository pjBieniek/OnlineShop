package com.codecool.dao;

import java.util.List;

public interface ProductDao<T> {
    List<T> getAllProducts();
}
