<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="RequestBookController" method="post">
<input type="hidden" name="request_id" value="${request.requestId}">
<input type="hidden" name="action" value="request">
    <label for="book_id">Book ID:</label>
    <input type="text" id="book_id" name="book_id" required>
    <button type="submit">Request Book</button>
</form>
</body>
</html>