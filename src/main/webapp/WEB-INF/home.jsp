<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<title>Apna Ghar</title>
<style>
        body {
            font-family: Arial, sans-serif;
            background: url('https://example.com/background-image.jpg') no-repeat center center fixed;
            background-size: cover;
            background-attachment: fixed;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            margin: 0;
            overflow: hidden;
        }
        .container {
            background-color: rgba(255, 255, 255, 0.8);
            padding: 40px;
            border-radius: 10px;
            box-shadow: 0 0 15px rgba(0, 0, 0, 0.1);
            text-align: center;
        }
        h1 {
            color: #333333;
            margin-bottom: 20px;
        }
        button {
            background-color: #007BFF;
            color: white;
            border: none;
            padding: 15px 30px;
            border-radius: 5px;
            cursor: pointer;
            font-size: 16px;
            transition: background-color 0.3s;
        }
        button:hover {
            background-color: #0056b3;
        }
</style>
</head>
<body>
<div class="container">
<h1>Welcome user</h1>
    <a href="login"><button>Login</button></a>
    <a href="signup"><button>Sign Up</button></a>

</div>
</body>
</html>