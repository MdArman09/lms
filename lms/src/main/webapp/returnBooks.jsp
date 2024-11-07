<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Return Books</title>
    <link rel="stylesheet" href="returnBooks.css">
</head>
<body>
    <div class="admin-header">
        <h1>Return Books</h1>
        <button class="back-btn" onclick="history.back()">Back</button>
    </div>

    <div class="admin-form-container">
        <form action="returnBook" method="post">
            <h2>Return a Book</h2>
            <input type="text" name="userId" placeholder="User ID" required>
            <input type="text" name="bookId" placeholder="Book ID" required>
            <button type="submit" class="action-btn">Return Book</button>
        </form>
    </div>
</body>
</html>
