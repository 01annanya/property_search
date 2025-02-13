<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Respond to Inquiry</title>
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
    .form-container {
        background-color: #f9f9f9;
        padding: 20px;
        border-radius: 10px;
        box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        width: 90%; /* Adjust width to fit within the viewport */
        max-width: 500px; /* Maximum width for the form */
        box-sizing: border-box; /* Include padding in the element's total width and height */
    }
    .form-container h2 {
        text-align: center;
        margin-bottom: 20px;
    }
    .form-container label {
        margin-top: 10px;
    }
    .form-container input, .form-container textarea {
        width: 100%;
        padding: 10px;
        margin-top: 5px;
        border: 1px solid #ddd;
        border-radius: 5px;
        box-sizing: border-box; /* Include padding in the element's total width and height */
    }
    .form-container button {
        margin-top: 20px;
        padding: 10px 20px;
        background-color: #ff69b4; /* HotPink */
        color: white;
        border: none;
        border-radius: 5px;
        cursor: pointer;
        width: 100%; /* Full width button */
    }
    .form-container button:hover {
        background-color: #ff1493; /* DeepPink */
    }
</style>

</head>
<body>
<div class="form-container">
<h2>Respond to Inquiry</h2>
<form action="${pageContext.request.contextPath}/seller/respondToInquiry" method="post">
<label for="sellerId">Seller ID:</label>
<input type="text" id="sellerId" name="sellerId" required>
<label for="inquiryId">Inquiry ID:</label>
<input type="text" id="inquiryId" name="inquiryId" required>
<label for="response">Response:</label>
<textarea id="response" name="response" rows="4" required></textarea>
<button type="submit">Submit</button>
</form>
</div>
</body>
</html>