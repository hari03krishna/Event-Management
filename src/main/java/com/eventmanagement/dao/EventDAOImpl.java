package com.eventmanagement.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.eventmanagement.connection.ConnectionFactory;
import com.eventmanagement.models.Event;

public class EventDAOImpl implements EventDAO {

	 @Override
	    public List<Event> getAllEvents() {
	        List<Event> events = new ArrayList<>();
	        String query = "SELECT * FROM events";

	        try (Connection con =ConnectionFactory.requestConnection();
	             PreparedStatement stmt = con.prepareStatement(query);
	             ResultSet rs = stmt.executeQuery()) {

	            while (rs.next()) {
	                Event event = new Event(
	                        rs.getInt("id"),
	                        rs.getString("name"),
	                        rs.getString("description"),
	                        rs.getString("location"),
	                        rs.getString("event_date")
	                );
	                events.add(event);
	            }

	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return events;
	    }

	    @Override
	    public void addEvent(Event event) {
	        String query = "INSERT INTO events (name, description, location, event_date) VALUES (?, ?, ?, ?)";

	        try (Connection con = ConnectionFactory.requestConnection();
	             PreparedStatement stmt = con.prepareStatement(query)) {

	            stmt.setString(1, event.getName());
	            stmt.setString(2, event.getDescription());
	            stmt.setString(3, event.getLocation());
	            stmt.setString(4, event.getDate());

	            stmt.executeUpdate();

	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }

	    @Override
	    public void deleteEvent(int eventId) {
	        String query = "DELETE FROM events WHERE id = ?";

	        try (Connection con = ConnectionFactory.requestConnection();
	             PreparedStatement stmt = con.prepareStatement(query)) {

	            stmt.setInt(1, eventId);
	            stmt.executeUpdate();

	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }

	    @Override
	    public void updateEvent(Event event) {
	        String query = "UPDATE events SET name = ?, description = ?, location = ?, event_date = ? WHERE id = ?";

	        try (Connection con = ConnectionFactory.requestConnection();
	             PreparedStatement stmt = con.prepareStatement(query)) {

	            stmt.setString(1, event.getName());
	            stmt.setString(2, event.getDescription());
	            stmt.setString(3, event.getLocation());
	            stmt.setString(4, event.getDate());
	            stmt.setInt(5, event.getId());

	            stmt.executeUpdate();

	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }

	    @Override
	    public Event getEventById(int eventId) {
	        Event event = null;
	        String query = "SELECT * FROM events WHERE id = ?";

	        try (Connection conn = ConnectionFactory.requestConnection();
	             PreparedStatement stmt = conn.prepareStatement(query)) {

	            stmt.setInt(1, eventId);
	            ResultSet rs = stmt.executeQuery();

	            if (rs.next()) {
	                event = new Event(
	                        rs.getInt("id"),
	                        rs.getString("name"),
	                        rs.getString("description"),
	                        rs.getString("location"),
	                        rs.getString("event_date")
	                );
	            }

	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return event;
	    }

}
