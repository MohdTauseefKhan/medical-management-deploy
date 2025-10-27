<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Medical Store Management System</title>
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
            padding: 15px;
            text-align: center;
            position: relative;
        }
        /* Logout button in header */
        .logout-btn {
            position: absolute;
            right: 20px;
            top: 15px;
            background: #dc3545;
            color: white;
            padding: 8px 14px;
            border: none;
            border-radius: 5px;
            text-decoration: none;
            font-size: 14px;
            font-weight: bold;
            transition: background 0.3s;
        }
        .logout-btn:hover {
            background: #b52a37;
        }
        nav {
            background: #333;
            padding: 10px;
            display: flex;
            justify-content: center;
            gap: 15px;
        }
        nav a {
            background: #444;
            color: white;
            padding: 10px 18px;
            border-radius: 6px;
            text-decoration: none;
            font-size: 15px;
            font-weight: bold;
            transition: all 0.3s ease;
        }
        nav a:hover {
            background: #007BFF;
            transform: scale(1.05);
        }
        .container {
            padding: 20px;
        }
        /* Stylish table */
        table {
            width: 90%;
            margin: 20px auto;
            border-collapse: collapse;
            background: white;
            box-shadow: 0 0 10px #ccc;
            border-radius: 8px;
            overflow: hidden;
        }
        th, td {
            padding: 12px;
            text-align: center;
            border-bottom: 1px solid #ddd;
        }
        th {
            background: #007BFF;
            color: white;
        }
        tr:hover {
            background: #f1f1f1;
        }
        /* Header bar */
        .header-bar {
            display: flex;
            align-items: center;
            justify-content: center;
            position: relative;
            margin-bottom: 10px;
            padding: 5px 10px;
        }
        .header-bar .title {
            font-size: 22px;
            font-weight: bold;
            color: #007BFF;
        }
        .header-bar .refresh {
            position: absolute;
            right: 10px;
            background: #007BFF;
            color: white;
            text-decoration: none;
            padding: 6px 12px;
            border-radius: 5px;
            font-size: 14px;
            transition: 0.2s;
        }
        .header-bar .refresh:hover {
            background: #0056b3;
        }
    </style>
</head>
<body>
    <!-- Check for login -->
    <%
        response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
        if (session.getAttribute("username") == null) {
            response.sendRedirect("login.jsp");
        }
    %>

    <header>
        <h1>Sold Medicine</h1>
        <p>
            Welcome,
            <%= session.getAttribute("username") != null ? session.getAttribute("username") : "Guest" %>
        </p>
        <a href="LogoutServlet" class="logout-btn">Logout</a>
    </header>

    <nav>
        <a href="addMedicine.jsp">Add Medicine</a>
        <a href="sellMedicine.jsp">Sell Medicine</a>
        <a href="home.jsp">Stock</a>
    </nav>

    <div class="container">
        <!-- ✅ Stock title and refresh -->
        <div class="header-bar">
            <span class="title">Stock Sold</span>
            <a href="ShowSoldStockServlet" class="refresh">Refresh</a>
        </div>

        <!-- ✅ Medicines Table -->
        <table>
            <thead>
                <tr>
                    <th>Medicine ID</th>
                    <th>Name</th>
                    <th>Category</th>
                    <th>Quantity</th>
                    <th>Expiry Date</th>
                    <th>Supplier</th>
                    <th>Sold Date</th>
                </tr>
            </thead>
             <tbody>
        <c:forEach var="med" items="${medicines}">
            <tr>
                <td>${med.id}</td>
                <td>${med.name}</td>
                <td>${med.category}</td>
                <td>${med.quantity}</td>
                <td>${med.expiryDate}</td>
                <td>${med.supplier}</td>
                <td>${med.soldDate}</td>
            </tr>
        </c:forEach>
    </tbody>
        
        </table>
    </div>
</body>
</html>
