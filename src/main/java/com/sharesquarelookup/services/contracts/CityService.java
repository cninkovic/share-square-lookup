package com.sharesquarelookup.services.contracts;

import com.sharesquarelookup.model.City;

import java.util.List;

public interface CityService extends CrudService<City, Long>  {
    City getCityByName(String name);
    List<City> getCitiesByCountryId(int id);
}
