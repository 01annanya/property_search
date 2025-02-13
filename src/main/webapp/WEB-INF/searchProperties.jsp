<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Search Properties</title>
</head>
<body>
<h1>Search Properties</h1>
<form action="searchProperties" method="get">
    <table>
        <tr>
            <td><label for="location">Location:</label></td>
            <td><input type="text" id="location" name="location" required></td>
        </tr>
        <tr>
            <td colspan="2" style="text-align: center;">
                <input type="submit" value="Search">
            </td>
        </tr>
    </table>
</form>
<a href="buyerDashboard">Back to dashboard</a>

   
</body>
</html>