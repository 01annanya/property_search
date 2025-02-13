<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Confirmation</title>
    <style>
        .confirmation {
            max-width: 600px;
            margin: auto;
            padding: 20px;
            border: 1px solid #ccc;
            border-radius: 10px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            text-align: center;
        }
        .confirmation a {
            display: block;
            margin: 10px 0;
            padding: 10px;
            background-color: #007bff;
            color: white;
            text-decoration: none;
            border-radius: 5px;
        }
        .confirmation a:hover {
            background-color: #0056b3;
        }
    </style>
</head>
<body>
    <div class="confirmation">
        <h2>${param.message}</h2>
        <a href="${pageContext.request.contextPath}/buyer/propertyDetails?propertyId=${param.propertyId}">Back to Property Details</a>
    </div>
</body>
</html>