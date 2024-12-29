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
            background: url('https://www.amusephiladelphia.com/wp-content/uploads/2018/08/34735177654_35eb166e10_k.jpg') no-repeat center center/cover;
        }

        .container {
            max-width: 800px;
            margin: 50px auto;
            padding: 20px;
            background-color: #fff;
            box-shadow: 0px 0px 10px rgba(0, 0, 0, 0.1);
        }

        h1 {
            text-align: center;
            margin-bottom: 30px;
        }

        .form-group {
            margin-bottom: 20px;
        }

        label {
            display: block;
            font-weight: bold;
        }

        input, textarea {
            width: 100%;
            padding: 8px;
            margin-top: 5px;
            border: 1px solid #ddd;
            border-radius: 4px;
            font-size: 16px;
        }

        button {
            padding: 10px 20px;
            background-color: #4caf50;
            color: white;
            font-size: 16px;
            border-radius: 5px;
            border: none;
            cursor: pointer;
            display: block;
            margin: 20px auto;
        }

        button:hover {
            background-color: #45a049;
        }

        .back-btn {
            padding: 10px 20px;
            background-color: #e53935;
            color: white;
            font-size: 16px;
            border-radius: 5px;
            text-decoration: none;
            display: inline-block;
            text-align: center;
            width: 200px;
            margin: 20px auto;
        }

        .back-btn:hover {
            background-color: #d32f2f;
        }
    </style>
</head>

<body>
 <div class="container">
        <h1>Add New Event</h1>

        <!-- Event Form -->
        <form action="event" method="POST">
            <div class="form-group">
                <label for="name">Event Name:</label>
                <input type="text" id="name" name="name" required placeholder="Enter event name" />
            </div>

            <div class="form-group">
                <label for="description">Description:</label>
                <textarea id="description" name="description" required placeholder="Enter event description"></textarea>
            </div>

            <div class="form-group">
                <label for="location">Location:</label>
                <input type="text" id="location" name="location" required placeholder="Enter event location" />
            </div>

            <div class="form-group">
                <label for="date">Date:</label>
                <input type="date" id="date" name="date" required />
            </div>

            <button type="submit">Add Event</button>
        </form>

        <a href="event" class="back-btn">Back to Event List</a>
    </div>
</body>
</html>