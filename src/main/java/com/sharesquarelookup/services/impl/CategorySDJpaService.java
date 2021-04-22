package com.sharesquarelookup.services.impl;

import com.sharesquarelookup.model.Category;
import com.sharesquarelookup.model.City;
import com.sharesquarelookup.repositories.CategoryRepository;
import com.sharesquarelookup.services.contracts.CategoryService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@Profile("springdatajpa")
public class CategorySDJpaService implements CategoryService {

    private final CategoryRepository categoryRepository;

    public CategorySDJpaService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }


    @Override
    public Category getByName(String name) {
        return categoryRepository.getByName(name);
    }

    @Override
    public Set<Category> findAll() {
        Set<Category> result = new HashSet<>();
        categoryRepository.findAll().forEach(result::add);
        return result;
    }

    @Override
    public Category findById(Long aLong) {
        return categoryRepository.findById(aLong).orElse(null);
    }

    @Override
    public Category save(Category object) {
        return categoryRepository.save(object);
    }

    @Override
    public void delete(Category object) {
        categoryRepository.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        categoryRepository.deleteById(aLong);
    }
}
