package com.epam.smailova.travel.dao;

import com.epam.smailova.travel.model.Employee;

import java.sql.*;
import java.util.List;

public class JdbcEmployeeDao extends JdbcDao<Employee> implements EmployeeDao {
    public static final String INSERT_NEW = "INSERT INTO employees (firstName, lastName,login,password) VALUES(?,?,?,?)";
    public static final String FIND_BY_NAME = "SELECT id,firstName,login,password FROM employees WHERE lastName=?";
    private static final String URL = "jdbc:mysql://localhost:3306/travel";


    public JdbcEmployeeDao(Connection connection) {
        super( connection);
    }

    public Employee insert(Employee employee){

        JdbcDaoFactory jdbcDaoFactory = new JdbcDaoFactory();
        try (Connection connection= DriverManager.getConnection(URL, "root", "root");
             PreparedStatement statement1 = connection.prepareStatement(INSERT_NEW)){
           {
                statement1.setString(1, employee.getFirstName());
                statement1.setString(2, employee.getLastName());
                statement1.setString(3, employee.getLogin());
                statement1.setString(4, employee.getPassword());
                statement1.executeUpdate();
               ResultSet keys=statement1.getGeneratedKeys();
               keys.next();
               Integer id=keys.getInt(1);
               employee.setId(id);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {

        }return  employee;

}

    @Override
    public Employee findByLastName(String name) throws DaoException {
        JdbcDaoFactory jdbcDaoFactory = new JdbcDaoFactory();
        Employee employee=new Employee();
        try (Connection connection= DriverManager.getConnection(URL, "root", "root");
             PreparedStatement statement1 = connection.prepareStatement(FIND_BY_NAME)){
            {
                statement1.setString(2,name);
                ResultSet resultSet=statement1.executeQuery();
                resultSet.next();
                employee.setId(resultSet.getInt("id"));
                employee.setFirstName(resultSet.getString("firstName"));
                employee.setLastName(resultSet.getString("name"));
                           }

        } catch (SQLException e) {
            System.err.println("SQL exception (request or table failed: )"+e);
        }finally {

        }return  employee;

    }

    @Override
    public boolean delete(Integer id) {

        return false;
    }

    @Override
    public void delete(Employee baseEntity) {

    }

    @Override
    public Employee findByID(Integer id) {
        return null;
    }

    @Override
    public void update(Employee entity) {

    }

    @Override
    public Employee get(Integer id) {
        return null;
    }

    @Override
    public List<Employee> getAll() {
        return null;
    }
}
