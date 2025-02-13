<!DOCTYPE html>
<html>
<head>
    <title>Apna Ghar</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background: url('https://th.bing.com/th/id/OIP.e1_IIdzBq8phEuVl2pXuuAHaEE?rs=1&pid=ImgDetMain') no-repeat center center fixed;
            background-size: cover;
            background-attachment: fixed;
            display: flex;
            flex-direction: column;
            justify-content: center;
            align-items: center;
            height: 100vh;
            margin: 0;
            overflow: hidden;
        }
        .header {
            position: absolute;
            top: 0;
            width: 100%;
            background-color: rgba(255, 255, 255, 0.8);
            padding: 10px 0;
            text-align: center;
            box-shadow: 0 0 15px rgba(0, 0, 0, 0.1);
        }
        .header h1 {
            margin: 0;
            color: #ff69b4; /* White color */
            font-weight: bold;
        }
        .container {
            background-color: rgba(255, 255, 255, 0.8);
            padding: 40px;
            border-radius: 10px;
            box-shadow: 0 0 15px rgba(0, 0, 0, 0.1);
            text-align: center;
        }
        .container h1 {
            color: #ff69b4; /* Reddish-pink color */
            margin-bottom: 20px;
        }
        button {
            background-color: #ff69b4; /* Reddish-pink color */
            color: white;
            border: none;
            padding: 15px 30px;
            border-radius: 5px;
            cursor: pointer;
            font-size: 16px;
            transition: background-color 0.3s;
        }
        button:hover {
            background-color: #ff1493; /* Darker reddish-pink color */
        }
        .footer {
            position: absolute;
            bottom: 10px;
            width: 100%;
            text-align: center;
            color: #ffffff;
        }
        .footer p {
            margin: 5px 0;
        }
        .social-media {
            margin-top: 10px;
        }
        .social-media a {
            margin: 0 10px;
            color: #ff69b4; /* Reddish-pink color */
            text-decoration: none;
        }
        .social-media a img {
            vertical-align: middle;
            margin-right: 5px;
        }
    </style>
</head>
<body>
    <div class="header">
        <h1>Apna Ghar</h1>
    </div>
    <div class="container">
        <h1>Welcome to Apna Ghar</h1>
        <a href="login"><button>Login</button></a>
        <a href="signup"><button>Sign Up</button></a>
    </div>
    <div class="footer">
        <p>&copy; 2024 Apna Ghar. All rights reserved.</p>
        <p>Your cozy corner on the web!</p>
        <div class="social-media">
            <a href="https://facebook.com/apnaghar" target="_blank">
                <img src="https://clipart.info/images/ccovers/1509135364flat-facebook-logo-png-icon-circle.png" alt="Facebook" width="20" height="20"> 
            </a>
            <a href="https://x.com/apnaghar" target="_blank">
                <img src="https://th.bing.com/th/id/OIP.Me-Ju1BUPNaNqofK6TgV0QHaEK?rs=1&pid=ImgDetMain" alt="X" width="20" height="20">
            </a>
            <a href="https://instagram.com/apnaghar" target="_blank">
                <img src="https://www.omgubuntu.co.uk/wp-content/uploads/2016/07/instagram-new-logo.jpg" alt="Instagram" width="20" height="20"> 
            </a>
        </div>
    </div>
</body>
</html>
