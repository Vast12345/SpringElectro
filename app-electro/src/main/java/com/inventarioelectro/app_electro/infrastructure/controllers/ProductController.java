package com.inventarioelectro.app_electro.infrastructure.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.inventarioelectro.app_electro.domain.entity.Product;
import com.inventarioelectro.app_electro.infrastructure.repository.IProductRepository;


@RestController
@RequestMapping("/api")
public class ProductController {

    @Autowired
    private IProductRepository serviceProduct;

    @GetMapping
    public List<Product> list() {
        return serviceProduct.findAll();
    }

    @GetMapping("/{id}")
    public Product show(@PathVariable Long id) {
        return serviceProduct.findById(id);
    }
}

