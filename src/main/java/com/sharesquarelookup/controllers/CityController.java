package com.sharesquarelookup.controllers;


import com.sharesquarelookup.model.City;
import com.sharesquarelookup.services.contracts.CityService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/cities")
@Controller
public class CityController {
    private CityService cityService;

    public CityController(CityService cityService) {
        this.cityService = cityService;
    }

    @PostMapping("/add")
    public ResponseEntity<String>  addCountry(@RequestBody City c){

        cityService.save(c);
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.set("MyResponseHeader", c.getName());
        return new ResponseEntity<>("City created", responseHeaders, HttpStatus.CREATED);
    }

    @GetMapping("/getByName")
    public ResponseEntity<City> getByName(@RequestParam String name){
        City find =  cityService.getCityByName(name);

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
