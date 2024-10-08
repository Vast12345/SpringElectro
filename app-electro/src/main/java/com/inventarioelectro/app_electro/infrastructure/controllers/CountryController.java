package com.inventarioelectro.app_electro.infrastructure.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.inventarioelectro.app_electro.application.services.ICountryService;
import com.inventarioelectro.app_electro.domain.entity.Country;

@RestController
@RequestMapping("/api/country")
public class CountryController {

    @Autowired
    private ICountryService iCountryService;

    @GetMapping
    public List<Country> list() {
        return iCountryService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> view(@PathVariable Long id) {
        Optional<Country> countryOptional = iCountryService.findById(id);
        if(countryOptional.isPresent()) {
            return ResponseEntity.ok(countryOptional.orElseThrow());
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody Country country) {
        return ResponseEntity.status(HttpStatus.CREATED).body(iCountryService.save(country));
    }

    @PutMapping
    public ResponseEntity<?> update(@RequestBody Country country, @PathVariable Long id) {
        Optional<Country> countryOptional = iCountryService.update(id, country);
        if(countryOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.CREATED).body(countryOptional.orElseThrow());
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminate(@PathVariable Long id) {
        Optional<Country> countryOptional = iCountryService.delete(id);
        if(countryOptional.isPresent()) {
            return ResponseEntity.ok(countryOptional.orElseThrow());
        }
        return ResponseEntity.notFound().build();
    }
}
