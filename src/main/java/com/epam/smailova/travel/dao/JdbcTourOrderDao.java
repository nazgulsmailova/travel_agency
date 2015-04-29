package com.epam.smailova.travel.dao;

import com.epam.smailova.travel.model.TourOrder;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class JdbcTourOrderDao extends JdbcDao<TourOrder> implements TourOrderDao {

    public static final String DELETE_BY_ID = "DELETE FROM tourorder WHERE id=?";
    private static final String URL = "jdbc:mysql://localhost:3306/travel";

    public JdbcTourOrderDao(Connection connection) {
        super(connection);
    }

    @Override
    public TourOrder insert(TourOrder entity) throws DaoException {
        return null;
    }

    @Override
    public boolean delete(Integer id) throws DaoException {
        boolean flag = false;
        try (Connection connection = DriverManager.getConnection(URL, "root", "root");
             PreparedStatement preparedStatement = connection.prepareStatement(DELETE_BY_ID)) {
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
            flag = true;
        } catch (SQLException e) {

        }
        return flag;
    }


    @Override
    public void delete(TourOrder baseEntity) throws DaoException {

    }

    @Override
    public TourOrder findByID(Integer id) throws DaoException {
        return null;
    }

    @Override
    public void update(TourOrder entity) throws DaoException {

    }

    @Override
    public TourOrder get(Integer id) throws DaoException {
        return null;
    }

    @Override
    public List<TourOrder> getAll() throws DaoException {
        return null;
    }


}
