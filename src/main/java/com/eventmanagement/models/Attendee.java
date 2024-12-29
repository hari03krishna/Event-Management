package com.eventmanagement.models;

public class Attendee {
	 private int id;
	    private String name;
	    private String email;

	    // Constructor with all fields
	    public Attendee(int id, String name, String email) {
	        this.id = id;
	        this.name = name;
	        this.email = email;
	    }

	    public Attendee(String name2, String email2) {
			// TODO Auto-generated constructor stub
		}

		// Getter and Setter methods
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

	    public String getEmail() {
	        return email;
	    }

	    public void setEmail(String email) {
	        this.email = email;
	    }

		public void setAssignedEvent(Event event) {
			// TODO Auto-generated method stub
			
		}
}
