package com.eventmanagement.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.eventmanagement.connection.ConnectionFactory;
import com.eventmanagement.models.Task;

public class TaskDAOImpl implements TaskDAO {

	 @Override
	    public List<Task> getTasksByEventId(int eventId) {
	        List<Task> tasks = new ArrayList<>();
	        String query = "SELECT * FROM tasks WHERE event_id = ?";

	        try (Connection con = ConnectionFactory.requestConnection();
	             PreparedStatement stmt = con.prepareStatement(query)) {

	            stmt.setInt(1, eventId);
	            ResultSet rs = stmt.executeQuery();

	            while (rs.next()) {
	                Task task = new Task(
	                        rs.getInt("id"),
	                        rs.getString("task_name"),
	                        rs.getString("description"),
	                        rs.getString("assigned_to"),
	                        rs.getString("status"),
	                        rs.getInt("event_id")
	                );
	                tasks.add(task);
	            }

	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return tasks;
	    }

	    @Override
	    public Task getTaskById(int taskId) {
	        Task task = null;
	        String query = "SELECT * FROM tasks WHERE id = ?";

	        try (Connection con = ConnectionFactory.requestConnection();
	             PreparedStatement stmt = con.prepareStatement(query)) {

	            stmt.setInt(1, taskId);
	            ResultSet rs = stmt.executeQuery();

	            if (rs.next()) {
	                task = new Task(
	                        rs.getInt("id"),
	                        rs.getString("task_name"),
	                        rs.getString("description"),
	                        rs.getString("assigned_to"),
	                        rs.getString("status"),
	                        rs.getInt("event_id")
	                );
	            }

	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return task;
	    }

	    @Override
	    public void updateTask(Task task) {
	        String query = "UPDATE tasks SET status = ? WHERE id = ?";

	        try (Connection con = ConnectionFactory.requestConnection();
	             PreparedStatement stmt = con.prepareStatement(query)) {

	            stmt.setString(1, task.getStatus());
	            stmt.setInt(2, task.getId());

	            stmt.executeUpdate();

	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
    }

	


