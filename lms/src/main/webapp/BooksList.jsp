<%@page import="managebook.ManageBookDao"%>
<%@page import="java.util.List"%>
<%@page import="managebook.ManageBook"%>
<%@page import="managebook.ManageBookDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <title>Books List</title>
    <link rel="stylesheet" href="BooksList.css">
    <link href="https://fonts.googleapis.com/css2?family=Montserrat:wght@400;600&display=swap" rel="stylesheet">
</head>

<body>

    <div class="admin-header">
        <button class="back-btn" onclick="location.href='StudentDashboard.jsp'">Back</button>
        <h1>Books List</h1>
    </div>

    <div class="admin-form-container">
        <input type="text" id="searchInput" placeholder="Search by Book Title..." onkeyup="searchBook()">

        <div class="book-list-container">
            <h2>All Books</h2>
            <table class="book-list" id="bookTable">
                <thead>
                    <tr>
                        <th>Acc. No</th>
                        <th>Book Title</th>
                        <th>Author</th>
                        <th>Publisher</th>
                    </tr>
                </thead>
                <tbody id="bookListBody">
                    <% ManageBookDao bookDao=new ManageBookDao(); 
                       List<ManageBook> bookList = bookDao.getAllBooks();
                       for (ManageBook book : bookList) {
                        %>
                        <tr>
                            <td><%= book.getAcc_no() %></td>
                            <td><%= book.getTitle() %></td>
                            <td><%= book.getAuthor() %></td>
                            <td><%= book.getPublisher() %></td>
                        </tr>
                        <% 
                      } 
                    %>
                </tbody>
            </table>
        </div>
    </div>

    <script src="BooksList.js"></script>

</body>

</html>