package com.eventmanagement.servlets;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/registerServlet")
public class RegisterServlet extends HttpServlet {
private static final long serialVersionUID = 1L;
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Retrieve form data
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String phone = request.getParameter("phone");
        String address = request.getParameter("address");

        // Perform the registration logic (e.g., save to the database)
        // Assuming you have a UserDAO class to handle database operations

        boolean registrationSuccess = false;

        try {
            // Add your registration logic here (e.g., validate and insert data into the database)
            // UserDAO.saveUser(name, email, password, phone, address);
            registrationSuccess = true; // Simulate successful registration
        } catch (Exception e) {
            registrationSuccess = false;
        }

        // If registration is successful, set a success message
        if (registrationSuccess) {
            request.setAttribute("registrationSuccess", "true");
        }

        // Forward to register.jsp to show success message
        RequestDispatcher dispatcher = request.getRequestDispatcher("register.jsp");
        dispatcher.forward(request, response);
    }
}
