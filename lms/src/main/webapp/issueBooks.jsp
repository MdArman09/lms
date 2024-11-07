<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Issue Books</title>
    <link rel="stylesheet" href="issueBooks.css">
    <script>
        function confirmApproval(requestId) {
            if (confirm("Are you sure you want to approve this request?")) {
                document.getElementById("approveForm" + requestId).submit();
            }
        }
        function confirmRejection(requestId) {
            if (confirm("Are you sure you want to reject this request?")) {
                document.getElementById("rejectForm" + requestId).submit();
            }
        }
    </script>
</head>
<body>
    <div class="admin-header">
        <h1>Issue Books</h1>
        <button class="back-btn" onclick="history.back()">Back</button> 
    </div>
    
    <%@ page import="java.util.List" %>
    <%@ page import="RequestBook.BookRequestDao" %>
    <%@ page import="RequestBook.BookRequest" %>

    <%
        BookRequestDao dao = new BookRequestDao();
        List<BookRequest> requests = dao.getAllPendingRequests();
        request.setAttribute("requests", requests); 
    %>

    <table>
        <tr>
            <th>Request ID</th>
            <th>Student RegNo</th>
            <th>Book ID</th>
            <th>Status</th>
            <th>Actions</th>
        </tr>

        <%
            for (BookRequest bookRequest : requests) {
        %>
            <tr>
                <td><%= bookRequest.getRequestId() %></td>
                <td><%= bookRequest.getStudentRegNo() %></td>
                <td><%= bookRequest.getBookId() %></td>
                <td><%= bookRequest.getStatus() %></td>
                <td>
                    <form id="approveForm<%= bookRequest.getRequestId() %>" action="RequestBookController" method="post">
                        <input type="hidden" name="action" value="approve">
                        <input type="hidden" name="request_id" value="<%= bookRequest.getRequestId() %>">
                        <button type="button" onclick="confirmApproval('<%= bookRequest.getRequestId() %>')">Approve</button>
                    </form>

                    <form id="rejectForm<%= bookRequest.getRequestId() %>" action="RequestBookController" method="post">
                        <input type="hidden" name="action" value="reject">
                        <input type="hidden" name="request_id" value="<%= bookRequest.getRequestId() %>">
                        <button type="button" onclick="confirmRejection('<%= bookRequest.getRequestId() %>')">Reject</button>
                    </form>
                </td>
            </tr>
        <%
            } 
        %>
    </table>
</body>
</html>
