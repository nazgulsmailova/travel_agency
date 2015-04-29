package com.epam.smailova.travel.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JdbcDaoFactory extends DaoFactory {
    public static final String PASSWORD = "root";
    private static final String URL = "jdbc:mysql://localhost:3306/travel";
    private static final String USERNAME = "root";
    public static JdbcDaoFactory instance;

    public JdbcDaoFactory() {
    }

    public static JdbcDaoFactory getInstance() {
        return instance;
    }

  //  public EmployeeDao createEmployeeDao() throws DaoException {
    private Connection getConnection() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (SQLException e) {
            try {
                throw new DaoException("Cannot get new connection!", e);
            } catch (DaoException daoException) {
                daoException.printStackTrace();
            }

        }
        return connection;
    }


    public <T extends JdbcDao> T create(Class<T> daoClass) throws DaoException {
        T dao;
        try {
            dao = (T) daoClass.newInstance();
        } catch (Exception e) {
            throw new DaoException("Cannot create dao for class " + daoClass, e);
        }
        dao.setConnection(getConnection());
        return dao;
    }


}
