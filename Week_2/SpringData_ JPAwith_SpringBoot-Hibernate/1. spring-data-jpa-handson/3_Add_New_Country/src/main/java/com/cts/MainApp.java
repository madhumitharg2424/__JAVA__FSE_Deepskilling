package com.cts;

public class MainApp {

    public static void main(String[] args) {

        CountryService service = new CountryService();

        service.addCountry(new Country("IN", "India"));
        service.addCountry(new Country("US", "United States"));
        service.addCountry(new Country("JP", "Japan"));

        System.out.println("Countries List:");

        for (Country country : service.getAllCountries()) {

            System.out.println(
                    country.getCode() +
                            " - " +
                            country.getName()
            );
        }
    }
}