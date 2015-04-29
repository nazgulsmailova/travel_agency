package com.epam.smailova.travel.servlet;

import com.epam.smailova.travel.dao.DaoException;
import com.epam.smailova.travel.dao.EmployeeDao;
import com.epam.smailova.travel.dao.JdbcDaoFactory;
import com.epam.smailova.travel.dao.JdbcEmployeeDao;
import com.epam.smailova.travel.model.Employee;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
    private static final Logger LOGGER = LoggerFactory.getLogger(RegisterServlet.class);

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String login = request.getParameter("login");
        String password = request.getParameter("password");

        Employee employee = new Employee();
        employee.setFirstName(firstName);
        employee.setLastName(lastName);
        employee.setLogin(login);
        employee.setPassword(password);

//        EmployeeDao employeeDao = new JdbcDaoFactory.getInstance().create(JdbcEmployeeDao.class);
//        try {
//            employeeDao.insert(employee);
//        } catch (DaoException e) {
//            e.printStackTrace();
//        }

        LOGGER.info("New employee: {}", employee);
        request.getRequestDispatcher("/WEB-INF/successRegistration.jsp").forward(request, response);
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
    }
}
