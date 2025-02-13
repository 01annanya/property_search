<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Response Submitted</title>
    <meta http-equiv="refresh" content="2;url=${pageContext.request.contextPath}/seller/sellerInquiries" />
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            margin: 0;
            padding: 0;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }
        .container {
            background-color: #fff;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            text-align: center;
        }
        h2 {
            color: #4CAF50;
        }
        p {
            margin: 10px 0;
        }
        a {
            color: #4CAF50;
            text-decoration: none;
        }
        a:hover {
            text-decoration: underline;
        }
    </style>
</head>
<body>
    <div class="container">
        <h2>Response Submitted</h2>
        <p>Your response has been submitted successfully.</p>
        <p><a href="sellerInquiries">Return to Seller Inquiries</a></p>
    </div>

    <script>
        document.addEventListener('DOMContentLoaded', function() {
            setTimeout(function() {
                alert('Response has been sent to the buyer.');
            }, 2000);
        });
    </script>
</body>
</html>