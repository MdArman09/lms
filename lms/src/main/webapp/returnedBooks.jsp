<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="RequestBook.BookRequestDao" %>
<%@ page import="RequestBook.BookRequest" %>
<%@ page import="java.util.List" %>
<%@ page import="java.text.SimpleDateFormat" %>

<!DOCTYPE html>
<html>
<head>
    <title>Returned Books</title>
    <link rel="stylesheet" href="style.css">
</head>
<body>
    <h1>Returned Books</h1>

<%
    signup.model student = (signup.model) session.getAttribute("session_user");
    if (student == null) {
        response.sendRedirect("login.jsp");
        return;
    }

    float studentRegNo = student.getRegNo(); 

    BookRequestDao dao = new BookRequestDao();
    List<BookRequest> returnedBooks = dao.getReturnedBooksByStudent(studentRegNo);

    SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
%>

    <table border="1">
        <tr>
            <th>Book ID</th>
            <th>Issue Date</th>
            <th>Return Date</th>
            <th>Returned On</th>
            <th>Fine</th>
        </tr>

        <%
            for (BookRequest book : returnedBooks) {
        %>
        <tr>
            <td><%= book.getBookId() %></td>
            <td><%= book.getIssueDate() != null ? dateFormat.format(book.getIssueDate()) : "N/A" %></td>
            <td><%= book.getReturnDate() != null ? dateFormat.format(book.getReturnDate()) : "N/A" %></td>
            <td><%= book.getReturnedOn() != null ? dateFormat.format(book.getReturnedOn()) : "N/A" %></td>
            <td><%= book.getFine() %></td>
        </tr>
        <%
            }
        %>
    </table>
</body>
</html>
