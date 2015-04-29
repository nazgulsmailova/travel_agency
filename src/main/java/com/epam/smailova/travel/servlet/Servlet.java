package com.epam.smailova.travel.servlet;

import com.epam.smailova.travel.factory.TourOrderFactory;
import com.epam.smailova.travel.model.TourOrder;
import org.boon.Boon;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet(name = "Servlet", urlPatterns = "/servlet")
public class Servlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        super.doPost(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        // PrintWriter writer = response.getWriter();
        TourOrder tourOrder = TourOrderFactory.create();
        //  String s = Boon.toPrettyJson(tourOrder);
        request.setAttribute("tourOrder", tourOrder);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/index.jsp");
        requestDispatcher.forward(request, response);

    }
}
