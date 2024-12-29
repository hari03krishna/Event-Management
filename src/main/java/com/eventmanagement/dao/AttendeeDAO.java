package com.eventmanagement.dao;

import java.util.List;

import com.eventmanagement.models.Attendee;

public interface AttendeeDAO {
	List<Attendee> getAllAttendees();  // Get a list of all attendees
    void addAttendee(Attendee attendee);  // Add a new attendee
    void deleteAttendee(int attendeeId);  // Delete an attendee by ID
    Attendee getAttendeeById(int attendeeId);  // Get an attendee by ID
    void updateAttendee(Attendee attendee);  // Update an attendee
}
