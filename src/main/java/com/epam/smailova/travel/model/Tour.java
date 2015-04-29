package com.epam.smailova.travel.model;


import java.util.List;


public class Tour extends NamedEntity {
    TourOrder tourOrder;
    List<Country> countries;
    Employee employee;
    TourType tourType;
    private String description;
    private boolean hot;
    private long price;
    private int duration;

    public Tour() {

    }

    public TourOrder getTourOrder() {
        return tourOrder;
    }

    public void setTourOrder(TourOrder tourOrder) {
        this.tourOrder = tourOrder;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public List<Country> getCountries() {
        return countries;
    }

    public void setCountries(List<Country> countries) {
        this.countries = countries;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isHot() {
        return hot;
    }

    public void setHot(boolean hot) {
        this.hot = hot;
    }

    public TourType getTourType() {
        return tourType;
    }

    public void setTourType(TourType tourType) {
        this.tourType = tourType;
    }
}
