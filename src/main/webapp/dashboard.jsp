<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Event Management Dashboard</title>
    <style>
        /* Basic reset */
        * {
            margin: 0;
            padding: 0;
            box-sizing: border-box;
        }

        /* Body and background */
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            height: 100vh;
            display: flex;
            flex-direction: column;
            justify-content: flex-start;
            align-items: center;
            padding: 30px 0;
             background:url('https://www.amusephiladelphia.com/wp-content/uploads/2018/08/34735177654_35eb166e10_k.jpg') no-repeat center center/cover;
        }

        /* Container for the images and buttons */
        .content-container {
            width: 90%;
            max-width: 1200px;
            display: flex;
            flex-direction: column;
            justify-content: center;
            align-items: center;
            text-align: center;
        }

        /* Image section */
        .image-section {
            width: 100%;
            height: 300px;
            background: url('https://example.com/your-image.jpg') no-repeat center center/cover;
            display: flex;
            justify-content: center;
            align-items: center;
            color: white;
            font-size: 36px;
            font-weight: bold;
            margin-bottom: 40px;
        }

        .image-section h1 {
            background-color: rgba(0, 0, 0, 0.5); /* Dark overlay to make text readable */
            padding: 20px;
            border-radius: 5px;
        }

        /* Buttons section */
        .buttons-container {
            display: flex;
            justify-content: space-around;
            width: 100%;
        }

        .btn {
            background-color: #007BFF;
            color: white;
            padding: 15px 25px;
            font-size: 18px;
            border-radius: 5px;
            text-decoration: none;
            width: 30%;
            text-align: center;
            margin: 0 10px;
        }

        .btn:hover {
            background-color: #0056b3;
        }

        /* Additional styling */
        header {
            position: absolute;
            top: 20px;
            left: 20px;
        }

        .logout-link {
            color: #fff;
            text-decoration: none;
            font-size: 16px;
            font-weight: bold;
            background-color: rgba(0, 0, 0, 0.6);
            padding: 10px 20px;
            border-radius: 5px;
        }

        .logout-link:hover {
            background-color: rgba(0, 0, 0, 0.8);
        }
    </style>
</head>
<body>
    <header>
        <a href="logout.jsp" class="logout-link">Logout</a>
    </header>

    <div class="content-container">

        <!-- Image Section -->
        <div class="image-section">
            <h1>Welcome to the Event Management Dashboard</h1>
        </div>

        <!-- Buttons Section -->
        <div class="buttons-container">
            <a href="createEvent.jsp" class="btn">Create an Event</a>
            <a href="assignTask.jsp" class="btn">Assign a Task</a>
            <a href="trackProgress.jsp" class="btn">Track Progress</a>
        </div>

    </div>

</body>
</html>
