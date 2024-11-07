<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="RequestBook.BookRequestDao" %>
<%@ page import="RequestBook.BookRequest" %>
<%@ page import="java.util.List" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.Date" %>
<%@ page import="signup.model" %>

<!DOCTYPE html>
<html>
<head>
    <title>Borrowed Books</title>
    <link rel="stylesheet" href="style.css">
</head>
<body>
    <h1>Borrowed Books</h1>

<%
    model student = (model) session.getAttribute("session_user");
    if (student == null) {
        response.sendRedirect("login.jsp");
        return;
    }
    float studentRegNo = student.getRegNo();

    BookRequestDao dao = new BookRequestDao();
    List<BookRequest> borrowedBooks = dao.getBorrowedBooksByStudent(studentRegNo);

    if (borrowedBooks.isEmpty()) {
%>
        <p>No borrowed books found.</p>
<%
    } else {
%>

    <%
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy"); 
    %>

    <table border="1">
        <tr>
            <th>Book ID</th>
            <th>Issue Date</th>
            <th>Return Date</th>
        </tr>

        <%
            for (BookRequest book : borrowedBooks) {
        %>
        <tr>
            <td><%= book.getBookId() %></td>
            <td><%= book.getIssueDate() != null ? dateFormat.format(book.getIssueDate()) : "N/A" %></td>
            <td><%= book.getReturnDate() != null ? dateFormat.format(book.getReturnDate()) : "N/A" %></td>
        </tr>
        <%
            }
        %>
    </table>
<%
    }
%>
</body>
</html>
