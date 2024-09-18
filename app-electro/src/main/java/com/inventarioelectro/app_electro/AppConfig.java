package com.inventarioelectro.app_electro;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;

import com.inventarioelectro.app_electro.infrastructure.repository.IProductRepository;
import com.inventarioelectro.app_electro.infrastructure.repository.ProductRepositoryJson;

@Configuration
@PropertySource("classpath:config.properties")
public class AppConfig {

    @Bean("productJson")
    @Primary
    IProductRepository productRepositoryJson() {
        return new ProductRepositoryJson();
    }
}
