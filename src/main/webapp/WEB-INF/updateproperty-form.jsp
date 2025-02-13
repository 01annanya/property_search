<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<title>Update Property</title>
<style>
    body {
        font-family: Arial, sans-serif;
        background-color: #f0f0f0;
        color: #333;
        display: flex;
        flex-direction: column;
        justify-content: center;
        align-items: center;
        height: 100vh;
        margin: 0;
        overflow: hidden;
    }
    .form-container {
        background-color: #ffffff;
        padding: 20px;
        border-radius: 10px;
        box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
        width: 90%;
        max-width: 400px;
        box-sizing: border-box;
    }
    .form-container h2 {
        text-align: center;
        margin-bottom: 20px;
        color: #ff69b4;
    }
    .form-container label {
        display: block;
        margin-top: 10px;
        font-weight: bold;
    }
    .form-container input[type="text"], .form-container input[type="number"] {
        width: 100%;
        padding: 10px;
        margin-top: 5px;
        border: 1px solid #ccc;
        border-radius: 5px;
        box-sizing: border-box;
    }
    .form-container input[type="submit"], .form-container input[type="reset"] {
        margin-top: 20px;
        padding: 10px 15px;
        background-color: #ff69b4;
        color: white;
        border: none;
        border-radius: 5px;
        cursor: pointer;
        width: 100%;
        font-size: 14px;
    }
    .form-container input[type="submit"]:hover, .form-container input[type="reset"]:hover {
        background-color: #ff1493;
    }
    .back-button {
        margin-top: 20px;
        padding: 8px 12px;
        background-color: #ff69b4;
        color: white;
        border: none;
        border-radius: 5px;
        cursor: pointer;
        width: 80%;
        max-width: 300px;
        font-size: 14px;
        text-align: center;
        box-sizing: border-box;
    }
    .back-button:hover {
        background-color: #ff1493;
    }
</style>
<script>
    window.onload = function() {
        var successMessage = "${successMessage}";
        var errorMessage = "${errorMessage}";
        if (successMessage && successMessage.trim() !== "") {
            alert(successMessage);
        } else if (errorMessage && errorMessage.trim() !== "") {
            alert(errorMessage);
        }
    }
</script>
</head>
<body>
<div class="form-container">
    <h2>Update Property</h2>
    <form action="${pageContext.request.contextPath}/seller/updateProperty" method="post">
        <input type="hidden" id="property_id" name="property_id" value="${property.propertyId}" required>
        <label for="price">Price:</label>
        <input type="number" id="price" name="price" value="${property.price}" required aria-label="Property Price">
        <input type="submit" value="Update Property">
        <input type="reset" value="Reset">
    </form>
</div>
<button class="back-button" onclick="window.location.href='${pageContext.request.contextPath}/seller/getAllProperties'">Back to Dashboard</button>
</body>
</html>