<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>body {
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
}
</style>
</head>
<body>
<div class="container">
        <h1>Task Tracker</h1>

        <!-- Task List for an Event -->
        <table class="task-table">
            <thead>
                <tr>
                    <th>Task Name</th>
                    <th>Description</th>
                    <th>Assigned To</th>
                    <th>Status</th>
                    <th>Actions</th>
                </tr>
            </thead>
            <tbody>
                <!-- Dynamically populated tasks -->
                <tr>
                    <td>Venue Setup</td>
                    <td>Set up the event space</td>
                    <td>John Doe</td>
                    <td>Pending</td>
                    <td>
                        <button class="btn complete-btn">Complete</button>
                    </td>
                </tr>
                <!-- More tasks would be populated here -->
            </tbody>
        </table>
    </div>

    <script>
        // Add event handler for Complete button
        document.querySelectorAll('.complete-btn').forEach(function(button) {
            button.addEventListener('click', function() {
                // Change task status to "Completed"
                button.closest('tr').querySelector('td:nth-child(4)').textContent = 'Completed';
            });
        });
    </script>
</body>
</html>