<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Property Search Results</title>
    <style>
        table {
            width: 100%;
            border-collapse: collapse;
        }
        th, td {
            border: 1px solid black;
            padding: 8px;
            text-align: left;
        }
        th {
            background-color: #f2f2f2;
        }
        .center {
            text-align: center;
            margin-top: 20px;
        }
        .back-to-dashboard {
            background-color: pink;
            padding: 10px 20px;
            text-decoration: none;
            color: black;
            border-radius: 5px;
        }
        .select-button {
            background-color: #ff69b4; /* HotPink */
            color: white;
            padding: 5px 10px;
            text-decoration: none;
            border-radius: 5px;
        }
        .select-button:hover {
            background-color: #ff1493; /* DeepPink */
        }
    </style>
</head>
<body>
    <h2>Search Results for Location: ${location}</h2>
    <form action="filterProperties" method="get">
        <input type="hidden" name="location" value="${location}">
        <label for="minPrice">Min Price:</label>
        <input type="number" id="minPrice" name="minPrice" step="0.01">
        <label for="maxPrice">Max Price:</label>
        <input type="number" id="maxPrice" name="maxPrice" step="0.01">
        <label for="amenities">Amenities:</label>
        <input type="text" id="amenities" name="amenities">
        <button type="submit">Filter</button>
    </form>
    <table>
        <thead>
            <tr>
                <th>Title</th>
                <th>Description</th>
                <th>Price</th>
                <th>Location</th>
                <th>Square Feet</th>
                <th>Amenities</th>
                <th>Action</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="property" items="${properties}">
                <tr>
                    <td>${property.title}</td>
                    <td>${property.description}</td>
                    <td>${property.price}</td>
                    <td>${property.location}</td>
                    <td>${property.squareft}</td>
                    <td>${property.amenities}</td>
                    <td>
                        <c:choose>
                            <c:when test="${not empty property.propertyId}">
                                <a href="propertyDetails?propertyId=${property.propertyId}" class="select-button">Select</a>
                            </c:when>
                            <c:otherwise>
                                <span class="select-button disabled">Unavailable</span>
                            </c:otherwise>
                        </c:choose>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
    <div class="center">
        <a href="buyerDashboard" class="back-to-dashboard">Back to Dashboard</a>
    </div>
</body>
</html>