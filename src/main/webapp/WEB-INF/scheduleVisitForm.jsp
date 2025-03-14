<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="ISO-8859-1">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Schedule Visit</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #ffffff; /* White background */
            color: #333;
            display: flex;
            justify-content: center; /* Center the body content horizontally */
            align-items: center; /* Center the body content vertically */
            height: 100vh; /* Full viewport height */
            margin: 0;
        }
        .form-container {
            background-color: #f9f9f9;
            padding: 20px;
            border-radius: 10px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            width: 100%; /* Full width */
            max-width: 400px; /* Maximum width for the form */
            box-sizing: border-box; /* Include padding in the element's total width and height */
            margin: 20px; /* Add some margin for spacing */
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
        .form-container input, .form-container select {
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
        .form-container a {
            display: block;
            text-align: center;
            margin-top: 20px;
            color: #ff69b4; /* HotPink */
            text-decoration: none;
        }
        .form-container a:hover {
            color: #ff1493; /* DeepPink */
        }
    </style>
</head>
<body>
<div class="form-container">
    <h2>Schedule a Visit</h2>
    <form action="${pageContext.request.contextPath}/buyer/scheduleVisit" method="post">
        <label for="propertyTitle">Property Title:</label>
        <select id="propertyTitle" name="propertyTitle" required>
            <option value="" disabled selected>Choose here</option>
            <c:forEach var="property" items="${properties}">
                <option value="${property.title}">${property.title}</option>
            </c:forEach>
        </select>
        <br>
        <label for="visitDate">Visit Date:</label>
        <input type="date" id="visitDate" name="visitDate" min="${minDate}" required><br><br>
        <button type="submit">Schedule Visit</button>
    </form>
    <a href="buyerDashboard">Back to Dashboard</a>
</div>
</body>
</html>