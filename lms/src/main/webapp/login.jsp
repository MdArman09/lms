<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    String logout = request.getParameter("logout");
    if (logout != null && logout.equals("true")) {
%>
    <p style="color:green;">You have successfully logged out!</p>
<%
    }
%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>LMS Login</title>
<link rel="stylesheet" href="login.css">
<link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@20..48,100..700,0..1,-50..200" />
<script>
        // Check if the URL contains the 'signup=success' parameter
        const urlParams = new URLSearchParams(window.location.search);
        if (urlParams.get('signup') === 'success') {
            alert('Sign-up successful, please login.');
        }
    </script>
</head>
<body>
	 <nav>
        <h2 >Centurion Library</h2>
       <a href="signup.jsp" id = "su">Sign Up</a>
    </nav>
    <form action="login" method="post">
        <div class="form-header">
            <h2>Login</h2>
            <img src="pic1.png" alt="Logo">
        </div>
        <div>
            <label for="RegNo">RegNo:</label>
            <input type="text" id="RegNo" name="RegNo" placeholder="Enter user RegNo" required>
        </div>
        <div>
            <label for="password">Password:</label>
            <input type="password" id="password" name="password" placeholder="Enter Password" required>
            
        </div>
        <div>
            <label for="role">Role:</label>
            <select id="role" name="role" >
                <option value="Add role">Add your role</option>
                <option value="student">Student</option>
                <option value="admin">Admin</option>
            </select>
        </div>
        <div>
            <input type="submit" value="Login">
        </div>
    </form>
</body>
</html>