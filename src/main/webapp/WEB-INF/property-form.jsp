<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add New Property Form</title>
<style>
    body {
        font-family: Arial, sans-serif;
        background-color: #f0f0f0; /* Light grey background */
        color: #333;
        display: flex;
        justify-content: center; /* Center the body content */
        align-items: center; /* Center the body content vertically */
        height: 100vh; /* Full viewport height */
        margin: 0;
        overflow: hidden; /* Prevent scrollbars */
    }
    .form-container {
        background-color: #ffffff; /* White background */
        padding: 20px;
        border-radius: 10px;
        box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
        width: 90%; /* Adjust width to fit within the viewport */
        max-width: 500px; /* Maximum width for the form */
        box-sizing: border-box; /* Include padding in the element's total width and height */
    }
    .form-container h2 {
        text-align: center;
        margin-bottom: 20px;
        color: #ff69b4; /* HotPink */
    }
    .form-container table {
        width: 100%;
    }
    .form-container td {
        padding: 5px;
    }
    .form-container input[type="text"],
    .form-container input[type="number"],
    .form-container select {
        width: 100%;
        padding: 8px;
        margin-top: 3px;
        border: 1px solid #ccc;
        border-radius: 5px;
        box-sizing: border-box; /* Include padding in the element's total width and height */
    }
    .form-container input[type="submit"],
    .form-container input[type="reset"] {
        margin-top: 15px;
        padding: 10px 15px;
        background-color: #ff69b4; /* HotPink */
        color: white;
        border: none;
        border-radius: 5px;
        cursor: pointer;
        width: 48%; /* Adjust width for buttons */
        font-size: 14px;
    }
    .form-container input[type="submit"]:hover,
    .form-container input[type="reset"]:hover {
        background-color: #ff1493; /* DeepPink */
    }
    .form-container .button-group {
        display: flex;
        justify-content: space-between;
    }
    .back-to-dashboard {
        display: block;
        text-align: center;
        margin-top: 20px;
        font-weight: bold;
        color: #ff69b4;
        text-decoration: none;
    }
    .back-to-dashboard:hover {
        color: #ff1493;
    }
</style>
<script>
    window.onload = function() {
        const urlParams = new URLSearchParams(window.location.search);
        if (urlParams.get('success') === 'true') {
            alert('Property added successfully.');
        }
    }
</script>
</head>
<body>
<div class="form-container">
<h2>Add New Property</h2>
<form action="addNewProperty" method="post">
<table>
<tr>
<td>Title</td>
<td><input type="text" name="title" required/></td>
</tr>
<tr>
<td>Description</td>
<td><input type="text" name="description" required/></td>
</tr>
<tr>
<td>Price</td>
<td><input type="number" step="0.01" name="price" required/></td>
</tr>
<tr>
<td>Location</td>
<td><input type="text" name="location" required/></td>
</tr>
<tr>
<td>Square Feet</td>
<td><input type="text" name="squareft" required/></td>
</tr>
<tr>
<td>Amenities</td>
<td><input type="text" name="amenities" required/></td>
</tr>
<tr>
<td colspan="2" class="button-group">
<input type="submit" value="Enter"/>
<input type="reset" value="Clear"/>
</td>
</tr>                        
</table>
</form>
<a href="sellerDashboard" class="back-to-dashboard">Back to Dashboard</a>
</div>
</body>
</html>