package com.epam.smailova.travel.factory;

import com.epam.smailova.travel.model.Account;
import com.epam.smailova.travel.model.Client;
import com.thedeanda.lorem.Lorem;

import java.util.Date;

public class ClientFactory {
    private static final Date BIRTHDAY_START = new Date(70, 0, 1);
    private static final Date BIRTHDAY_END = new Date(100, 0, 1);

    public static Client create() {
        Client client = new Client();
        client.setBirthday(Dates.randomDateBetween(BIRTHDAY_START, BIRTHDAY_END));
        String firstName = Lorem.getFirstName();
        String lastName = Lorem.getLastName();
        String address = Lorem.getWords(10);
        String phone = Lorem.getPhone();
        client.setTelephone(phone);
        client.setAddress(address);
        client.setFirstName(firstName);
        client.setLastName(lastName);
        Account account = AccountFactory.create();
        return client;
    }
}
