<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add New Seller Form</title>
</head>
<body>
    <form action="addNewSeller" method="post">
        <table>
            <tr>
                <td>Username</td>
                <td><input type="text" name="username" required/></td>
            </tr>
            <tr>
                <td>Password</td>
                <td><input type="password" name="password" required/></td>
            </tr>
            <tr>
                <td>Email</td>
                <td><input type="email" name="email" required/></td>
            </tr>
            <tr>
                <td></td>
                <td>
                    <input type="submit" value="Enter"/>
                    <input type="reset" value="Clear"/>
                </td>
            </tr>                        
        </table>
    </form>
</body>
</html>