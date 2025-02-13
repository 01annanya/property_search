<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="ISO-8859-1">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Contact Seller Result</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #ffffff;
            color: #333;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            margin: 0;
            overflow: hidden;
        }
        .container {
            background-color: #f9f9f9;
            padding: 20px;
            border-radius: 10px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            width: 90%;
            max-width: 500px;
            box-sizing: border-box;
            text-align: center;
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
            background-color: #ff69b4;
            color: white;
            text-decoration: none;
            border-radius: 5px;
        }
        .container a:hover {
            background-color: #ff1493;
        }
    </style>
    <script type="text/javascript">
        window.onload = function() {
            <c:if test="${isSent}">
                alert("The seller has received your message.");
            </c:if>
        };
    </script>
</head>
<body>
<div class="container">
    <h2>Contact Seller Result</h2>
    <c:choose>
        <c:when test="${isSent}">
            <p>Your message has been sent successfully!</p>
        </c:when>
        <c:otherwise>
            <p>Failed to send your message. Please try again.</p>
        </c:otherwise>
    </c:choose>
    <a href="${pageContext.request.contextPath}/buyer/buyerDashboard">Back to Dashboard</a>
</div>
</body>
</html>