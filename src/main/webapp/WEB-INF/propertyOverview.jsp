<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<title>Property Overview</title>
<style>
    body {
        font-family: Arial, sans-serif;
        background-color: #f0f0f0; /* Light grey background */
        color: #333;
        display: flex;
        flex-direction: column;
        justify-content: center; /* Center the body content */
        align-items: center; /* Center the body content vertically */
        height: 100vh; /* Full viewport height */
        margin: 0;
        overflow: hidden; /* Prevent scrollbars */
    }
    .table-container {
        background-color: #ffffff; /* White background */
        padding: 20px;
        border-radius: 10px;
        box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
        width: 90%; /* Adjust width to fit within the viewport */
        max-width: 800px; /* Maximum width for the table */
        box-sizing: border-box; /* Include padding in the element's total width and height */
    }
    .table-container h2 {
        text-align: center;
        margin-bottom: 20px;
        color: #ff69b4; /* HotPink */
    }
    .table-wrapper {
        max-height: 400px; /* Set a fixed height for the table container */
        overflow: auto; /* Enable scrolling if content exceeds the height */
    }
    table {
        width: 100%;
        border-collapse: collapse;
        margin: 20px 0;
    }
    table, th, td {
        border: 1px solid #ddd;
    }
    th, td {
        padding: 10px;
        text-align: left;
    }
    th {
        background-color: #f2f2f2;
    }
    tr:nth-child(even) {
        background-color: #f9f9f9;
    }
    .button-container {
        margin-top: 20px;
        text-align: center;
    }
    .button-container a {
        display: inline-block;
        padding: 10px 20px;
        background-color: #ff69b4; /* HotPink */
        color: #ffffff;
        text-decoration: none;
        border-radius: 5px;
        box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
    }
    .button-container a:hover {
        background-color: #ff1493; /* DeepPink */
    }
</style>
</head>
<body>
<div class="table-container">
<h2>Property List</h2>
<div class="table-wrapper">
<table>
<thead>
<tr>
<th>Property ID</th>
<th>Title</th>
<th>Description</th>
<th>Price</th>
<th>Location</th>
<th>Square Ft</th>
<th>Amenities</th>
<th>SellerID</th>
</tr>
</thead>
<tbody>
<c:forEach var="property" items="${list}">
<tr>
<td>${property.propertyId}</td>
<td>${property.title}</td>
<td>${property.description}</td>
<td>${property.price}</td>
<td>${property.location}</td>
<td>${property.squareft}</td>
<td>${property.amenities}</td>
<td>${property.sellerId}</td>
</tr>
</c:forEach>
</tbody>
</table>
</div>
</div>
<div class="button-container">
<a href="adminDashboard">Back to Dashboard</a>
</div>
</body>
</html>
