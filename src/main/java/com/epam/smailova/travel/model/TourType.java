package com.epam.smailova.travel.model;

public enum TourType {
    RELAXATION{
        {
            this.nameTour = "relaxation";
        }
    },
    EXCURSION{
        {
            this.nameTour = "excursion";
        }
    },
    SHOPPING{
        {
            this.nameTour = "shopping";
        }
    },
    HEALING{
        {
            this.nameTour = "healing";
        }
    };

    String nameTour;

    public String getTourType() {
        return nameTour;
    }
}
