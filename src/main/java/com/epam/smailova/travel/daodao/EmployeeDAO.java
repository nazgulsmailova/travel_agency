package com.epam.smailova.travel.daodao;

import com.epam.smailova.travel.model.Employee;

import java.util.List;

public interface EmployeeDAO {
    public Employee find(Integer id) throws DAOException;
    public Employee find(String login, String password) throws DAOException;
    public List<Employee> list() throws DAOException;
    public void create(Employee employee) throws DAOException,IllegalArgumentException;
    public void update(Employee employee) throws IllegalArgumentException,DAOException;
    public void delete(Employee employee) throws DAOException;
    public boolean existLogin(String login) throws DAOException;
    public void changePassword(Employee employee) throws DAOException;
}
