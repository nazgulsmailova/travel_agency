package com.epam.smailova.travel.model;

import java.util.UUID;

public class Account extends BaseEntity {
    private long amount;

    public Account(long amount) {
                this.amount = amount;
    }

    public Account() {
    }

    public Account(UUID uuid) {

    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(long amount) {
        this.amount = amount;
    }
    public void addAmount (long amount) {
        this.amount += amount;
    }
}
