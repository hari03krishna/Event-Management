package com.eventmanagement.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
import java.util.List;

import com.eventmanagement.dao.AttendeeDAO;
import com.eventmanagement.dao.AttendeeDAOImpl;
import com.eventmanagement.dao.EventDAO;
import com.eventmanagement.dao.EventDAOImpl;
import com.eventmanagement.models.Attendee;
import com.eventmanagement.models.Event;
@WebServlet("/AttendeeServlet")
public class AttendeeServlet extends HttpServlet {
    private AttendeeDAO attendeeDAO;
    private EventDAO eventDAO;

    @Override
    public void init() throws ServletException {
        super.init();
        // Instantiate the concrete DAO classes
        attendeeDAO = new AttendeeDAOImpl();
        eventDAO = new EventDAOImpl();
    }

    // Handling GET requests for viewing the list of attendees and event assignments
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        if (action != null && action.equals("delete")) {
            String attendeeId = request.getParameter("attendeeId");
            if (attendeeId != null && !attendeeId.isEmpty()) {
                try {
                    attendeeDAO.deleteAttendee(Integer.parseInt(attendeeId));  // Delete the attendee by ID
                    response.sendRedirect("attendeeManagement.jsp");  // Redirect to the attendee list page after deletion
                } catch (NumberFormatException e) {
                    response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid attendee ID");
                }
            } else {
                response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Attendee ID is missing");
            }
        } else {
            // Fetch all attendees and events
            List<Attendee> attendees = attendeeDAO.getAllAttendees();
            List<Event> events = eventDAO.getAllEvents();

            // Set attributes to be used in the JSP page
            request.setAttribute("attendees", attendees);
            request.setAttribute("events", events);

            RequestDispatcher dispatcher = request.getRequestDispatcher("attendeeManagement.jsp");
            dispatcher.forward(request, response);
        }
    }

    // Handling POST requests for adding a new attendee or assigning attendees to events
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        if (action != null && action.equals("add")) {
            // Get attendee details from the form and create a new Attendee object
            String name = request.getParameter("name");
            String email = request.getParameter("email");

            if (name != null && !name.isEmpty() && email != null && !email.isEmpty()) {
                Attendee attendee = new Attendee(name, email);
                attendeeDAO.addAttendee(attendee);  // Add the new attendee

                response.sendRedirect("attendeeManagement.jsp");  // Redirect to the attendee list page
            } else {
                request.setAttribute("error", "Both name and email are required.");
                RequestDispatcher dispatcher = request.getRequestDispatcher("addAttendee.jsp");
                dispatcher.forward(request, response);
            }
        } else if (action != null && action.equals("assign")) {
            try {
                // Get attendee and event IDs from the form
                int attendeeId = Integer.parseInt(request.getParameter("attendeeId"));
                int eventId = Integer.parseInt(request.getParameter("eventId"));

                // Fetch attendee and event by ID
                Attendee attendee = attendeeDAO.getAttendeeById(attendeeId);
                Event event = eventDAO.getEventById(eventId);

                if (attendee != null && event != null) {
                    // Assign attendee to event
                    attendee.setAssignedEvent(event);  // This assumes an Attendee has a setAssignedEvent method
                    attendeeDAO.updateAttendee(attendee);  // Update the attendee's assignment in the database

                    response.sendRedirect("attendeeManagement.jsp");  // Redirect to the attendee list page
                } else {
                    request.setAttribute("error", "Invalid attendee or event ID.");
                    RequestDispatcher dispatcher = request.getRequestDispatcher("attendeeManagement.jsp");
                    dispatcher.forward(request, response);
                }
            } catch (NumberFormatException e) {
                response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid attendee or event ID.");
            }
        }
    }
}
