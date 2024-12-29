package com.eventmanagement.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.eventmanagement.connection.ConnectionFactory;
import com.eventmanagement.models.Attendee;
import com.eventmanagement.models.Event;

public class AttendeeDAOImpl implements AttendeeDAO {

	 @Override
	    public List<Attendee> getAllAttendees() {
	        List<Attendee> attendees = new ArrayList<>();
	        String query = "SELECT * FROM attendees";

	        try (Connection con = ConnectionFactory.requestConnection();
	             PreparedStatement stmt = con.prepareStatement(query);
	             ResultSet rs = stmt.executeQuery()) {

	            while (rs.next()) {
	                Attendee attendee = new Attendee(
	                        rs.getInt("id"),
	                        rs.getString("name"),
	                        rs.getString("email")
	                );
	                attendees.add(attendee);
	            }

	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return attendees;
	    }

	    @Override
	    public Attendee getAttendeeById(int id) {
	        Attendee attendee = null;
	        String query = "SELECT * FROM attendees WHERE id = ?";

	        try (Connection con = ConnectionFactory.requestConnection();
	             PreparedStatement stmt = con.prepareStatement(query)) {

	            stmt.setInt(1, id);
	            ResultSet rs = stmt.executeQuery();

	            if (rs.next()) {
	                attendee = new Attendee(
	                        rs.getInt("id"),
	                        rs.getString("name"),
	                        rs.getString("email")
	                );
	            }

	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return attendee;
	    }

	    @Override
	    public void addAttendee(Attendee attendee) {
	        String query = "INSERT INTO attendees (name, email) VALUES (?, ?)";

	        try (Connection con = ConnectionFactory.requestConnection();
	             PreparedStatement stmt = con.prepareStatement(query)) {

	            stmt.setString(1, attendee.getName());
	            stmt.setString(2, attendee.getEmail());

	            stmt.executeUpdate();

	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }

	    @Override
	    public void deleteAttendee(int id) {
	        String query = "DELETE FROM attendees WHERE id = ?";

	        try (Connection con = ConnectionFactory.requestConnection();
	             PreparedStatement stmt = con.prepareStatement(query)) {

	            stmt.setInt(1, id);
	            stmt.executeUpdate();

	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }

	    @Override
	    public void updateAttendee(Attendee attendee) {
	        String query = "UPDATE attendees SET name = ?, email = ? WHERE id = ?";

	        try (Connection con = ConnectionFactory.requestConnection();
	             PreparedStatement stmt = con.prepareStatement(query)) {

	            stmt.setString(1, attendee.getName());
	            stmt.setString(2, attendee.getEmail());
	            stmt.setInt(3, attendee.getId());

	            stmt.executeUpdate();

	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }

}
