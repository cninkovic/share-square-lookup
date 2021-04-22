package com.sharesquarelookup.model;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;

@Setter
@Getter
@NoArgsConstructor
@Entity
@Table(name = "categories")
public class Category extends BaseEntity {
    private String name;
    private String short_name;
    private boolean isProduct;

    public static Category Create(String name, String short_name, boolean isProduct) {
        Category c = new Category();
        c.name = name;
        c.short_name = short_name;
        c.isProduct = isProduct;
        return  c;
    }
}
