package services;

import products.Product;

import java.util.List;

public interface Storage {
    List<Product> get();

    boolean add(Product product);

    void remove(Product product);
}
