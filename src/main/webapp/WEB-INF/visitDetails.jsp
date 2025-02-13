<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="ISO-8859-1">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Visit Details</title>
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
        }
        .container {
            background-color: #f9f9f9;
            padding: 20px;
            border-radius: 10px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            width: 90%; /* Adjust width to fit within the viewport */
            max-width: 600px; /* Maximum width for the container */
            box-sizing: border-box; /* Include padding in the element's total width and height */
            text-align: center; /* Center the content */
        }
        .container h2 {
            margin-bottom: 20px;
        }
        .container p {
            margin: 10px 0;
        }
        .container a {
            display: inline-block;
            margin-top: 20px;
            padding: 10px 20px;
            background-color: #ff69b4; /* HotPink */
            color: white;
            text-decoration: none;
            border-radius: 5px;
        }
        .container a:hover {
            background-color: #ff1493; /* DeepPink */
        }
    </style>
</head>
<body>
<div class="container">
    <h2>Visit Details</h2>
    <p>Property Title: <c:out value="${visit.propertyTitle}" /></p>
    <p>Visit Date: <c:out value="${visit.visitDate}" /></p>
    <p>Message: <c:out value="${visit.message}" /></p>
    <a href="${pageContext.request.contextPath}/buyer/buyerDashboard">Back to Dashboard</a>
</div>
</body>
</html>