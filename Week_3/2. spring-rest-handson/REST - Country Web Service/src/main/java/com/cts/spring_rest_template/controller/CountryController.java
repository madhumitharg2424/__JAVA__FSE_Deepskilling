package com.cts.spring_rest_template.controller;

import com.cts.spring_rest_template.model.Country;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CountryController {

    @GetMapping("/country")
    public Country getCountry() {

        return new Country("IN", "India");
    }
}