package com.sharesquarelookup.services.impl;

import com.sharesquarelookup.model.City;
import com.sharesquarelookup.repositories.CityRepository;
import com.sharesquarelookup.services.contracts.CityService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@Profile("springdatajpa")
public class CitySDJpaService implements CityService {

    private CityRepository cityRepository;

    public CitySDJpaService(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }


    @Override
    public City getCityByName(String name) {
        return cityRepository.getCityByName(name);
    }

    @Override
    public List<City> getCitiesByCountryId(int id) {
        return cityRepository.getCitiesByCountryId(id);
    }

    @Override
    public Set<City> findAll() {
        Set<City> result = new HashSet<>();
        cityRepository.findAll().forEach(result::add);
        return result;
    }

    @Override
    public City findById(Long aLong) {
        return cityRepository.findById(aLong).orElse(null);
    }

    @Override
    public City save(City object) {
        return cityRepository.save(object);
    }

    @Override
    public void delete(City object) {
        cityRepository.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        cityRepository.deleteById(aLong);
    }
}
