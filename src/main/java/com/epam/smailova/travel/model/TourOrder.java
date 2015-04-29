package com.epam.smailova.travel.model;

import java.util.List;

public class TourOrder extends BaseEntity {
    private Client client;
    private List<Tour> tours;
    private TourStatus tourStatus;
    private long price;
    private long discount;

   // private Employee employee;
   // private List<Country> countries;

    public TourOrder() {
    }

    public TourOrder(Client client, List<Tour> tours, Account account, long price, long discount, boolean status) {
        this.price = price;
        this.discount = discount;

    }


    public TourStatus getTourStatus() {
        return tourStatus;
    }

    public void setTourStatus(TourStatus tourStatus) {
        this.tourStatus = tourStatus;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public List<Tour> getTours() {
        return tours;
    }

    public void setTours(List<Tour> tours) {
        this.tours = tours;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public long getDiscount() {
        return discount;
    }

    public void setDiscount(long discount) {
        this.discount = discount;
    }


}
