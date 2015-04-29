package com.epam.smailova.travel.factory;


import com.epam.smailova.travel.model.Country;
import com.epam.smailova.travel.model.Employee;
import com.epam.smailova.travel.model.Tour;
import com.epam.smailova.travel.model.TourOrder;
import com.thedeanda.lorem.Lorem;

import java.util.ArrayList;
import java.util.List;

public class TourFactory {
    public static List<Tour> createList(int amount, TourOrder tourOrder) {
        List<Tour> tours = new ArrayList<>();
        for (int i = 0; i < amount; i++) tours.add(create(tourOrder));
        return tours;
    }

    public static Tour create(TourOrder tourOrder) {
        Tour tour = new Tour();
        Employee employee = EmployeeFactory.create();
        tour.setTourOrder(tourOrder);
        tour.setEmployee(employee);
        tour.setDescription(Lorem.getWords(150));
        tour.setName(Lorem.getTitle(2));
        tour.setDuration((int) (Math.random() * 50));
        tour.setPrice((long) (Math.random() * 1000));
        tour.setHot(true);
        tour.getTourType();
        tour.setCountries(CountryFactory.createList(5));
        tour.setDeleted(Math.random() < 0.2);
        return tour;
    }

}

