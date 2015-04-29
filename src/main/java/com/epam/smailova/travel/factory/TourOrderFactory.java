package com.epam.smailova.travel.factory;

import com.epam.smailova.travel.model.Client;
import com.epam.smailova.travel.model.Employee;
import com.epam.smailova.travel.model.TourOrder;

public class TourOrderFactory {
    public static TourOrder create() {
        TourOrder tourOrder = new TourOrder();
        Client client = ClientFactory.create();
        tourOrder.setClient(client);
        tourOrder.getTourStatus();
        long price = (long) (Math.random() * 50000);
        long discount = (long) (Math.random() * 500);
        tourOrder.setPrice(price - discount);
        tourOrder.setDiscount(discount);
        tourOrder.setTours(TourFactory.createList(10, tourOrder));
        return tourOrder;
    }
}
