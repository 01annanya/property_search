<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Change Email</title>
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
    <script type="text/javascript">
        function showAlert(message) {
            alert(message);
        }
    </script>
</head>
<body>
    <div class="profile-container">
        <h2>Change Email</h2>
        <c:if test="${not empty message}">
            <script type="text/javascript">
                showAlert("${message}");
            </script>
        </c:if>
        <c:if test="${not empty error}">
            <div style="color: red;">${error}</div>
        </c:if>
        <form action="${pageContext.request.contextPath}/${userType}/updateEmail" method="post">
            <label>Password:</label>
            <input type="password" name="password" required /><br/>
            <label>Old Email:</label>
            <input type="email" name="oldEmail" required /><br/>
            <label>New Email:</label>
            <input type="email" name="newEmail" required /><br/>
            <button type="submit">Submit</button>
        </form>
        <a href="${pageContext.request.contextPath}/${userType}/${userType}Profile">Back to Profile</a>
    </div>
</body>
</html>