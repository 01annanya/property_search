<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<title>User Signup</title>
<script>
    window.onload = function() {
        var errorMessage = "${error}";
        if (errorMessage) {
            alert(errorMessage);
        }
    }
</script>
<style>
    body {
        font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
        background: url(https://www.bing.com/images/search?view=detailV2&ccid=XrumX8K3&id=B64792976408A96F8CCFE690F517825F1946A23D&thid=OIP.XrumX8K3O_ffVnA-1gzvIwHaEB&mediaurl=https%3A%2F%2Fstatic.toiimg.com%2Fthumb%2Fmsid-78230419%2Cwidth-1070%2Cheight-580%2Cimgsize-62161%2Cresizemode-75%2Coverlay-toi_sw%2Cpt-32%2Cy_pad-40%2Fphoto.jpg&exph=580&expw=1069&q=magicbricks&simid=607998552055840269&FORM=IRPRST&ck=6DB7C4E3C1CAA6165B27376357E41E30&selectedIndex=25&itb=0&cw=1145&ch=536&ajaxhist=0&ajaxserp=0') no-repeat center center fixed;
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
        padding: 50px;
        border-radius: 15px;
        box-shadow: 0 0 30px rgba(0, 0, 0, 0.1);
        transition: transform 0.3s, box-shadow 0.3s;
        width: 450px;
        max-width: 90%;
    }
    .container:hover {
        transform: scale(1.05);
        box-shadow: 0 0 35px rgba(0, 0, 0, 0.2);
    }
    h2 {
        color: #333333;
        text-align: center;
        margin-bottom: 30px;
        font-size: 28px;
    }
    .form-group {
        display: flex;
        flex-direction: column;
        margin-bottom: 20px;
    }
    .form-group label {
        margin-bottom: 5px;
        color: #555555;
        font-size: 16px;
    }
    .form-group input, .form-group select {
        padding: 15px;
        border: 1px solid #cccccc;
        border-radius: 5px;
        font-size: 16px;
        background-color: #f9f9f9;
        color: #333333;
    }
    button {
        width: 100%;
        padding: 15px;
        background-color: #ff69b4; /* HotPink */
        color: white;
        border: none;
        border-radius: 5px;
        font-size: 16px;
        cursor: pointer;
        transition: background-color 0.3s;
    }
    button:hover {
        background-color: #ff1493; /* DeepPink */
    }
</style>
</head>
<body>
<div class="container">
<h2>User Signup</h2>
<form action="signup" method="post">
    <div class="form-group">
        <label for="username">Username:</label>
        <input type="text" id="username" name="username" required>
    </div>
    <div class="form-group">
        <label for="email">Email:</label>
        <input type="email" id="email" name="email" required>
    </div>
    <div class="form-group">
        <label for="password">Password:</label>
        <input type="password" id="password" name="password" required>
    </div>
    <div class="form-group">
        <label for="role">Role:</label>
        <select id="role" name="role" required>
            <option value="Admin">Admin</option>
            <option value="Seller">Seller</option>
            <option value="Buyer">Buyer</option>
        </select>
    </div>
    <button type="submit">Signup</button>
</form>
<p>Already have an account? <a href="login">Login here</a></p>
</div>
</body>
</html>