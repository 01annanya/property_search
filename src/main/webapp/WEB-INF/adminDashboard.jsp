<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>AdminDashboard</title>
<style>
body {
    font-family: Arial, sans-serif;
    background-color: #ffffff; /* White background */
    color: #333;
    margin: 0; /* Remove default margin */
    padding: 0; /* Remove default padding */
}
header {
    background-color: #ff69b4; /* HotPink */
    padding: 10px; /* Reduce padding */
    text-align: center;
    color: white;
    position: relative;
}
nav {
    background-color: #ff1493; /* DeepPink */
    padding: 5px; /* Reduce padding */
    text-align: center; /* Center the navigation bar */
}
nav ul {
    list-style-type: none;
    padding: 0;
    display: inline-block; /* Make the ul inline-block */
    margin: 0; /* Remove default margin */
}
nav ul li {
    display: inline-block; /* Change to inline-block for better alignment */
    margin-right: 5px; /* Reduce margin */
    position: relative; /* For dropdown positioning */
}
nav ul li a {
    color: white;
    text-decoration: none;
    padding: 5px; /* Reduce padding */
    background-color: #ff69b4; /* HotPink */
    border-radius: 5px;
    display: block; /* Ensure the link takes up the full space */
}
nav ul li a:hover {
    background-color: #ff1493; /* DeepPink */
}
nav ul li ul {
    display: none; /* Hide dropdowns initially */
    position: absolute;
    top: 100%; /* Position dropdown below the parent item */
    left: 0;
    background-color: #ff69b4; /* HotPink */
    padding: 5px; /* Reduce padding */
    border-radius: 5px;
    list-style-type: none;
    min-width: 150px; /* Reduce minimum width */
    box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1); /* Add a shadow for better visibility */
    z-index: 1000; /* Ensure dropdown appears above other content */
}
nav ul li:hover ul {
    display: block; /* Show dropdown on hover */
}
nav ul li ul li {
    display: block;
    margin: 5px 0;
}
nav ul li ul li a {
    padding: 5px; /* Reduce padding */
    background-color: #ff69b4; /* HotPink */
    border-radius: 5px;
    white-space: nowrap; /* Prevent text from wrapping */
}
nav ul li ul li a:hover {
    background-color: #ff1493; /* DeepPink */
}
section {
    padding: 10px; /* Reduce padding */
    text-align: center; /* Center the content */
}
footer {
    background-color: #ffffff; /* White background */
    padding: 5px; /* Reduce padding */
    text-align: center;
    color: #333;
    position: fixed;
    width: 100%;
    bottom: 0;
}
footer img {
    max-height: 30px; /* Adjust the height */
    vertical-align: middle;
    margin-right: 10px;
}
.tab {
    display: none;
}
.tab-content {
    display: none;
    text-align: center;
}
.tab-content.active {
    display: block;
}
.profile-icon {
    position: absolute;
    top: 10px;
    right: 10px;
    text-align: center;
}
.profile-icon img {
    width: 40px; /* Adjust the size as needed */
    height: 40px; /* Adjust the size as needed */
    border-radius: 50%;
}
.logout {
    position: absolute;
    top: 60px; /* Position below the profile picture */
    right: 10px;
    background-color: #ff69b4; /* HotPink */
    color: white;
    padding: 10px;
    border-radius: 5px;
    text-decoration: none;
}
.logout:hover {
    background-color: #ff1493; /* DeepPink */
}
</style>
<script>
function showTab(tabId) {
    var tabs = document.getElementsByClassName('tab-content');
    for (var i = 0; i < tabs.length; i++) {
        tabs[i].classList.remove('active');
    }
    document.getElementById(tabId).classList.add('active');
}
</script>
</head>
<body>
<header>
<h1>Welcome to the AdminDashboard</h1>
<div class="profile-icon">
<a href="adminProfile"><img src="https://th.bing.com/th/id/OIP.nMdQ_VCIvfsX9k5fy-4vzQHaJ9?w=141&h=189&c=7&r=0&o=5&dpr=1.5&pid=1.7" alt="Profile" /></a>
</div>
<a href="logout" class="logout">Logout</a>
</header>
<nav>
<ul>
<li><a href="#" onclick="showTab('buyers')">Manage Buyers</a>
<ul>
<li><a href="getAllBuyers">View All Buyers</a></li>
<li><a href="getBuyerByIdForm">Get Buyer by ID</a></li>
</ul>
</li>
<li><a href="#" onclick="showTab('sellers')">Manage Sellers</a>
<ul>
<li><a href="getAllSellers">View All Sellers</a></li>
<li><a href="getSellerByIdForm">Get Seller by ID</a></li>
</ul>
</li>
<li><a href="#" onclick="showTab('properties')">Manage Properties</a>
<ul>
<li><a href="getAllProperties">View All Properties</a></li>
<li><a href="getPropertyByIdForm">Get Property by ID</a></li>
</ul>
</li>
</ul>
</nav>
<section>
<img src="https://i2-prod.somersetlive.co.uk/news/somerset-news/article492210.ece/ALTERNATES/s615b/GettyImages-495623874.jpg" style="width: 450px; height: auto; margin: 70px 0;">
<div id="buyers" class="tab-content"></div>
<div id="sellers" class="tab-content"></div>
<div id="properties" class="tab-content"></div>
</section>
<footer>
<p>&copy; 2024 Apna Ghar. All rights reserved.</p>
<p>Your cozy corner on the web!</p>
</footer>
</body>
</html>