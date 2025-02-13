<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="ISO-8859-1">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Success</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #ffffff; /* White background */
            color: #333;
            display: flex;
            justify-content: center; /* Center the body content */
            align-items: center; /* Center the body content vertically */
            height: 100vh; /* Full viewport height */
            margin: 0;
            overflow: hidden; /* Prevent scrollbars */
        }
        .message-container {
            background-color: #f9f9f9;
            padding: 20px;
            border-radius: 10px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            width: 90%; /* Adjust width to fit within the viewport */
            max-width: 500px; /* Maximum width for the form */
            box-sizing: border-box; /* Include padding in the element's total width and height */
            text-align: center;
        }
        .message-container h2 {
            margin-bottom: 20px;
        }
        .message-container .back-to-dashboard {
            display: block;
            text-align: center;
            margin-top: 20px;
            padding: 10px;
            background-color: #ff69b4; /* HotPink */
            color: white;
            text-decoration: none;
            border-radius: 5px;
            cursor: pointer;
        }
        .message-container .back-to-dashboard:hover {
            background-color: #ff1493; /* DeepPink */
        }
    </style>
</head>
<body>
<div class="message-container">
    <h2>Success</h2>
    <c:if test="${not empty successMessage}">
        <p>${successMessage}</p>
    </c:if>
    <a href="adminDashboard" class="back-to-dashboard">Back to Dashboard</a>
</div>
</body>
</html>