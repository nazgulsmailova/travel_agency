package com.epam.smailova.travel.model;

public enum TourStatus {

    ACCEPT{
        {
            this.nameTour = "accept";
        }
    },
    REJECT{
        {
            this.nameTour = "reject";
        }
    },
    WAITING{
        {
            this.nameTour = "waiting";
        }
    };
    /*HEALING{
        {
            this.nameTour = "healing";
        }
    };*/

    String nameTour;

    public String getTourType() {
        return nameTour;
    }
}
