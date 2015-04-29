package com.epam.smailova.travel.model;

import java.util.UUID;

public class Person extends BaseEntity {
    private String firstName;
    private String lastName;

    public Person() {
    }

    public Person(UUID uuid) {
        super(uuid);
    }

    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
