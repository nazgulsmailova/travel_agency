package com.epam.smailova.travel.model;

import java.util.List;

public class Country extends NamedEntity {
    List<Tour> tours;
    private String description;

    public Country() {
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Tour> getTours() {
        return tours;
    }

    public void setTours(List<Tour> tours) {
        this.tours = tours;
    }

    @Override
    public String toString() {
        return "name: " + super.getName() +
                "description='" + description + '\'' +
                '}';
    }
}
