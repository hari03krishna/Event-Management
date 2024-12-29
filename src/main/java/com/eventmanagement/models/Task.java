package com.eventmanagement.models;

public class Task {
	 private int id;
	    private String name;
	    private String description;
	    private String assignedTo;
	    private String status;
	    private int eventId;  // ID of the event this task belongs to

	    // Constructor
	    public Task(int id, String name, String description, String assignedTo, String status, int eventId) {
	        this.id = id;
	        this.name = name;
	        this.description = description;
	        this.assignedTo = assignedTo;
	        this.status = status;
	        this.eventId = eventId;
	    }

	    // Getters and Setters
	    public int getId() {
	        return id;
	    }

	    public void setId(int id) {
	        this.id = id;
	    }

	    public String getName() {
	        return name;
	    }

	    public void setName(String name) {
	        this.name = name;
	    }

	    public String getDescription() {
	        return description;
	    }

	    public void setDescription(String description) {
	        this.description = description;
	    }

	    public String getAssignedTo() {
	        return assignedTo;
	    }

	    public void setAssignedTo(String assignedTo) {
	        this.assignedTo = assignedTo;
	    }

	    public String getStatus() {
	        return status;
	    }

	    public void setStatus(String status) {
	        this.status = status;
	    }

	    public int getEventId() {
	        return eventId;
	    }

	    public void setEventId(int eventId) {
	        this.eventId = eventId;
	    }
}
