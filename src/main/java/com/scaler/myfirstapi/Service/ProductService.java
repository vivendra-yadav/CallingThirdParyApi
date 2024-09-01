package com.scaler.myfirstapi.Service;

import com.scaler.myfirstapi.Modle.Product;

import java.util.List;

public interface ProductService {
    Product getProductById(Long id);

    List<Product> getAllProducts();
}
