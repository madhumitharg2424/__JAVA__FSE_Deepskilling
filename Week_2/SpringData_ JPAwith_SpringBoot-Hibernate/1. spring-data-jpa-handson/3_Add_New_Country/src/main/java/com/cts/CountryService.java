package com.cts;

import java.util.ArrayList;
import java.util.List;

public class CountryService {

    private List<Country> countries = new ArrayList<>();

    public void addCountry(Country country) {
        countries.add(country);
    }

    public List<Country> getAllCountries() {
        return countries;
    }
}