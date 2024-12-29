package com.eventmanagement.servlets;

import java.io.IOException;

import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.eventmanagement.dao.EventDAO;
import com.eventmanagement.dao.EventDAOImpl;
import com.eventmanagement.models.Event;

import jakarta.servlet.annotation.WebServlet;
@WebServlet("/event")
public class EventServlet extends HttpServlet{
	 private EventDAO eventDAO;

	    @Override
	    public void init() throws ServletException {
	        super.init();
	        eventDAO = new EventDAOImpl();  // Create an instance of EventDAO
	    }

	    @Override
	    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	        String action = request.getParameter("action");

	        if (action != null && action.equals("delete")) {
	            // Get event id from the URL and delete it
	            String eventIdParam = request.getParameter("eventId");
	            if (eventIdParam != null) {
	                try {
	                    int eventId = Integer.parseInt(eventIdParam);
	                    eventDAO.deleteEvent(eventId);
	                    response.sendRedirect("eventManagement.jsp");  // Redirect to the event list page after deletion
	                } catch (NumberFormatException e) {
	                    // Handle invalid eventId format
	                    response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid event ID");
	                }
	            } else {
	                response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Event ID is required for deletion");
	            }
	        } else {
	            // Display all events
	            List<Event> events = eventDAO.getAllEvents();  // Fetch events from the database
	            request.setAttribute("events", events);
	            RequestDispatcher dispatcher = request.getRequestDispatcher("eventManagement.jsp");
	            dispatcher.forward(request, response);
	        }
	    }

	    @Override
	    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	        String action = request.getParameter("action");

	        if (action != null && action.equals("add")) {
	            // Get event details from the form and create a new event
	            String name = request.getParameter("name");
	            String description = request.getParameter("description");
	            String location = request.getParameter("location");
	            String date = request.getParameter("date");

	            // Validate event fields to make sure they are not empty
	            if (name == null || name.isEmpty() || description == null || description.isEmpty() || 
	                location == null || location.isEmpty() || date == null || date.isEmpty()) {
	                // If any field is empty, redirect back to the form with an error message
	                request.setAttribute("error", "All fields are required.");
	                request.getRequestDispatcher("addEvent.jsp").forward(request, response);
	                return;
	            }

	            // Create a new Event object
	            Event event = new Event(name, description, location, date);
	            eventDAO.addEvent(event);  // Save the event using EventDAO

	            // Redirect to the event list page
	            response.sendRedirect("event");  // Will be handled by doGet, showing all events
	        } else if (action != null && action.equals("edit")) {
	            // Get event details for editing
	            try {
	                int eventId = Integer.parseInt(request.getParameter("eventId"));
	                String name = request.getParameter("name");
	                String description = request.getParameter("description");
	                String location = request.getParameter("location");
	                String date = request.getParameter("date");

	                // Validate fields
	                if (name == null || name.isEmpty() || description == null || description.isEmpty() || 
	                    location == null || location.isEmpty() || date == null || date.isEmpty()) {
	                    request.setAttribute("error", "All fields are required.");
	                    request.getRequestDispatcher("editEvent.jsp").forward(request, response);
	                    return;
	                }

	                // Update the event
	                Event event = new Event(eventId, name, description, location, date);
	                eventDAO.updateEvent(event);

	                // Redirect to the event list page
	                response.sendRedirect("event");
	            } catch (NumberFormatException e) {
	                // Handle invalid eventId format for editing
	                response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid event ID");
	            }
	        } else {
	            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Unknown action: " + action);
	        }
	    }
}
