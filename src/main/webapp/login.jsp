<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
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
    justify-content: center;
    align-items: center;
}

/* Background image container */
.background-image {
    position: relative;
    width: 100%;
    height: 100vh;
    background: url('https://www.amusephiladelphia.com/wp-content/uploads/2018/08/34735177654_35eb166e10_k.jpg') no-repeat center center/cover;
    display: flex;
    justify-content: center;
    align-items: center;
    color: #fff;
}

/* Header with back link */
header {
    position: absolute;
    top: 20px;
    left: 20px;
}

.login-link {
    color: #fff;
    text-decoration: none;
    font-size: 16px;
    font-weight: bold;
    background-color: rgba(0, 0, 0, 0.6);
    padding: 10px 20px;
    border-radius: 5px;
}

.login-link:hover {
    background-color: rgba(0, 0, 0, 0.8);
}

/* Login form container */
.login-content {
    background-color: rgba(0, 0, 0, 0.7); /* Slight dark overlay */
    padding: 30px;
    border-radius: 10px;
    max-width: 400px;
    width: 100%;
    text-align: center;
}

.login-content h1 {
    font-size: 36px;
    margin-bottom: 20px;
    color: #fff;
}

.input-group {
    margin-bottom: 20px;
    text-align: left;
}

.input-group label {
    font-size: 18px;
    color: #fff;
    display: block;
    margin-bottom: 5px;
}

.input-group input {
    width: 100%;
    padding: 10px;
    font-size: 16px;
    border: 1px solid #ddd;
    border-radius: 5px;
    background-color: #fff;
}

.input-group input:focus {
    outline: none;
    border-color: #007BFF;
}

/* Submit Button */
.btn {
    background-color: #007BFF;
    color: white;
    padding: 15px 25px;
    font-size: 18px;
    border-radius: 5px;
    border: none;
    cursor: pointer;
    width: 100%;
}

.btn:hover {
    background-color: #0056b3;
}

/* Sign up link */
.signup-link {
    margin-top: 15px;
    color: #fff;
}

.signup-link a {
    color: #007BFF;
    text-decoration: none;
}

.signup-link a:hover {
    text-decoration: underline;
}
</style>
</head>
<body>
<div class="background-image">
        <header>
            <a href="FrontPage.html" class="login-link">Back to Home</a>
        </header>

        <div class="login-content">
            <h1>Login to Event Management</h1>
            <form action="loginServlet" method="POST">
                <div class="input-group">
                    <label for="email">Email:</label>
                    <input type="email" id="email" name="email" required placeholder="Enter your email">
                </div>
                <div class="input-group">
                    <label for="password">Password:</label>
                    <input type="password" id="password" name="password" required placeholder="Enter your password">
                </div>
                <button type="submit" class="btn">Login</button>
            </form>
            
        </div>
    </div>

</body>
</html>