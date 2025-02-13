<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
    <title>Buyer Profile</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #ffffff; /* White background */
            color: #333;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            margin: 0;
        }
        .profile-container {
            background-color: #f8f8f8;
            border: 1px solid #ddd;
            border-radius: 5px;
            padding: 20px;
            box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
            text-align: center;
            width: 300px;
        }
        .profile-container h2 {
            color: #ff69b4; /* HotPink */
            margin-bottom: 20px;
        }
        .profile-container label {
            display: block;
            margin-bottom: 5px;
            font-weight: bold;
        }
        .profile-container input {
            width: 100%;
            padding: 8px;
            margin-bottom: 10px;
            border: 1px solid #ddd;
            border-radius: 5px;
        }
        .profile-container button {
            background-color: #ff69b4; /* HotPink */
            color: white;
            border: none;
            padding: 10px 20px;
            border-radius: 5px;
            cursor: pointer;
            margin-bottom: 10px;
        }
        .profile-container button:hover {
            background-color: #ff1493; /* DeepPink */
        }
        .profile-container a {
            display: block;
            margin-top: 10px;
            color: #ff69b4; /* HotPink */
            text-decoration: none;
        }
        .profile-container a:hover {
            color: #ff1493; /* DeepPink */
        }
    </style>
</head>
<body>
    <div class="profile-container">
        <h2>Buyer Profile</h2>
        <form>
            <label>Username:</label>
            <input type="text" name="username" value="${buyer.username}" readonly /><br/>
            <label>Email:</label>
            <input type="email" name="email" value="${buyer.email}" readonly /><br/>
            <button type="button" onclick="location.href='${pageContext.request.contextPath}/buyer/changePassword'">Change Password</button>
            <button type="button" onclick="location.href='${pageContext.request.contextPath}/buyer/changeEmail'">Change Email</button>
            <a href="${pageContext.request.contextPath}/buyer/buyerDashboard">Back to Dashboard</a>
        </form>
    </div>
</body>
</html>