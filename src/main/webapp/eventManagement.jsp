<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
body {
    font-family: Arial, sans-serif;
    background-color: #f4f4f9;
    margin: 0;
    padding: 0;
    background:url('https://www.amusephiladelphia.com/wp-content/uploads/2018/08/34735177654_35eb166e10_k.jpg') no-repeat center center/cover;
}

.container {
    max-width: 1000px;
    margin: 50px auto;
    padding: 20px;
    background-color: #fff;
    box-shadow: 0px 0px 10px rgba(0, 0, 0, 0.1);
}

h1 {
    text-align: center;
    margin-bottom: 30px;
}

.event-table {
    width: 100%;
    border-collapse: collapse;
    margin-bottom: 20px;
}

.event-table th, .event-table td {
    padding: 12px;
    text-align: center;
    border: 1px solid #ddd;
}

.event-table th {
    background-color: #f0f0f0;
}

.btn {
    padding: 8px 15px;
    border: none;
    border-radius: 5px;
    cursor: pointer;
}

.edit-btn {
    background-color: #ff9f00;
    color: #fff;
}

.delete-btn {
    background-color: #e53935;
    color: #fff;
}

.add-btn {
    padding: 10px 20px;
    background-color: #4caf50;
    color: white;
    font-size: 16px;
    border-radius: 5px;
    margin-top: 20px;
    display: block;
    margin: 20px auto;
    cursor: pointer;
}

.add-btn:hover {
    background-color: #45a049;
}</style>
</head>
<body>
 <div class="container">
        <h1>Event Management</h1>

        <!-- Event List -->
        <table class="event-table">
            <thead>
                <tr>
                    <th>Name</th>
                    <th>Description</th>
                    <th>Location</th>
                    <th>Date</th>
                    <th>Actions</th>
                </tr>
            </thead>
            <tbody>
                <!-- Dynamically populated events -->
                <tr>
                    <td>Annual Conference</td>
                    <td>A conference for industry leaders.</td>
                    <td>New York Convention Center</td>
                    <td>2024-05-05</td>
                    <td>
                        <button class="btn edit-btn">Edit</button>
                        <button class="btn delete-btn">Delete</button>
                    </td>
                </tr>
                <!-- More events would be populated here -->
            </tbody>
        </table>

        <!-- Add New Event -->
        <button class="btn add-btn">Add New Event</button>
    </div>

    <script>
        // Add event handler for Add Event button
        document.querySelector('.add-btn').addEventListener('click', function() {
            window.location.href = "addEvent.jsp"; // Redirect to add event page
        });

        // Add event handler for Edit button
        document.querySelectorAll('.edit-btn').forEach(function(button) {
            button.addEventListener('click', function() {
                alert('Edit event functionality will be here');
            });
        });

        // Add event handler for Delete button
        document.querySelectorAll('.delete-btn').forEach(function(button) {
            button.addEventListener('click', function() {
                if (confirm('Are you sure you want to delete this event?')) {
                    alert('Event deleted');
                    // Call backend logic to delete the event
                }
            });
        });
    </script>
</body>
</html>