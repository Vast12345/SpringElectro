package com.inventarioelectro.app_electro.domain.service;

import java.util.List;

import org.springframework.stereotype.Component;

import com.inventarioelectro.app_electro.domain.entity.Product;

@Component
public interface ProductService {
    List<Product> findAll();
    Product findById(Long id);
}
