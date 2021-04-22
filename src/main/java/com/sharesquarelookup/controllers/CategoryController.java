package com.sharesquarelookup.controllers;

import com.sharesquarelookup.model.Category;
import com.sharesquarelookup.model.City;
import com.sharesquarelookup.services.contracts.CategoryService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/categories")
@Controller
public class CategoryController {
    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @PostMapping("/add")
    public ResponseEntity<String> addCategory(@RequestBody Category c){

        categoryService.save(c);
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.set("MyResponseHeader", c.getName());
        return new ResponseEntity<>("Category created", responseHeaders, HttpStatus.CREATED);
    }

    @GetMapping("/getByName")
    public ResponseEntity<Category> getByName(@RequestParam String name){
        Category find =  categoryService.getByName(name);

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
