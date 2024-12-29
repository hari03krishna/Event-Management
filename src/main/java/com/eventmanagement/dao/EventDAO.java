package com.eventmanagement.dao;

import java.util.List;

import com.eventmanagement.models.Event;

public interface EventDAO {
	 // Method to get all events
    List<Event> getAllEvents();

    // Method to add an event
    void addEvent(Event event);

    // Method to delete an event by ID
    void deleteEvent(int eventId);

    // Method to update an event
    void updateEvent(Event event);

	Event getEventById(int eventId);
}
