package com.epam.smailova.travel.factory;

import com.epam.smailova.travel.model.Account;

public class AccountFactory {
    public static Account create() {
        Account account = new Account();
        account.setAmount((long) Math.random());
        return account;
    }


}
