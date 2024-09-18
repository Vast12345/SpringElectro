package com.inventarioelectro.app_electro.infrastructure.repository;

import java.util.List;

import com.inventarioelectro.app_electro.domain.entity.Product;
import com.inventarioelectro.app_electro.domain.service.ProductService;

public interface IProductRepository extends ProductService{
    List<Product> findAll();
    Product findById(Long id);
}
