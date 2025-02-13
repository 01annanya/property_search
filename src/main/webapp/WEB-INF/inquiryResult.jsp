<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="ISO-8859-1">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Inquiry Result</title>
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
        .footer {
            text-align: center;
            margin-top: 20px;
            font-size: 12px;
            color: #888;
        }
    </style>
    <script type="text/javascript">
        window.onload = function() {
            <c:if test="${isAdded}">
                setTimeout(function() {
                    alert("The seller has received your inquiry.");
                }, 2000); // Delay of 2 seconds
            </c:if>
        };
    </script>
</head>
<body>
<div class="container">
    <h2>Inquiry Result</h2>
    <c:choose>
        <c:when test="${isAdded}">
            <p>Your inquiry has been sent successfully!</p>
        </c:when>
        <c:otherwise>
            <p>Failed to send your inquiry. Please try again.</p>
        </c:otherwise>
    </c:choose>
    <a href="${pageContext.request.contextPath}/buyer/buyerDashboard">Back to Dashboard</a>
</div>
</body>
</html>