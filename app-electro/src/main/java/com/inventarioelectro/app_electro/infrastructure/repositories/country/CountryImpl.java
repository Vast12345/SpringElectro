package com.inventarioelectro.app_electro.infrastructure.repositories.country;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.inventarioelectro.app_electro.application.services.ICountryService;
import com.inventarioelectro.app_electro.domain.entity.Country;

@Service
public class CountryImpl implements ICountryService{

    @Autowired
    private ICountryRepository iCountryRepository;

    @Transactional(readOnly = true)
    @Override
    public List<Country> findAll() {
        return (List<Country>) iCountryRepository.findAll();
    }

    @Transactional
    @Override
    public Optional<Country> findById(Long id) {
        return iCountryRepository.findById(id);
    }

    @Transactional
    @Override
    public Country save(Country country) {
        return iCountryRepository.save(country);
    }

    @Transactional
    @Override
    public Optional<Country> update(Long id, Country country) {
        Optional<Country> countryOld = iCountryRepository.findById(id);
        if(countryOld.isPresent()) {
            Country countryDb = countryOld.orElseThrow();

            countryDb.setName(country.getName());
            return Optional.of(iCountryRepository.save(countryDb));
        }
        return Optional.empty();
    }

    @Transactional
    @Override
    public Optional<Country> delete(Long id) {
        Optional<Country> country = iCountryRepository.findById(id);
        country.ifPresent(countryDb -> {
            iCountryRepository.delete(countryDb);
        });
        return country;
    }

}
