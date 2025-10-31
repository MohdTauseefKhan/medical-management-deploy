<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Add Medicine - Medical Store</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background: #f4f6f9;
            margin: 0;
            padding: 0;
        }

        header {
            background: #007BFF;
            color: white;
            text-align: center;
            padding: 20px;
            font-size: 24px;
            font-weight: bold;
            position: relative;
        }

        nav {
            background: #333;
            display: flex;
            justify-content: center;
            padding: 10px;
            gap: 15px;
        }

        nav a {
            color: white;
            text-decoration: none;
            background: #444;
            padding: 10px 18px;
            border-radius: 6px;
            font-weight: bold;
            transition: all 0.3s ease;
        }

        nav a:hover {
            background: #007BFF;
            transform: scale(1.05);
        }

        .container {
            max-width: 600px;
            margin: 40px auto;
            background: white;
            padding: 30px;
            border-radius: 10px;
            box-shadow: 0 0 15px rgba(0,0,0,0.1);
        }

        .container h2 {
            text-align: center;
            color: #007BFF;
            margin-bottom: 25px;
        }

        form label {
            display: block;
            margin-bottom: 8px;
            font-weight: bold;
            color: #333;
        }

        form input, form select {
            width: 100%;
            padding: 10px;
            margin-bottom: 20px;
            border: 1px solid #ccc;
            border-radius: 6px;
            font-size: 14px;
        }

        form input[type="submit"] {
            background: #007BFF;
            color: white;
            border: none;
            cursor: pointer;
            font-weight: bold;
            transition: 0.3s;
        }

        form input[type="submit"]:hover {
            background: #0056b3;
        }

        .message {
            text-align: center;
            margin-bottom: 20px;
            font-weight: bold;
            color: green;
        }
    </style>
</head>
<body>
    <header>
        Medical Store Management System
    </header>

    <nav>
        <a href="home.jsp">Stock</a>
        <a href="sellMedicine.jsp">Sell Medicine</a>
        <a href="soldMedicine.jsp">Sold Medicine</a>
    </nav>

    <div class="container">
        <h2>Add New Medicine</h2>

		<%
        response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
        if (session.getAttribute("username") == null) {
            response.sendRedirect("login.jsp");
        }
    %>
        <!-- Success / Error Message -->
        <c:if test="${not empty message}">
            <div class="message">${message}</div>
        </c:if>

        <form action="AddMedicineServlet" method="post">
            <label for="name">Medicine Name:</label>
            <input type="text" name="name" id="name" required placeholder="Enter medicine name">

            <label for="category">Category:</label>
            <select name="category" id="category" required>
                <option value="">Select category</option>
                <option value="Tablet">Tablet</option>
                <option value="Syrup">Syrup</option>
            </select>

            <label for="quantity">Quantity:</label>
            <input type="number" name="quantity" id="quantity" required placeholder="Enter quantity">

            <label for="expiry">Expiry Date:</label>
            <input type="date" name="expiry" id="expiry" required>

            <label for="supplier">Supplier Name:</label>
            <input type="text" name="supplier" id="supplier" required placeholder="Enter supplier name">

            <input type="submit" value="Add Medicine">
        </form>
    </div>
</body>
</html>
