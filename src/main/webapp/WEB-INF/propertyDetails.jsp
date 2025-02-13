<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Property Details</title>
    <style>
        body {
            font-family: 'Roboto', sans-serif;
            background-color: #f8f8f8;
            color: #333;
            margin: 0;
            padding: 0;
        }
        header {
            background-color: #ff69b4;
            padding: 15px;
            text-align: center;
            color: white;
        }
        .container {
            max-width: 600px;
            margin: 20px auto;
            padding: 20px;
            border: 1px solid #ccc;
            border-radius: 10px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            background-color: white;
        }
        .property-card {
            display: flex;
            flex-direction: column;
            align-items: center;
        }
        .property-card img {
            width: 100%;
            max-width: 300px;
            height: auto;
            border-radius: 10px;
        }
        .property-details {
            text-align: left;
            width: 100%;
            padding: 10px 0;
        }
        .property-details h1 {
            color: #ff69b4;
            font-size: 24px;
        }
        .property-details p {
            font-size: 14px;
            line-height: 1.4;
        }
        .tabs {
            display: flex;
            justify-content: space-around;
            margin-top: 20px;
        }
        .tab {
            flex: 1;
            text-align: center;
            padding: 10px;
            background-color: #ff69b4;
            color: white;
            border-radius: 5px;
            cursor: pointer;
            transition: background-color 0.3s;
            margin: 0 5px;
        }
        .tab:hover {
            background-color: #ff1493;
        }
        .tab-content {
            display: none;
            margin-top: 20px;
        }
        .tab-content.active {
            display: block;
        }
        .form-container {
            margin-top: 20px;
        }
        .form-container form {
            margin-bottom: 20px;
        }
        .form-container textarea, .form-container input[type="date"] {
            width: 100%;
            padding: 10px;
            margin: 10px 0;
            border: 1px solid #ccc;
            border-radius: 5px;
            box-sizing: border-box;
        }
        .form-container button {
            width: 100%;
            padding: 10px;
            background-color: #ff69b4;
            color: white;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            transition: background-color 0.3s;
        }
        .form-container button:hover {
            background-color: #ff1493;
        }
        .toast {
            position: fixed;
            top: 20px;
            right: 20px;
            background-color: green;
            color: white;
            padding: 10px;
            border-radius: 5px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            z-index: 1000;
        }
        .toast.error {
            background-color: #f44336;
            color: white;
        }
        .heart-icon {
            font-size: 24px;
            color: #ff69b4;
            cursor: pointer;
            transition: color 0.3s;
        }
        .heart-icon:hover {
            color: #ff1493;
        }
        .back-to-dashboard {
            display: block;
            text-align: center;
            margin-top: 20px;
            font-weight: bold;
            color: #ff69b4;
            text-decoration: none;
        }
        .back-to-dashboard:hover {
            color: #ff1493;
        }
        @media (max-width: 600px) {
            .container {
                padding: 10px;
            }
            .property-card img {
                max-width: 100%;
            }
            .tabs {
                flex-direction: column;
            }
            .tab {
                margin-bottom: 10px;
            }
        }
    </style>
    <script>
        function showAlert(message) {
            var toast = document.createElement('div');
            toast.className = 'toast';
            toast.innerText = message;
            document.body.appendChild(toast);
            setTimeout(function() {
                toast.style.display = 'none';
            }, 3000);
        }

        function openTab(event, tabId) {
            var i, tabcontent, tablinks;
            tabcontent = document.getElementsByClassName("tab-content");
            for (i = 0; i < tabcontent.length; i++) {
                tabcontent[i].style.display = "none";
            }
            tablinks = document.getElementsByClassName("tab");
            for (i = 0; i < tablinks.length; i++) {
                tablinks[i].className = tablinks[i].className.replace(" active", "");
            }
            document.getElementById(tabId).style.display = "block";
            event.currentTarget.className += " active";
        }

        window.onload = function() {
            var urlParams = new URLSearchParams(window.location.search);
            if (urlParams.has('message')) {
                showAlert(urlParams.get('message'));
            }

            // Set the min attribute of the visit date input to today's date
            var today = new Date().toISOString().split('T')[0];
            document.getElementById("visitDate").setAttribute("min", today);
        }
    </script>
</head>
<body>
    <header>
        <h1>Property Details</h1>
    </header>
    <div class="container">
        <div class="property-card">
            <img src="https://th.bing.com/th/id/OIP.CYBTsJ6aPCdYLdqLW3xaBQHaFO?w=213&h=180&c=7&r=0&o=5&dpr=1.5&pid=1.7" alt="Property Image">
            <div class="property-details">
                <h1>${property.title}</h1>
                <p><strong>Description:</strong> ${property.description}</p>
                <p><strong>Price:</strong> ${property.price}</p>
                <p><strong>Location:</strong> ${property.location}</p>
                <p><strong>Square Feet:</strong> ${property.squareft}</p>
                <p><strong>Amenities:</strong> ${property.amenities}</p>
            </div>
        </div>

        <c:if test="${not empty buyer}">
            <div class="tabs">
                <div class="tab" onclick="openTab(event, 'favorites')">Add to Favorites</div>
                <div class="tab" onclick="openTab(event, 'inquiry')">Send Inquiry</div>
                <div class="tab" onclick="openTab(event, 'visit')">Schedule Visit</div>
            </div>

            <div id="favorites" class="tab-content">
                <div class="form-container">
                    <form action="${pageContext.request.contextPath}/buyer/addFavorite" method="post">
                        <input type="hidden" name="propertyId" value="${property.propertyId}">
                        <button type="submit" class="heart-icon">&#x2764;</button>
                    </form>
                </div>
            </div>

            <div id="inquiry" class="tab-content">
                <div class="form-container">
                    <form action="${pageContext.request.contextPath}/buyer/addInquiry" method="post">
                        <input type="hidden" name="propertyId" value="${property.propertyId}">
                        <textarea name="message" placeholder="Enter your inquiry here" required></textarea>
                        <button type="submit">Send Inquiry</button>
                    </form>
                </div>
            </div>

            <div id="visit" class="tab-content">
                <div class="form-container">
                    <form action="${pageContext.request.contextPath}/buyer/scheduleVisit" method="post">
                        <input type="hidden" name="propertyId" value="${property.propertyId}">
                        <label for="visitDate">Select Visit Date:</label>
                        <input type="date" id="visitDate" name="visitDate" required>
                        <button type="submit">Schedule Visit</button>
                    </form>
                </div>
            </div>
        </c:if>
        <a href="buyerDashboard" class="back-to-dashboard">Back to Dashboard</a>
    </div>
</body>
</html>