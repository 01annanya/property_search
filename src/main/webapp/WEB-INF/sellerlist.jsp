<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Seller List</title>
<style>
    body {
        font-family: Arial, sans-serif;
        background-color: #f0f0f0; /* Light grey background */
        color: #333;
        display: flex;
        flex-direction: column; /* Arrange items in a column */
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
        overflow-y: auto; /* Enable vertical scrolling */
        max-height: 80vh; /* Limit the height to 80% of the viewport height */
    }
    .table-container h2 {
        text-align: center;
        margin-bottom: 20px;
        color: #ff69b4; /* HotPink */
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
    .back-link {
        display: block;
        text-align: center;
        margin-top: 20px;
        color: #ff69b4; /* HotPink */
        text-decoration: none;
        font-weight: bold;
    }
    .back-link:hover {
        color: #ff1493; /* DeepPink */
    }
</style>
</head>
<body>
<div class="table-container">
<h2>Seller List</h2>
<table>
<thead>
<tr>
<th>Seller ID</th>
<th>Username</th>
<th>Email</th>
</tr>
</thead>
<tbody>
<c:forEach var="seller" items="${list}">
<tr>
<td>${seller.seller_id}</td>
<td>${seller.username}</td>
<td>${seller.email}</td>
</tr>
</c:forEach>
</tbody>
</table>
</div>
<a href="adminDashboard" class="back-link">Back to Dashboard</a>
</body>
</html>
