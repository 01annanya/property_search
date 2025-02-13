<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>My Responses</title>
    <style>
        body {
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
            background-color: #f4f4f9;
            margin: 0;
            padding: 20px;
        }
        h2 {
            color: #333;
            text-align: center;
            margin-bottom: 20px;
        }
        .response-container {
            background-color: #fff;
            border-radius: 8px;
            box-shadow: 0 0 15px rgba(0, 0, 0, 0.1);
            margin: 20px auto;
            max-width: 600px;
            padding: 20px;
            transition: transform 0.2s;
        }
        .response-container:hover {
            transform: scale(1.02);
        }
        .response-container p {
            margin: 10px 0;
            color: #555;
        }
        .navigation-links {
            text-align: center;
            margin-top: 20px;
        }
        .navigation-links a {
            margin: 0 10px;
            color: #ff69b4;
            text-decoration: none;
            font-weight: bold;
            transition: color 0.3s;
        }
        .navigation-links a:hover {
            color: #ff1493;
            text-decoration: underline;
        }
    </style>
</head>
<body>
    <h2>My Responses</h2>
    <c:if test="${not empty inquiries}">
        <c:forEach var="inquiry" items="${inquiries}">
            <c:if test="${inquiry.status == 'answered'}">
                <div class="response-container">
                    <p><strong>Buyer Name:</strong> ${buyerUsernames[inquiry.buyerId]}</p>
                    <p><strong>Property Title:</strong> ${propertyTitles[inquiry.propertyId]}</p>
                    <p><strong>Inquiry:</strong> ${inquiry.message}</p>
                    <p><strong>Response:</strong> ${inquiry.response}</p>
                </div>
            </c:if>
        </c:forEach>
    </c:if>
    <div class="navigation-links">
        <a href="sellerInquiries">Back to Seller Inquiries</a>
    </div>
</body>
</html>