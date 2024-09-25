package com.inventarioelectro.app_electro.infrastructure.repositories.country;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.inventarioelectro.app_electro.domain.entity.Country;

@Repository
public interface ICountryRepository extends CrudRepository<Country, Long>{ // If it is an embeddable key input the Llave Compuesto i.e. ProductInvoicePk
    
}
