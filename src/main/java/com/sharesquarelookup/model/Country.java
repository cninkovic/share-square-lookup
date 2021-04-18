package com.sharesquarelookup.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Table;

@Setter
@Getter
@NoArgsConstructor
@Entity
@Table(name = "countries")
public class Country extends BaseEntity {
    private String name;
    private String iso3;

    public static Country Create(String name, String iso3) {
        Country c = new Country();
        c.name = name;
        c.iso3 = iso3;
        return c;
    }
}
