# Event Management System

## Overview

This is an Event Management System project, which allows users to register and manage events. The system includes functionalities like user registration, login, and event management. This project uses Java Servlets, JSP, and MySQL for backend development, and it implements features like user authentication and data storage in a relational database.

## Features

- **User Registration**: Users can register by providing their personal details such as name, email, password, phone number, and address.
- **User Login**: Registered users can log in using their credentials.
- **Event Management**: Post-login, users can manage events by creating events, assigning tasks, and tracking progress.

## Technologies Used

- **Java** (Backend)
- **JSP** (Frontend)
- **Servlets** (For handling HTTP requests)
- **MySQL** (Database)
- **HTML/CSS** (For styling the pages)

## Prerequisites

Before running the project, ensure you have the following installed:

- **Java Development Kit (JDK)** 8 or higher
- **Apache Tomcat** (For running the servlets)
- **MySQL** (For database storage)
- **IDE** (e.g., IntelliJ IDEA, Eclipse, etc.)

## Setup Instructions

### 1. Clone the Repository

```bash
git clone https://github.com/yourusername/event-management-system.git
2. Set up the MySQL Database
Create a new database (e.g., event_management).
Run the following SQL to create the users table:
sql
Copy code
CREATE TABLE users (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL,
    phone VARCHAR(15) NOT NULL,
    address TEXT NOT NULL
);

3. Configure Database Connection
In the RegisterServlet.java file, configure the following database connection details:

java
Copy code
String jdbcURL = "jdbc:mysql://localhost:3306/event_management"; // Update with your database URL
String dbUser = "root"; // Update with your MySQL username
String dbPassword = "password"; // Update with your MySQL password

4. Deploy the Application
Deploy the application on Apache Tomcat or any other servlet container.
Place the project files in the webapps directory (if using Tomcat).
5. Start the Application
Once everything is set up:

Access the application by opening your browser and navigating to http://localhost:8080/event-management-system/register.jsp.
You will be able to register as a new user.
Pages
User Registration: Accessible at /register.jsp. Users need to provide personal details to register.
User Login: After registration, users can log in with their credentials.
Dashboard: After a successful login, the user will be redirected to the dashboard where they can manage events.
Usage
User Registration:

Navigate to the registration page (/register.jsp).
Fill in the form with your name, email, password, phone number, and address.
On successful registration, a success message will be displayed, and you will be redirected to the login page.
User Login:

Once registered, navigate to the login page (/login.jsp).
Enter your credentials to log in.
Upon successful login, you will be redirected to the dashboard page (/eventManagement.jsp).
