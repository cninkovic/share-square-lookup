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
@Table(name = "cities")
public class City extends BaseEntity {
    private String name;
    private String short_name;
    private int country;

    public static City Create(String name, String short_name, int country) {
        City c = new City();

        c.name = name;
        c.short_name = short_name;
        c.country = country;
        return c;
    }
}
