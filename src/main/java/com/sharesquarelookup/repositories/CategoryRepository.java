package com.sharesquarelookup.repositories;


import com.sharesquarelookup.model.Category;
import org.springframework.data.repository.CrudRepository;

public interface CategoryRepository extends CrudRepository<Category, Long> {
    Category getByName(String name);
}
