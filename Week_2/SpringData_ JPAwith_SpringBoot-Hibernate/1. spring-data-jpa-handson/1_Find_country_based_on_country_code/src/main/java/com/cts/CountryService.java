package com.cts;

import java.util.ArrayList;
import java.util.List;

public class CountryService {

    private List<Country> countries = new ArrayList<>();

    public CountryService() {

        countries.add(new Country("IN", "India"));
        countries.add(new Country("US", "United States"));
        countries.add(new Country("UK", "United Kingdom"));
    }

    public Country findCountry(String code) {

        for (Country country : countries) {

            if (country.getCode().equalsIgnoreCase(code)) {
                return country;
            }
        }

        return null;
    }
}