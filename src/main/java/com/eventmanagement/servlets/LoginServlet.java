package com.eventmanagement.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Retrieve email and password from the login form
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        // Authenticate the user (replace with actual database logic)
        boolean isAuthenticated = authenticateUser(email, password);

        if (isAuthenticated) {
            // Create a session and store user information
            HttpSession session = request.getSession();
            session.setAttribute("user", email);
            // Redirect to the dashboard page after successful login
            response.sendRedirect("dashboard.jsp");
        } else {
            // If authentication fails, redirect back to login with an error
            response.sendRedirect("login.jsp?error=true");
        }
    }

    private boolean authenticateUser(String email, String password) {
        // Mock authentication (in a real app, you'd check this against a database)
        return email.equals("user@example.com") && password.equals("password123");
    }
}
