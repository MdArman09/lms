<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Library Information and Policies</title>
    <link rel="stylesheet" href="LibraryPolicy.css">
</head>
<body>
    <!-- Header -->
    <div class="student-header">
        <h1>Library Information and Policies</h1>
        <button class="back-btn" onclick="history.back()">Back</button>
    </div>

    <!-- Main Content -->
    <div class="student-dashboard">
        <!-- Library Hours -->
        <div class="student-card">
            <h2>Library Hours</h2>
            <ul>
                <li><b>Monday to Friday:</b> 9:30 AM - 9 PM</li>
                <li><b>Saturday:</b> 9:30 AM - 5 PM</li>
                <li><b>Sunday:</b> Closed</li>
            </ul>
        </div>

        <!-- Borrowing Policy -->
        <div class="student-card">
            <h2>Borrowing Policy</h2>
            <ul>
                <li>Registered users can borrow up to 3 books.</li>
                <li><b>Borrowing period:</b> 7 days.</li>
                <li><b>Overdue fines:</b> ₹5 per day.</li>
                <li>Books can be renewed twice if not requested by other users.</li>
            </ul>
        </div>

        <div class="student-card">
            <h2>Book Return Policy</h2>
            <ul>
                <li>Books must be returned by the due date to avoid fines.</li>
                <li><b>Late returns:</b> A fine of ₹5 per day will be charged for overdue books.</li>
                <li>Books can be returned at the circulation desk during library hours.</li>
                <li>In case of lost or damaged books, users must replace the book or pay the replacement cost.</li>
            </ul>
        </div>

        <!-- Library Conduct -->
        <div class="student-card">
            <h2>Library Conduct</h2>
            <ul>
                <li>Maintain silence in the library.</li>
                <li>Keep mobile phones on silent mode.</li>
                <li>No food or drinks allowed inside the library.</li>
            </ul>
        </div>

        <!-- Digital Resources -->
        <div class="student-card">
            <h2>Digital Resources</h2>
            <ul>
                <li>Access e-books and academic journals through your library account.</li>
                <li>Sharing of digital resources is restricted and for academic use only.</li>
            </ul>
        </div>
        
        <div class="student-card">
            <h2>Admin Contact</h2>
            <p>If you face any issues with your account, borrowing, or accessing resources, feel free to contact the library admin:</p>
            <ul>
                <li><b>Email:</b> <a href="mailto:cutmlibraryadmin@cutm.ac.in" target="_blank">cutmlibraryadmin@cutm.ac.in</a></li>
                <li><b>Phone:</b> <a href="tel:+917978206195" target="_blank">+91 7978206195</a></li>
                <li><b>WhatsApp:</b> <a href="https://wa.me/917978206195" target="_blank">Chat on WhatsApp</a></li>
                <li><b>Office Hours:</b> Monday to Friday, 10 AM - 6 PM</li>
            </ul>
        </div>
    </div>

    <!-- Footer -->
    <div class="student-footer">
        <p>&copy; 2024 Centurion University Library | All Rights Reserved</p>
    </div>
</body>
</html>
