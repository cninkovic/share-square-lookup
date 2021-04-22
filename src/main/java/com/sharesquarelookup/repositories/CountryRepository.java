package com.sharesquarelookup.repositories;

import com.sharesquarelookup.model.Country;
import org.springframework.data.repository.CrudRepository;


public interface CountryRepository extends CrudRepository<Country, Long> {
    Country getCountryByName(String name);
}
