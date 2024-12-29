package com.eventmanagement.servlets;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import com.eventmanagement.dao.TaskDAO;
import com.eventmanagement.dao.TaskDAOImpl;
import com.eventmanagement.models.Task;

@WebServlet("/TaskTrackerServlet")
public class TaskTrackerServlet extends HttpServlet {
    // Create an instance of TaskDAO
    private TaskDAO taskDAO = new TaskDAOImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String eventIdParam = request.getParameter("eventId");

        // Validate if eventId is provided
        if (eventIdParam == null || eventIdParam.isEmpty()) {
            // If no eventId is provided, redirect to an error page or show a message
            request.setAttribute("errorMessage", "Event ID is required to view tasks.");
            request.getRequestDispatcher("/error.jsp").forward(request, response);
            return;
        }

        try {
            int eventId = Integer.parseInt(eventIdParam); // Parse the eventId from the request

            // Get all tasks for the specified event
            List<Task> tasks = taskDAO.getTasksByEventId(eventId);

            if (tasks != null) {
                // Set the tasks as a request attribute to pass to the JSP
                request.setAttribute("tasks", tasks);
            } else {
                request.setAttribute("errorMessage", "No tasks found for the specified event.");
            }

            // Forward to the task tracker page (taskTracker.jsp)
            RequestDispatcher dispatcher = request.getRequestDispatcher("/taskTracker.jsp");
            dispatcher.forward(request, response);
        } catch (NumberFormatException e) {
            // If eventId is not a valid number, show an error message
            request.setAttribute("errorMessage", "Invalid event ID.");
            request.getRequestDispatcher("/error.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String taskIdParam = request.getParameter("taskId");
        String newStatus = request.getParameter("status");

        // Validate if taskId and status are provided
        if (taskIdParam == null || taskIdParam.isEmpty() || newStatus == null || newStatus.isEmpty()) {
            request.setAttribute("errorMessage", "Task ID and status are required.");
            request.getRequestDispatcher("/error.jsp").forward(request, response);
            return;
        }

        try {
            int taskId = Integer.parseInt(taskIdParam); // Parse the taskId from the request

            // Get the task by ID
            Task task = taskDAO.getTaskById(taskId);

            if (task != null) {
                task.setStatus(newStatus);  // Update task status
                taskDAO.updateTask(task);    // Persist the changes
            } else {
                request.setAttribute("errorMessage", "Task not found.");
                request.getRequestDispatcher("/error.jsp").forward(request, response);
                return;
            }

            // Redirect to refresh the task tracker page after successful update
            response.sendRedirect("taskTracker.jsp?eventId=" + request.getParameter("eventId"));
        } catch (NumberFormatException e) {
            // Handle invalid task ID format
            request.setAttribute("errorMessage", "Invalid task ID.");
            request.getRequestDispatcher("/error.jsp").forward(request, response);
        }
    }
}
