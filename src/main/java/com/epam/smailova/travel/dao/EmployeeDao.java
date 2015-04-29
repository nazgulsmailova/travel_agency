package com.epam.smailova.travel.dao;

import com.epam.smailova.travel.model.Employee;

import java.util.List;

public interface EmployeeDao extends Dao<Employee> {

    default Employee findByLastName(String name) throws DaoException{
        return null;
    }
    @Override
    Employee insert(Employee entity) throws DaoException;

    @Override
    boolean delete(Integer id) throws DaoException;

    @Override
    void delete(Employee baseEntity) throws DaoException;

    @Override
    Employee findByID(Integer id) throws DaoException;

    @Override
    void update(Employee entity) throws DaoException;

    @Override
    Employee get(Integer id) throws DaoException;

    @Override
    List<Employee> getAll() throws DaoException;
}
