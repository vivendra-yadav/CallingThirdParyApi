package com.scaler.myfirstapi.Controller;

import com.scaler.myfirstapi.Modle.Product;
import com.scaler.myfirstapi.Service.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }
    @GetMapping("/{id}")
    public Product getProductById(@PathVariable("id") Long id) {
        return productService.getProductById(id);
    }
    @GetMapping
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }
    @PutMapping("/{id}")
    public Product repalceProduct(@PathVariable("id") Long id, @RequestBody Product product) {
        return productService.replaceProductById(id, product);
    }
}
