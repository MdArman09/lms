<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="signup.model" %>
<% 
    model adminUser = (model) session.getAttribute("admin_session_user");
    if (adminUser != null) {
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Library Admin Dashboard</title>
    <link rel="stylesheet" href="DashBoard.css">
    <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@400;600&display=swap" rel="stylesheet">
</head>
<body>
    <div class="admin-header">
        <h1>Centurion Library - Admin Dashboard</h1>
        <button class="logout-btn" onclick="logout()">Logout</button>
    </div>

    <div class="admin-dashboard">
        <div class="admin-card">
            <h2>Manage Books</h2>
            <p>Add, update, or delete books from the library.</p>
            <button class="action-btn" onclick="location.href='manageBooks.jsp'">Go to Manage Books</button>
        </div>

        <div class="admin-card">
            <h2>Manage Users</h2>
            <p>View and manage library users (students and staff).</p>
            <button class="action-btn" onclick="location.href='manageUsers.jsp'">Go to Manage Users</button>
        </div>

        <div class="admin-card">
            <h2>Issue Books</h2>
            <p>Issue books to students.</p>
            <button class="action-btn" onclick="location.href='issueBooks.jsp'">Issue Books</button>
        </div>

        <div class="admin-card">
            <h2>Return Books</h2>
            <p>Manage book returns.</p>
            <button class="action-btn" onclick="location.href='returnBooks.jsp'">Return Books</button>
        </div>

        <div class="admin-card">
            <h2>View Reports</h2>
            <p>View detailed reports on borrowed books, returns, and overdue items.</p>
            <button class="action-btn" onclick="location.href='reports.jsp'">View Reports</button>
        </div>

        <div class="admin-card">
            <h2>Settings</h2>
            <p>Change system settings like library hours, notifications, etc.</p>
            <button class="action-btn" onclick="location.href='settings.jsp'">Go to Settings</button>
        </div>
    </div>
    <script src="DashBoard.js"></script>
</body>
</html>
<%
} else {
        response.sendRedirect("login.jsp");
    }
    %>
