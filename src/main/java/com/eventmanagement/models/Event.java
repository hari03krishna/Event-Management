package com.eventmanagement.models;

public class Event {
	 private int id;
	    private String name;
	    private String description;
	    private String location;
	    private String date;

	    // Constructor with ID (used when editing an existing event)
	    public Event(int id, String name, String description, String location, String date) {
	        this.id = id;
	        this.name = name;
	        this.description = description;
	        this.location = location;
	        this.date = date;
	    }

	    // Constructor without ID (used when adding a new event)
	    public Event(String name, String description, String location, String date) {
	        this.name = name;
	        this.description = description;
	        this.location = location;
	        this.date = date;
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

	    public String getLocation() {
	        return location;
	    }

	    public void setLocation(String location) {
	        this.location = location;
	    }

	    public String getDate() {
	        return date;
	    }

	    public void setDate(String date) {
	        this.date = date;
	    }

	    @Override
	    public String toString() {
	        return "Event [id=" + id + ", name=" + name + ", description=" + description + ", location=" + location + ", date=" + date + "]";
	    }
}
