<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Visits List</title>
<style>
        body {
            font-family: Arial, sans-serif;
            background-color: #ffffff; /* White background */
            color: #333;
            display: flex;
            justify-content: center; /* Center the body content */
            align-items: center; /* Center the body content vertically */
            height: 100vh; /* Full viewport height */
            margin: 0;
            overflow: hidden; /* Prevent scrollbars */
        }
        .container {
            background-color: #f9f9f9;
            padding: 20px;
            border-radius: 10px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            width: 90%; /* Adjust width to fit within the viewport */
            max-width: 800px; /* Maximum width for the container */
            box-sizing: border-box; /* Include padding in the element's total width and height */
            text-align: center; /* Center the content */
            overflow-y: auto; /* Add vertical scroll bar */
            max-height: 90vh; /* Limit the height to 90% of the viewport height */
        }
        .container h2 {
            margin-bottom: 20px;
        }
        .container table {
            width: 100%;
            border-collapse: collapse;
        }
        .container table, .container th, .container td {
            border: 1px solid #ddd;
        }
        .container th, .container td {
            padding: 10px;
            text-align: left;
        }
        .container th {
            background-color: #f2f2f2;
        }
        .container button {
            padding: 10px 20px;
            background-color: #ff69b4; /* HotPink */
            color: white;
            border: none;
            border-radius: 5px;
            cursor: pointer;
        }
        .container button:hover {
            background-color: #ff1493; /* DeepPink */
        }
        .tabs {
            margin-top: 20px;
        }
        .tabs a {
            padding: 10px 20px;
            text-decoration: none;
            color: #007bff; /* Assuming this is the color used in buyerDashboard UI */
            border: 1px solid #ccc;
            border-radius: 4px;
        }
        .tabs a:hover {
            background-color: #ddd;
        }
        .tabs a.active {
            background-color: #007bff;
            color: white;
        }
</style>
<script>
        function showAlert(status) {
            alert("The visit has been " + status + " and will be notified to the buyer.");
        }
</script>
</head>
<body>
<div class="container">
<h2>Visit List</h2>
<c:choose>
<c:when test="${not empty pendingVisits}">
<table border="1">
<thead>
<tr>
<th>Property Name</th>
<th>Buyer Username</th>
<th>Visit Date</th>
<th>Status</th>
<th>Action</th>
</tr>
</thead>
<tbody>
<c:forEach var="visit" items="${pendingVisits}">
<tr>
<td>${propertyNames[visit.propertyId]}</td>
<td>${buyerUsernames[visit.buyerId]}</td>
<td>${visit.visitDate}</td>
<td>${visit.status}</td>
<td>
<form action="<c:url value='/seller/updateVisitStatus' />" method="post" onsubmit="showAlert(this.status.value)">
<input type="hidden" name="visitId" value="${visit.visitId}" />
<select name="status">
<option value="Scheduled" ${visit.status == 'Scheduled' ? 'selected' : ''}>Scheduled</option>
<option value="Cancelled" ${visit.status == 'Cancelled' ? 'selected' : ''}>Cancelled</option>
</select>
<button type="submit">Update</button>
</form>
</td>
</tr>
</c:forEach>
</tbody>
</table>
</c:when>
<c:otherwise>
<p>No pending visits found.</p>
</c:otherwise>
</c:choose>
<div class="tabs">
<a href="sellerDashboard">Back to Dashboard</a>
</div>
</div>
</body>
</html>