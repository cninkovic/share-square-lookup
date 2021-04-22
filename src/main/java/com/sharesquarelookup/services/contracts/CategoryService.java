package com.sharesquarelookup.services.contracts;

import com.sharesquarelookup.model.Category;
import com.sharesquarelookup.model.City;

public interface CategoryService extends CrudService<Category, Long>{
    Category getByName(String name);
}
