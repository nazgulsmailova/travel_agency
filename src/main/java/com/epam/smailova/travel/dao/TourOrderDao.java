package com.epam.smailova.travel.dao;

import com.epam.smailova.travel.model.TourOrder;

import java.util.List;

public interface TourOrderDao extends Dao<TourOrder> {
    @Override
    TourOrder insert(TourOrder entity) throws DaoException;

    @Override
    boolean delete(Integer id) throws DaoException;

    @Override
    void delete(TourOrder baseEntity) throws DaoException;

    @Override
    TourOrder findByID(Integer id) throws DaoException;

    @Override
    void update(TourOrder entity) throws DaoException;

    @Override
    TourOrder get(Integer id) throws DaoException;

    @Override
    List<TourOrder> getAll() throws DaoException;
}
