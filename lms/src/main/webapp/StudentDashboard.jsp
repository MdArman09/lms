<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="signup.model" %>
<% 
    model studentUser = (model) session.getAttribute("student_session_user");
    if (studentUser != null) {
%>
        <!DOCTYPE html>
        <html lang="en">
        <head>
            <meta charset="UTF-8">
            <meta name="viewport" content="width=device-width, initial-scale=1.0">
            <title>Library Student Dashboard</title>
            <link rel="stylesheet" href="StudentDashboard.css">
            <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@400;600&display=swap" rel="stylesheet">
        </head>
        <body>
            <div class="student-header">
                <h1>Centurion Library - Student Dashboard</h1>
                <button class="logout-btn" onclick="location.href='logout'">Logout</button>
            </div>
            
            <!-- Display student information -->
            <div class="session-user" onclick="showCelebration()">
                <div class="student-info fade-in">
                    <p>Welcome, <strong><%= studentUser.getName() %></strong></p>
                    <p>Email: <%= studentUser.getEmail() %></p>
                </div>
            </div>

            <div class="student-dashboard">
                <div class="student-card">
                    <h2>Books List</h2>
                    <p>View all the Books</p>
                    <button class="action-btn" onclick="location.href='BooksList.jsp'">Go to Books List</button>
                </div>

                <div class="student-card">
                    <h2>My Borrowed Books</h2>
                    <p>View your borrowed books and due dates</p>
                    <button class="action-btn" onclick="location.href='borrowedBooks.jsp'">Go to My Books</button>
                </div>

                <div class="student-card">
                    <h2>Borrow Books</h2>
                    <p>Request Books from library</p>
                    <button class="action-btn" onclick="location.href='StudentIssue.jsp'">Borrow Books</button>
                </div>

                <div class="student-card">
                    <h2>Returned Books</h2>
                    <p>Check return books and fines</p>
                    <button class="action-btn" onclick="location.href='returnedBooks.jsp'">See book return history</button>
                </div>
                
                <div class="student-card">
                    <h2>Notice</h2>
                    <p>Get all library related notices here</p>
                    <button class="action-btn" onclick="location.href='LibraryPolicy.jsp'">View Notice</button>
                </div>

                <div class="student-card">
                    <h2>Library Timings and Policies</h2>
                    <p>View Library Timings and Policies</p>
                    <button class="action-btn" onclick="location.href='LibraryPolicy.jsp'">Library Rules and Policies</button>
                </div>
            </div>
            <script src="StudentDashboard.js"></script>
        </body>
        </html>
<%
    } else {
        response.sendRedirect("login.jsp");
    }
%>
