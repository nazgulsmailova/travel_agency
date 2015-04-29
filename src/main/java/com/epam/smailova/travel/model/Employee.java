package com.epam.smailova.travel.model;

import java.util.UUID;


public class Employee extends Person {
    private String login;
    private String password;

    public Employee(String login, String password) {
        this.login = login;
        this.password = password;
    }


    public Employee() {
    }

    public Employee(UUID uuid) {
        super(uuid);
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
