package com.epam.smailova.travel.factory;

import java.util.Date;

public class Dates {
    public static Date randomDateBetween(Date start, Date end) {
        long delta = (long) (Math.random() * (end.getTime() - start.getTime()));
        return new Date(start.getTime() + delta);
    }
}
