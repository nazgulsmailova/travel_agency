package com.epam.smailova.travel.factory;

import com.epam.smailova.travel.model.Country;
import com.thedeanda.lorem.Lorem;

import java.util.ArrayList;
import java.util.List;

public class CountryFactory {
    public static List<Country> createList(int amount) {
        ArrayList<Country> countries = new ArrayList<>();
        for (int i = 0; i < amount; i++) countries.add(create());
        return countries;
    }

    private static Country create() {
        Country country = new Country();
        country.setDescription(Lorem.getWords(150));
        return country;
    }
}
