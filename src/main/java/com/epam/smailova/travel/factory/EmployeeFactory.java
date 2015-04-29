package com.epam.smailova.travel.factory;


import com.epam.smailova.travel.model.Employee;
import com.thedeanda.lorem.Lorem;

public class EmployeeFactory {

    public static Employee create() {
        Employee employee = new Employee();
        String firstName = Lorem.getFirstName();
        String lastName = Lorem.getLastName();
        employee.setFirstName(firstName);
        employee.setLastName(lastName);
        employee.setLogin(firstName.toLowerCase() +  lastName.toLowerCase());
        return employee;
    }
}
