<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<title>Update Buyer</title>
</head>
<body>
 <h2>Update Buyer Information</h2>
    <form action="updateBuyer" method="post">
        <label for="buyer_id">Buyer ID:</label>
        <input type="text" id="buyer_id" name="buyer_id" required><br><br>
        
        <label for="email">Email:</label>
        <input type="email" id="email" name="email" required><br><br>
        
        <label for="password">Password:</label>
        <input type="password" id="password" name="password" required><br><br>
        
        <input type="submit" value="Update Buyer">
    </form>
</body>
</html>