package com.scaler.myfirstapi.Expection;


public class ProductNotFoundException extends Exception {
    public ProductNotFoundException(String message) {
        super(message);
    }
}
