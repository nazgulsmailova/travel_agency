package com.epam.smailova.travel.dao;

import com.epam.smailova.travel.model.BaseEntity;

import java.util.List;

public interface Dao<T extends BaseEntity> {


    T insert(T entity) throws DaoException;

    boolean delete(Integer id) throws DaoException;

    void delete(T baseEntity) throws DaoException;

    T findByID(Integer id) throws DaoException;

    void update(T entity) throws DaoException;

    T get(Integer id) throws DaoException;

    List<T> getAll() throws DaoException;


}
