<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Filter Properties</title>
</head>
<body>
    <h1>Filter Properties</h1>
    <form action="filterProperties" method="get">
        <label for="minPrice">Min Price:</label>
        <input type="text" id="minPrice" name="minPrice" required><br>
        <label for="maxPrice">Max Price:</label>
        <input type="text" id="maxPrice" name="maxPrice" required><br>
        <label for="minSize">Min Size:</label>
        <input type="text" id="minSize" name="minSize" required><br>
        <label for="maxSize">Max Size:</label>
        <input type="text" id="maxSize" name="maxSize" required><br>
        <label for="amenities">Amenities:</label>
        <input type="text" id="amenities" name="amenities" required><br>
        <input type="submit" value="Filter">
    </form>
    <a href="buyerDashboard">Back to dashboard</a>
    
   
    
</body>
</html>