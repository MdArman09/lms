<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="managebook.ManageBook" %>
<%@ page import="managebook.ManageBookDao" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Manage Books</title>
    <link rel="stylesheet" href="manageBooks.css">
    <link href="https://fonts.googleapis.com/css2?family=Montserrat:wght@400;600&display=swap" rel="stylesheet">
</head>
<body>
    <div class="admin-header">
        <h1>Manage Books</h1>
        <button class="back-btn" onclick="history.back()">Back</button>
    </div>

    <div class="admin-form-container">
        <form action="ManageBook" method="post">
            <h2>Add New Book</h2>
            <input type="hidden" name="action" value="add">
            <div>
                <input type="number" name="AccNumber" placeholder="Acc. No" required>
                <input type="text" name="bookTitle" placeholder="Book Title" required>
                <input type="text" name="author" placeholder="Author" required>
                <input type="text" name="publisher" placeholder="Publisher" required>
                <button type="submit" class="action-btn">Add Book</button>
            </div>
        </form>

        <form action="ManageBook" method="post">
            <h2>Update Book</h2>
            <input type="hidden" name="action" value="update">
            <div>
                <input type="number" name="AccNumber" placeholder="Acc. No" required>
                <input type="text" name="bookTitle" placeholder="New Book Title" required>
                <input type="text" name="author" placeholder="New Author" required>
                <input type="text" name="publisher" placeholder="New Publisher" required>
                <button type="submit" class="action-btn">Update Book</button>
            </div>
        </form>

        <form action="ManageBook" method="post">
            <h2>Delete Book</h2>
            <input type="hidden" name="action" value="delete">
            <div>
                <input type="number" name="AccNumber" placeholder="Acc. No" required>
                <button type="submit" class="action-btn delete-btn">Delete Book</button>
            </div>
        </form>

        <div class="book-list-container">
            <h2>All Books</h2>
            <table class="book-list">
                <thead>
                    <tr>
                        <th>Acc. No</th>
                        <th>Book Title</th>
                        <th>Author</th>
                        <th>Publisher</th>
                    </tr>
                </thead>
                <tbody>
                    <%
            ManageBookDao bookDao = new ManageBookDao();
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
    <script src="ManageBook.js"></script>
</body>
</html>
