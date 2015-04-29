package com.epam.smailova.travel.daodao;

import com.epam.smailova.travel.model.Employee;
import static com.epam.smailova.travel.daodao.DAOUtil.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAOJDBC implements EmployeeDAO {
    private static final String SQL_FIND_BY_ID = "SELECT id,firstName,lastName,login,password FROM employees id=?";
    private static final String SQL_FIND_BY_LOGIN_AND_PASSWORD = "SELECT id,firstName,lastName FROM employees WHERE login=? AND password=MD5(?)";
    private static final String SQL_LIST_ORDER_BY_ID = "SELECT id,firstName,lastName,login FROM employees ORDER BY id";
    private static final String SQL_INSERT = "INSERT INTO employees(firstName,lastName,login,password) VALUES (?,?,?,MD5(?))";
    private static final String SQL_UPDATE = "UPDATE employees SET firstName=?,lastName=?,login=? WHERE id=?";
    private static final String SQL_DELETE = "DELETE FROM employees WHERE id=?";
    private static final String SQL_EXIST_LOGIN = "SELECT id FROM employees WHERE login=?";
    private static final String SQL_CHANGE_PASSWORD = "UPDATE employees SET password =MD5(?) WHERE id=?";

    private DAOFactory daoFactory;

    EmployeeDAOJDBC(DAOFactory daoFactory) {
        this.daoFactory = daoFactory;
    }

    private static Employee map(ResultSet resultSet) throws SQLException {
        Employee employee = new Employee();
        employee.setId(resultSet.getInt("id"));
        employee.setFirstName(resultSet.getString("firstName"));
        employee.setLastName(resultSet.getString("lastName"));
        employee.setLogin(resultSet.getString("login"));
        return employee;
    }

    @Override
    public Employee find(Integer id) throws DAOException {
        return find(SQL_FIND_BY_ID, id);
    }

    @Override
    public Employee find(String login, String password) throws DAOException {
        return find(SQL_FIND_BY_LOGIN_AND_PASSWORD, login, password);
    }

    private Employee find(String sql, Object... values) throws DAOException {
        Employee employee = null;
        try (Connection connection = daoFactory.getConnection();
             PreparedStatement statement = prepareStatement(connection, sql, false, values);
             ResultSet resultSet = statement.executeQuery()) {
            if (resultSet.next()) {
                employee = map(resultSet);
            }
        } catch (SQLException e) {
            throw new DAOException(e);
        }
        return employee;
    }

    @Override
    public List<Employee> list() throws DAOException {
        List<Employee> employees = new ArrayList<>();
        try (Connection connection = daoFactory.getConnection();
             PreparedStatement statement = connection.prepareStatement(SQL_LIST_ORDER_BY_ID);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                employees.add(map(resultSet));
            }
        } catch (SQLException e) {
            throw new DAOException(e);
        }
        return employees;
    }

    @Override
    public void create(Employee employee) throws DAOException, IllegalArgumentException {
        if (employee.getId() != null) {
            throw new IllegalArgumentException("Employee is already created, the employee ID is not null");
        }
        Object[] values = {
                employee.getFirstName(),
                employee.getLastName(),
                employee.getLogin(),
                employee.getPassword()
        };
        try (Connection connection = daoFactory.getConnection();
             PreparedStatement statement = prepareStatement(connection, SQL_INSERT, true, values)) {
            int affectedRows = statement.executeUpdate();
            if (affectedRows == 0) {
                throw new DAOException("Creating employee failed, no rows affected");
            }
            try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    employee.setId(generatedKeys.getInt(1));
                } else {
                    throw new DAOException("Created employee failed, no generated key obtained.");
                }
            }
        } catch (SQLException e) {
            throw new DAOException(e);
        }
    }

    @Override
    public void update(Employee employee) throws IllegalArgumentException, DAOException {
        if (employee.getId() == null) {
            throw new IllegalArgumentException("Employee is not created yet, the employee ID is null");
        }
        Object[] values = {
                employee.getFirstName(),
                employee.getLastName(),
                employee.getLogin(),
                employee.getId()
        };
        try (Connection connection = daoFactory.getConnection();
             PreparedStatement statement = prepareStatement(connection, SQL_UPDATE, false, values)) {
            int affectedRows = statement.executeUpdate();
            if (affectedRows == 0) {
                throw new DAOException("Updaing employee failed no rows affected");
            }
        } catch (SQLException e) {
            throw new DAOException(e);
        }
    }

    @Override
    public void delete(Employee employee) throws DAOException {
        Object[] values = {
                employee.getId()
        };
        try (Connection connection = daoFactory.getConnection();
             PreparedStatement statement = prepareStatement(connection, SQL_DELETE, false, values))
        {
            int affectedRows = statement.executeUpdate();
            if (affectedRows == 0) {
                throw new DAOException("Deleting emp failed");
            } else employee.setId(null);
        } catch (SQLException e) {
            {
                throw new DAOException(e);
            }
        }
    }

    @Override
    public boolean existLogin(String login) throws DAOException {
        Object[] values = {
                login
        };
        boolean exist = false;
        try (Connection connection = daoFactory.getConnection();
             PreparedStatement statement = prepareStatement(connection, SQL_EXIST_LOGIN, false, values);
             ResultSet resultSet = statement.executeQuery())
        {
            exist = resultSet.next();
        } catch (SQLException e) {
            throw new DAOException(e);
        }
        return exist;
    }

    @Override
    public void changePassword(Employee employee) throws DAOException {
        if (employee.getId() == null) {
            throw new IllegalArgumentException("Employee is not created");
        }
        Object[] values = {
                employee.getPassword(),
                employee.getId()
        };
        try (Connection connection = daoFactory.getConnection();
             PreparedStatement statement = prepareStatement(connection, SQL_CHANGE_PASSWORD, false, values);) {
            int affectedRows = statement.executeUpdate();
            if (affectedRows == 0) {
                throw new DAOException("changing password failed");
            }
        } catch (SQLException e) {
            throw new DAOException(e);
        }
    }
}
