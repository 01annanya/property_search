<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Favorite Properties</title>
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
            overflow: auto; /* Allow scrolling */
        }
        .container {
            background-color: #f9f9f9;
            padding: 20px;
            border-radius: 10px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            width: 90%; /* Adjust width to fit within the viewport */
            max-width: 800px; /* Maximum width for the container */
            box-sizing: border-box; /* Include padding in the element's total width and height */
            text-align: center; /* Center the content */
            overflow: auto; /* Enable scrolling within the container */
            max-height: 90vh; /* Limit the height to 90% of the viewport */
        }
        .container h2 {
            margin-bottom: 20px;
        }
        .container table {
            width: 100%;
            border-collapse: collapse;
            margin-bottom: 20px;
        }
        .container table, .container th, .container td {
            border: 1px solid #ddd;
        }
        .container th, .container td {
            padding: 10px;
            text-align: left;
        }
        .container th {
            background-color: #ff69b4; /* HotPink */
            color: white;
        }
        .container a {
            display: inline-block;
            margin-top: 20px;
            padding: 10px 20px;
            background-color: #ff69b4; /* HotPink */
            color: white;
            text-decoration: none;
            border-radius: 5px;
        }
        .container a:hover {
            background-color: #ff1493; /* DeepPink */
        }
    </style>
</head>
<body>
<div class="container">
    <h2>Favorite Properties</h2>
    <c:if test="${not empty favoriteProperties}">
        <table>
            <tr>
                <th>Title</th>
                <th>Description</th>
                <th>Price</th>
                <th>Location</th>
                <th>Square Feet</th>
                <th>Amenities</th>
            </tr>
            <c:forEach var="property" items="${favoriteProperties}">
                <tr>
                    <td>${property.title}</td>
                    <td>${property.description}</td>
                    <td>${property.price}</td>
                    <td>${property.location}</td>
                    <td>${property.squareft}</td>
                    <td>${property.amenities}</td>
                </tr>
            </c:forEach>
        </table>
    </c:if>
    <c:if test="${empty favoriteProperties}">
        <p>No favorite properties found.</p>
    </c:if>
    <a href="buyerDashboard">Back to Dashboard</a>
</div>
</body>
</html>