<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<title>Get Seller by ID</title>
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
        }
        .form-container {
            background-color: #ffffff; /* White background */
            padding: 20px;
            border-radius: 10px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
            width: 90%; /* Adjust width to fit within the viewport */
            max-width: 400px; /* Maximum width for the form */
            box-sizing: border-box; /* Include padding in the element's total width and height */
            text-align: center;
            position: relative; /* For positioning the back link */
        }
        .form-container h2 {
            color: #ff69b4; /* HotPink */
            margin-bottom: 20px;
        }
        .form-container label {
            display: block;
            margin-bottom: 5px;
            font-weight: bold;
        }
        .form-container input[type="text"] {
            width: 100%;
            padding: 8px;
            margin-bottom: 10px;
            border: 1px solid #ddd;
            border-radius: 5px;
        }
        .form-container input[type="submit"] {
            background-color: #ff69b4; /* HotPink */
            color: white;
            border: none;
            padding: 10px 20px;
            border-radius: 5px;
            cursor: pointer;
        }
        .form-container input[type="submit"]:hover {
            background-color: #ff1493; /* DeepPink */
        }
        .back-link {
            display: block;
            text-align: center;
            margin-top: 20px;
            color: #ff69b4; /* HotPink */
            text-decoration: none;
            font-weight: bold;
            position: absolute;
            bottom: -40px; /* Position below the form container */
            left: 50%;
            transform: translateX(-50%);
        }
        .back-link:hover {
            color: #ff1493; /* DeepPink */
        }
</style>
</head>
<body>
<div class="form-container">
<h2>Get Seller by ID</h2>
<form action="getSellerbySellerId" method="get">
<label for="seller_id">Seller ID:</label>
<input type="text" id="seller_id" name="seller_id" required><br><br>
<input type="submit" value="Get Seller">
</form>
<a href="adminDashboard" class="back-link">Back to Dashboard</a>
</div>
</body>
</html>