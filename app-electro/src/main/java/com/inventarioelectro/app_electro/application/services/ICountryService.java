package com.inventarioelectro.app_electro.application.services;

import java.util.List;
import java.util.Optional;

import com.inventarioelectro.app_electro.domain.entity.Country;

public interface ICountryService {
    List<Country> findAll();

    Optional<Country> findById(Long id);

    Country save(Country country);

    Optional<Country> update(Long id, Country country);
    
    Optional<Country> delete(Long id);
}
