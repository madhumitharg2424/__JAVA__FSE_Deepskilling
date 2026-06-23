package com.cts;

public class MainApp {

    public static void main(String[] args) {

        CountryService service = new CountryService();

        Country country = service.findCountry("IN");

        if (country != null) {

            System.out.println("Country Found");

            System.out.println(country.getCode());

            System.out.println(country.getName());
        }
    }
}