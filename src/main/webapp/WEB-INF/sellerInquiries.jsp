<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Pending Inquiries</title>
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
        .inquiry-container {
            background-color: #fff;
            border-radius: 8px;
            box-shadow: 0 0 15px rgba(0, 0, 0, 0.1);
            margin: 20px auto;
            max-width: 600px;
            padding: 20px;
            transition: transform 0.2s;
        }
        .inquiry-container:hover {
            transform: scale(1.02);
        }
        .inquiry-container p {
            margin: 10px 0;
            color: #555;
        }
        .inquiry-container form {
            margin-top: 20px;
        }
        .inquiry-container textarea {
            width: 100%;
            height: 60px; /* Reduced height */
            padding: 10px;
            border: 1px solid #ccc;
            border-radius: 4px;
            resize: vertical;
            font-family: inherit;
        }
        .inquiry-container button {
            background-color: #ff69b4;
            color: white;
            border: none;
            padding: 10px 20px;
            text-align: center;
            text-decoration: none;
            display: inline-block;
            font-size: 16px;
            margin: 4px 2px;
            cursor: pointer;
            border-radius: 4px;
            transition: background-color 0.3s;
        }
        .inquiry-container button:hover {
            background-color: #ff1493;
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
    <h2>Pending Inquiries</h2>
    <c:if test="${not empty inquiries}">
        <c:forEach var="inquiry" items="${inquiries}">
            <c:if test="${inquiry.status == 'pending'}">
                <div class="inquiry-container">
                    <p><strong>Buyer Name:</strong> ${buyerUsernames[inquiry.buyerId]}</p>
                    <p><strong>Property Title:</strong> ${propertyTitles[inquiry.propertyId]}</p>
                    <p><strong>Inquiry:</strong> ${inquiry.message}</p>
                    <form action="respondToInquiry" method="post">
                        <input type="hidden" name="inquiryId" value="${inquiry.inquiryId}" />
                        <p><strong>Buyer Email:</strong> ${buyerEmails[inquiry.buyerId]}</p>
                        <textarea name="response" placeholder="Enter your response here"></textarea>
                        <button type="submit">Send Response</button>
                    </form>
                </div>
            </c:if>
        </c:forEach>
    </c:if>
    <div class="navigation-links">
        <a href="sellerDashboard">Back to Seller Dashboard</a>
    </div>
</body>
</html>