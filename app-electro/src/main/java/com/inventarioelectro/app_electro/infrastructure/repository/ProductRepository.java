package com.inventarioelectro.app_electro.infrastructure.repository;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Component;

import com.inventarioelectro.app_electro.domain.entity.Product;

@Component
public class ProductRepository implements IProductRepository{
    List<Product> products;

    public ProductRepository() {
        this.products = Arrays.asList(
            new Product(1L, "Laptop", 450000L),
            new Product(2L, "Smartphone", 200000L),
            new Product(3L, "Tablet", 120000L),
            new Product(4L, "Monitor", 80000L),
            new Product(5L, "Keyboard", 150000L),
            new Product(6L, "Mouse", 80000L),
            new Product(7L, "Printer", 700000L),
            new Product(8L, "External Hard Drive", 350000L),
            new Product(9L, "Headphones", 200000L),
            new Product(10L,"Webcam", 250000L)
        );
    }

    @Override
    public List<Product> findAll() {
        return products;
    }

    @Override
    public Product findById(Long id) {
        return products.stream().filter(p -> p.getId().equals(id)).findFirst().orElseThrow();
    }
}
