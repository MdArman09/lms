<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Settings</title>
    <link rel="stylesheet" href="settings.css">
</head>
<body>
    <div class="admin-header">
        <h1>Library Settings</h1>
        <button class="back-btn" onclick="history.back()">Back</button>
    </div>

    <div class="admin-form-container">
        <h2>Update Library Hours</h2>
        <form action="updateLibraryHours" method="post">
            <input type="text" name="hours" placeholder="Enter New Library Hours" required>
            <button type="submit" class="action-btn">Update Hours</button>
        </form>

        <h2>Notifications Settings</h2>
        <button class="action-btn" onclick="toggleNotifications()">Enable Notifications</button>
    </div>

    <script>
        function toggleNotifications() {
            alert('Notifications toggled.');
        }
    </script>
</body>
</html>
