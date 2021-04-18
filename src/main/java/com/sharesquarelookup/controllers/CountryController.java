package com.sharesquarelookup.controllers;

import com.sharesquarelookup.model.Country;
import com.sharesquarelookup.services.contracts.CountryService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/countries")
@Controller
public class CountryController {
    private final CountryService countryService;

    public CountryController(CountryService countryService) {
        this.countryService = countryService;
    }

    @PostMapping("/add")
    public ResponseEntity<String>  addCountry(@RequestBody Country c){
        //Country c = Country.Create(name, iso3);
        countryService.save(c);
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.set("MyResponseHeader", c.getName());
        return new ResponseEntity<String>("Country created", responseHeaders, HttpStatus.CREATED);
    }

    @GetMapping("/getAll")
    public ResponseEntity<Country> getByName(@RequestParam String name){
        Country find =  countryService.findAll().stream().filter(c->name.equals(c.getName())).findAny().orElse(null);

        if(find != null) {
            HttpHeaders responseHeaders = new HttpHeaders();
            responseHeaders.set("MyResponseHeader", find.getName());
            return new ResponseEntity<>(find, responseHeaders, HttpStatus.FOUND);
        }

        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.set("MyResponseHeader", "N/A");
        return new ResponseEntity<>(find, responseHeaders, HttpStatus.NOT_FOUND);
    }
}
