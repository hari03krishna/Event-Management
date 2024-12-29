<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>User Registration</title>
    <style>
        /* Apply background image to the body */
        body {
            position: relative;
            width: 100%;
            height: 100vh;
            background: url('https://www.amusephiladelphia.com/wp-content/uploads/2018/08/34735177654_35eb166e10_k.jpg') no-repeat center center/cover;
            display: flex;
            justify-content: center;
            align-items: center;
            color: #fff;
            font-family: Arial, sans-serif;
        }

        /* Style for the registration form */
        form {
            background-color: rgba(0, 0, 0, 0.7);  /* Dark background for the form */
            padding: 30px;
            border-radius: 10px;
            width: 400px;
            text-align: center;
        }

        form label {
            display: block;
            margin: 10px 0 5px;
            font-size: 18px;
        }

        form input,
        form textarea {
            width: 100%;
            padding: 10px;
            font-size: 16px;
            margin-bottom: 20px;
            border: 1px solid #ddd;
            border-radius: 5px;
            background-color: #fff;
        }

        form input[type="password"] {
            margin-bottom: 10px;
        }

        form button {
            padding: 12px 20px;
            font-size: 18px;
            background-color: #007bff;
            color: white;
            border: none;
            border-radius: 5px;
            cursor: pointer;
        }

        form button:hover {
            background-color: #0056b3;
        }

        /* Display error and success messages */
        p {
            color: red;
        }

        .success {
            color: green;
        }
    </style>
</head>
<body>
    <h2>User Registration</h2>
    <form action="registerServlet" method="POST">
        <label for="name">Full Name:</label>
        <input type="text" id="name" name="name" required><br><br>

        <label for="email">Email:</label>
        <input type="email" id="email" name="email" required><br><br>

        <label for="password">Password:</label>
        <input type="password" id="password" name="password" required><br><br>

        <label for="phone">Phone Number:</label>
        <input type="text" id="phone" name="phone" required><br><br>

        <label for="address">Address:</label>
        <textarea id="address" name="address" required></textarea><br><br>

        <button type="submit">Register</button>
    </form>

    <%-- Show success or error message --%>
    <%
        String successMessage = (String) request.getAttribute("successMessage");
        String errorMessage = (String) request.getAttribute("errorMessage");

        if (successMessage != null) {
            out.println("<p class='success'>" + successMessage + "</p>");
        } else if (errorMessage != null) {
            out.println("<p>" + errorMessage + "</p>");
        }
    %>
</body>
</html>
