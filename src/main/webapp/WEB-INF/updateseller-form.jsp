<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <title>Update Seller</title>
</head>
<body>
    <h2>Update Seller</h2>
    <form action="updateSeller" method="post">
        <label for="seller_id">Seller ID:</label>
        <input type="text" id="seller_id" name="seller_id" required><br><br>
        <label for="email">Email:</label>
        <input type="email" id="email" name="email" required><br><br>
        <label for="password">Password:</label>
        <input type="password" id="password" name="password" required><br><br>
        <input type="submit" value="Update Seller">
    </form>
</body>
</html>