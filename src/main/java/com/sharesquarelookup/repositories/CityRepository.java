package com.sharesquarelookup.repositories;

import com.sharesquarelookup.model.City;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CityRepository extends CrudRepository<City, Long> {
    City getCityByName(String name);
    List<City> getCitiesByCountryId(int id);
}
