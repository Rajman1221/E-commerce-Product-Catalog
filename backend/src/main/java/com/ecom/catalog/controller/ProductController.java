package com.ecom.catalog.controller;

import com.ecom.catalog.model.Product;
import com.ecom.catalog.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
@CrossOrigin(origins = "http://localhost:3000")
public class ProductController {

    @Autowired
    private ProductService service;

    @GetMapping
    public List<Product> getAll() {
        return service.getAllProducts();
    }

    @PostMapping
    public Product add(@RequestBody Product product) {
        return service.addProduct(product);
    }

    @GetMapping("/search")
    public List<Product> search(@RequestParam String keyword) {
        return service.searchProducts(keyword);
    }
}