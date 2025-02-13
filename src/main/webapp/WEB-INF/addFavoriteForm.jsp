<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="ISO-8859-1">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Add Favorite</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #ffffff; /* White background */
            color: #333;
            display: flex;
            justify-content: center; /* Center the body content */
            align-items: flex-start; /* Align items to the top */
            height: 100vh; /* Full viewport height */
            margin: 0;
            overflow: auto; /* Allow scrolling */
            padding-top: 50px; /* Add padding to ensure dropdown has space to open */
        }
        .form-container {
            background-color: #f9f9f9;
            padding: 20px;
            border-radius: 10px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            width: 90%; /* Adjust width to fit within the viewport */
            max-width: 500px; /* Maximum width for the form */
            box-sizing: border-box; /* Include padding in the element's total width and height */
        }
        .form-container h2 {
            text-align: center;
            margin-bottom: 20px;
        }
        .form-container label {
            margin-top: 10px;
            display: block;
            text-align: left;
        }
        .form-container select, .form-container input {
            width: 100%;
            padding: 10px;
            margin-top: 5px;
            border: 1px solid #ddd;
            border-radius: 5px;
            box-sizing: border-box; /* Include padding in the element's total width and height */
        }
        .form-container button {
            margin-top: 20px;
            padding: 10px 20px;
            background-color: #ff69b4; /* HotPink */
            color: white;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            width: 100%; /* Full width button */
        }
        .form-container button:hover {
            background-color: #ff1493; /* DeepPink */
        }
    </style>
</head>
<body>
<div class="form-container">
    <h2>Add Favorite</h2>
    <form action="${pageContext.request.contextPath}/buyer/addFavorite" method="POST">
        <label for="propertyTitle">Property Title:</label>
        <select id="propertyTitle" name="propertyTitle" required>
            <option value="" disabled selected>Choose here</option>
            <c:forEach var="property" items="${favoriteProperties}">
                <option value="${property.title}">${property.title}</option>
            </c:forEach>
        </select>
        
        <button type="submit">Add Favorite</button>
    </form>
</div>
</body>
</html>