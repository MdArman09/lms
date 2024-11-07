<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="RequestBook.BookRequestDao" %>
<%@ page import="RequestBook.BookRequest" %>
<%@ page import="java.util.List" %>
<%@ page import="java.text.SimpleDateFormat" %>

<!DOCTYPE html>
<html>
<head>
    <title>Reports - Issued Books</title>
    <link rel="stylesheet" href="report.css">
</head>
<body>
    <h1>Issued Books Report</h1>

<%

BookRequestDao dao = new BookRequestDao();
List<BookRequest> issuedBooks = dao.getAllIssuedBooks();
out.println("Number of issued books: " + issuedBooks.size());
    SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
%>

     <table border="1">
            <tr>
                <th>Student ID</th>
                <th>Book ID</th>
                <th>Issue Date</th>
                <th>Return Date</th>
                <th>Fine</th>
                <th>Returned On</th>
                <th>Status</th>
            </tr>
            <% for (BookRequest book : issuedBooks) { %>
            <tr>
                <td><%= book.getStudentRegNo() %></td>
                <td><%= book.getBookId() %></td>
                <td><%= book.getIssueDate() %></td>
                <td><%= book.getReturnDate() != null ? book.getReturnDate() : "Not returned yet" %></td>
                <td><%= book.getFine() != null ? book.getFine() : "N/A" %></td>
                <td><%= book.getReturnedOn() != null ? book.getReturnedOn() : "N/A" %></td>
                <td><%= book.getIsReturned() == 1 ? "Returned" : "Issued" %></td>
            </tr>
            <% } %>
        </table>
</body>
</html>
