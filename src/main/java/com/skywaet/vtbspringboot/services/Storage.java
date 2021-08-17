package com.skywaet.vtbspringboot.services;

import com.skywaet.vtbspringboot.products.Product;

import java.util.List;

public interface Storage {
    List<Product> get();

    boolean add(Product product);

    void remove(Product product);
}
