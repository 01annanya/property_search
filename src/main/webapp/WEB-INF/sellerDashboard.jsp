<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Seller Dashboard</title>
<style>
    body {
        font-family: Arial, sans-serif;
        background-attachment: fixed; /* Fix the background image */
        color: #333;
    }
    header {
        background-color: #ff69b4; /* HotPink */
        padding: 20px;
        text-align: center;
        color: white;
        position: relative;
    }
    nav {
        background-color: #ff1493; /* DeepPink */
        padding: 10px;
        display: flex;
        justify-content: center; /* Center the navigation bar */
    }
    nav ul {
        list-style-type: none;
        padding: 0;
        display: flex; /* Use flexbox for the ul */
        justify-content: center; /* Center the list items */
    }
    nav ul li {
        margin-right: 10px;
        position: relative; /* For dropdown positioning */
    }
    nav ul li a {
        color: white;
        text-decoration: none;
        padding: 5px 10px;
        background-color: #ff69b4; /* HotPink */
        border-radius: 5px;
        display: block; /* Ensure the link takes up the full space */
    }
    nav ul li a:hover {
        background-color: #ff1493; /* DeepPink */
    }
    nav ul li .dropdown {
        display: none;
        position: absolute;
        background-color: #ff69b4; /* HotPink */
        border-radius: 5px;
        top: 100%;
        left: 0;
        min-width: 200px;
        z-index: 1;
    }
    nav ul li:hover .dropdown {
        display: block;
    }
    nav ul li .dropdown a {
        padding: 10px;
        display: block;
    }
    section {
        padding: 20px;
        display: flex;
        justify-content: center; /* Center the section content */
    }
    .card {
        background-color: white;
        padding: 20px;
        border-radius: 10px;
        box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
        max-width: 600px;
        width: 100%;
        text-align: center;
    }
    .form-container {
        margin-top: 20px;
        text-align: left; /* Align form content to the left */
    }
    .form-container form {
        display: flex;
        flex-direction: column;
        align-items: flex-start;
    }
    .form-container label {
        margin-top: 10px;
    }
    .form-container input, .form-container textarea {
        width: 100%;
        padding: 10px;
        margin-top: 5px;
        border: 1px solid #ddd;
        border-radius: 5px;
    }
    .form-container button {
        margin-top: 20px;
        padding: 10px 20px;
        background-color: #ff69b4; /* HotPink */
        color: white;
        border: none;
        border-radius: 5px;
        cursor: pointer;
    }
    .form-container button:hover {
        background-color: #ff1493; /* DeepPink */
    }
    footer {
        background-color: #ffffff; /* White background */
        padding: 10px;
        text-align: center;
        color: #333;
        position: fixed;
        width: 100%;
        bottom: 0;
    }
    .social-media {
        margin-top: 10px;
    }
    .social-media a {
        margin: 0 10px;
        color: #ff69b4; /* Reddish-pink color */
        text-decoration: none;
    }
    .social-media a img {
        vertical-align: middle;
        margin-right: 5px;
    }
    .profile-container {
        position: absolute;
        top: 20px;
        right: 20px;
        text-align: center;
    }
    .profile-container img {
        width: 40px; /* Adjust the size as needed */
        height: 40px; /* Adjust the size as needed */
        border-radius: 50%;
    }
    .logout {
        margin-top: 10px;
        background-color: #ff69b4; /* HotPink */
        color: white;
        padding: 10px;
        border-radius: 5px;
        text-decoration: none;
        display: inline-block;
    }
    .logout:hover {
        background-color: #ff1493; /* DeepPink */
    }
</style>
</head>
<body>
<header>
    <h1>Seller Dashboard</h1>
    <div class="profile-container">
        <a href="sellerProfile"><img src="https://th.bing.com/th/id/OIP.nMdQ_VCIvfsX9k5fy-4vzQHaJ9?w=141&h=189&c=7&r=0&o=5&dpr=1.5&pid=1.7" alt="Profile" /></a>
        <a href="logout" class="logout">Logout</a>
    </div>
</header>
<nav>
    <ul>
        <li><a href="sellerInquiries">Respond to Inquiries</a></li>
        <li><a href="sellerPendingVisits">Visits lists</a></li>
        <li><a href="myResponses">My Responses</a></li>
        <li>
             <a href="#">Property Management</a>
            <div class="dropdown">
                <a href="${pageContext.request.contextPath}/seller/getAllProperties">View All Properties</a>
                <a href="${pageContext.request.contextPath}/seller/addNewPropertyForm">Add Property</a>
            </div>
        </li>
    </ul>
</nav>
<section>
    <div class="card">
        <h2>Welcome to Seller Dashboard</h2>
        <p>Here we deal with customer inquiries and manage properties.</p>
    </div>
</section>
<footer>
    <p>&copy; 2024 Apna Ghar. All rights reserved.</p>
    <p>Your cozy corner on the web!</p>
</footer>
</body>
</html>