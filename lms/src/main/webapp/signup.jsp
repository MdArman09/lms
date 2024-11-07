<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>LMS SignUp</title>
    <link rel="stylesheet" href="signup.css">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@20..48,100..700,0..1,-50..200" />
</head>
<body>
    <nav>
        <h2 id="library-title" data-text="Centurion Library">Centurion Library</h2>
        <a id="login" href="login.jsp">Login</a>
    </nav>
    <form action="signup_controller" method="post">
        <div class="form-header">
            <h2>Sign Up</h2>
            <img alt="Logo" src="pic1.png">
        </div>
        <div class="form-grid">
            <div>
                <label for="name">Name:</label>
                <input type="text" id="name" name="name" required placeholder="Enter your name">
            </div>
            <div>
                <label for="email">Email:</label>
                <input type="email" id="email" name="email" required placeholder="Enter your email">
            </div>
            <div>
                <label for="regno">Registration Number:</label>
                <input type="number" id="regno" name="regno" step="any" required placeholder="Enter your reg number">
            </div>
            <div>
                <label for="phone">Phone Number:</label>
                <input type="number" id="phone" name="phone" step="any" required placeholder="Enter your phone number">
            </div>
            <div>
                <label for="program">Program:</label>
                <select id="program" name="program" required onchange="updateBranches()">
                    <option value="">Select your Program</option>
                    <option value="btech">B.Tech</option>
                    <option value="mtech">M.Tech</option>
                    <option value="phd">Ph.D.</option>
                </select>
            </div>
            <div>
                <label for="branch">Branch:</label>
                <select id="branch" name="branch" required>
                    <!-- Branch options will be populated here -->
                </select>
            </div>
            <div>
                <label for="year">Pass Out Year:</label>
                <select id="year" name="year" required>
                    <option value="">Select your Pass Out Year</option>
                    <option value="2025">2025</option>
                    <option value="2026">2026</option>
                    <option value="2027">2027</option>
                    <option value="2028">2028</option>
                </select>
            </div>
            <div>
                <label for="password">Password:</label>
                <input type="password" id="password" name="pass" required placeholder="Enter your password">
                <span class="material-symbols-outlined eye-icon" id="toggle">
                    visibility_off
                </span>
            </div>
            <div>
                <input type="submit" value="Sign Up" id="signup">
            </div>
        </div>
        <!-- Optional: Add a section for displaying error messages -->
        <div id="error-message" style="color:red;"></div>
    </form>
    <script src="signup.js"></script>
</body>
</html>
