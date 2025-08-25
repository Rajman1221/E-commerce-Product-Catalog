package com.ecom.catalog.service;

import com.ecom.catalog.model.Product;
import com.ecom.catalog.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repo;

    public List<Product> getAllProducts() {
        return repo.findAll();
    }

    public Product addProduct(Product product) {
        return repo.save(product);
    }

    public List<Product> searchProducts(String keyword) {
        return repo.findByNameContainingIgnoreCase(keyword);
    }
}