<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="ISO-8859-1">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Favorite Result</title>
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
        .container {
            background-color: #f9f9f9;
            padding: 20px;
            border-radius: 10px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            width: 90%; /* Adjust width to fit within the viewport */
            max-width: 500px; /* Maximum width for the container */
            box-sizing: border-box; /* Include padding in the element's total width and height */
            text-align: center; /* Center the content */
        }
        .container h2 {
            margin-bottom: 20px;
        }
        .container p {
            margin: 10px 0;
        }
        .tabs {
            display: flex;
            justify-content: space-around;
            background-color: #f1f1f1;
            padding: 10px;
            margin-top: 20px;
            border-radius: 5px;
        }
        .tabs a {
            padding: 10px 20px;
            text-decoration: none;
            color: #007bff; /* Assuming this is the color used in buyerDashboard UI */
            border: 1px solid #ccc;
            border-radius: 4px;
        }
        .tabs a:hover {
            background-color: #ddd;
        }
        .tabs a.active {
            background-color: #007bff;
            color: white;
        }
        .footer {
            text-align: center;
            margin-top: 20px;
            font-size: 12px;
            color: #888;
        }
    </style>
</head>
<body>
<div class="container">
    <h2>Favorite Result</h2>
    <p>${isAdded ? 'The property has been successfully added to your favorites!' : 'There was an error adding the property to your favorites. Please try again.'}</p>
    
    <div class="tabs">
        <a href="favoriteProperties?username=${param.buyerUsername}">View Favorite Properties</a>
        <a href="buyerDashboard">Back to Dashboard</a>
    </div>
    
</div>
</body>
</html>