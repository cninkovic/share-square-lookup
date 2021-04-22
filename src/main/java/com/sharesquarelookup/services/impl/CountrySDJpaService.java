package com.sharesquarelookup.services.impl;

import com.sharesquarelookup.model.Country;
import com.sharesquarelookup.repositories.CountryRepository;
import com.sharesquarelookup.services.contracts.CountryService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@Profile("springdatajpa")
public class CountrySDJpaService implements CountryService {

    private final CountryRepository countryRepository;

    public CountrySDJpaService(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    @Override
    public Set<Country> findAll() {
        Set<Country> result = new HashSet<>();
        countryRepository.findAll().forEach(result::add);
        return result;
    }

    @Override
    public Country findById(Long aLong) {
        return countryRepository.findById(aLong).orElse(null);
    }

    @Override
    public Country save(Country object) {
        return countryRepository.save(object);
    }

    @Override
    public void delete(Country object) {
        countryRepository.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        countryRepository.deleteById(aLong);
    }

    @Override
    public Country getCountryByName(String name) {
        return countryRepository.getCountryByName(name);
    }
}
