package com.cts;

public class MainApp {

    public static void main(String[] args) {

        CountryService service = new CountryService();

        for (Country country : service.getAllCountries()) {

            System.out.println(
                    country.getCode() +
                            " - " +
                            country.getName()
            );
        }
    }
}