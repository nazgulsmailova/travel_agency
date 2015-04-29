package com.epam.smailova;


import com.epam.smailova.travel.dao.DaoFactory;
import com.epam.smailova.travel.dao.EmployeeDao;
import com.epam.smailova.travel.dao.JdbcDaoFactory;
import com.epam.smailova.travel.daodao.DAOFactory;
import com.epam.smailova.travel.daodao.EmployeeDAO;
import com.epam.smailova.travel.factory.TourFactory;
import com.epam.smailova.travel.factory.TourOrderFactory;
import com.epam.smailova.travel.model.Employee;
import com.epam.smailova.travel.model.Tour;
import com.epam.smailova.travel.model.TourOrder;
import org.boon.Boon;

import java.util.List;

import static com.epam.smailova.travel.dao.DaoFactory.Type.Jdbc;

public class Runner {
    public static void main(String[] args) {
        DAOFactory travel=DAOFactory.getInstance("travel.jdbc");
        System.out.println("DAOFactory successfully obtained: "+travel);
        EmployeeDAO employeeDAO=travel.getEmployeeDao();
        System.out.println("EmployeeDAO successfully obtained: "+employeeDAO);

        Employee employee=new Employee();


        Employee employee1=new Employee();
        employee1.setFirstName("olga");
        employee1.setLastName("petrova");
        employee1.setLogin("olgap1");
        employee1.setPassword("pass");
        employeeDAO.create(employee1);
        System.out.println("another employee created"+employee1);

        employee.setFirstName("Foo");
        employee.setLastName("ivanovna");
        employeeDAO.update(employee);
        System.out.println("employee updated "+employee);

        List<Employee> employees=employeeDAO.list();
        System.out.println("List of enployees "+employees);
        System.out.println("thus. amount of employees "+employees.size());

        employeeDAO.delete(employee);
        System.out.println("employee deleted "+employee);

        boolean exist=employeeDAO.existLogin("olgap1");
        System.out.println("this login should not exist anymore "+exist);

        employee1.setPassword("newpass");
        employeeDAO.changePassword(employee1);
        System.out.println("new password for employee "+employee1);

        Employee foundAnotherEmployee=employeeDAO.find("jamesch","1234");
        System.out.println("find by login pass");

        employeeDAO.delete(foundAnotherEmployee);
        System.out.println("deleted "+foundAnotherEmployee);

        employees=employeeDAO.list();
        System.out.println("List of employee queried "+employees);
        System.out.println("Thus, amount of employees in database is "+employees.size());

        /*Employee employee=new Employee( "login", "Pass");
        DaoFactory factory=DaoFactory.getInstance(Jdbc);
        EmployeeDao employeeDao=factory.create(EmployeeDao.class);
        System.out.println(employeeDao.getClass());*/
    }
}
