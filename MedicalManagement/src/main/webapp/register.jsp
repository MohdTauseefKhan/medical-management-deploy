<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Register Page</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background: #f4f4f4;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }
        .register-container {
            background: white;
            padding: 20px 30px;
            border-radius: 10px;
            box-shadow: 0 0 10px #ccc;
            width: 280px;
        }
        h2 {
            text-align: center;
            margin-bottom: 15px;
        }
        input[type="text"], input[type="password"], input[type="email"] {
            width: 100%;
            padding: 8px;
            margin: 8px 0;
            border-radius: 5px;
            border: 1px solid #ccc;
            font-size: 14px;
        }
        input[type="submit"] {
            width: 100%;
            padding: 8px;
            background: #28a745;
            border: none;
            border-radius: 5px;
            color: white;
            font-size: 14px;
            cursor: pointer;
        }
        input[type="submit"]:hover {
            background: #218838;
        }
        .login-link {
            text-align: center;
            margin-top: 10px;
        }
        .login-link a {
            text-decoration: none;
            color: #007BFF;
            font-size: 13px;
        }
        .login-link a:hover {
            text-decoration: underline;
        }
        .error {
            color: red;
            text-align: center;
            font-size: 13px;
        }
    </style>
</head>
<body>
    <div class="register-container">
        <h2>Register</h2>

		

	<c:if test="${not empty sessionScope.errorMessage}">
    <div style="color: red; font-weight: bold; margin-bottom: 10px;font-size:13px;text-align: center; ">
        ${sessionScope.errorMessage}
    </div>
    <c:remove var="errorMessage" scope="session"/>
</c:if>

<c:if test="${not empty sessionScope.successMessage}">
    <div style="color: green; font-weight: bold; margin-bottom: 10px;font-size:13px;text-align: center;">
        ${sessionScope.successMessage}
    </div>
    <c:remove var="successMessage" scope="session"/>
</c:if>
		

        <form action="RegisterServlet" method="post">
            <input type="text" name="username" placeholder="Enter Username" required>
            <input type="email" name="email" placeholder="Enter Email" required>
            <input type="password" name="password" placeholder="Enter Password" required>
            <input type="text" name="code" placeholder="Enter registration code" required>
            <input type="submit" value="Register">
        </form>

        <!-- Login link -->
        <div class="login-link">
            <p>Already have an account? <a href="login.jsp">Login here</a></p>
        </div>
    </div>
</body>
</html>
