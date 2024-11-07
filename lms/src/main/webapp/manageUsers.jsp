<%@ page import="java.util.List" %>
<%@ page import="manageuser.ManageUser" %>
<%@ page import="manageuser.ManageUserDao" %>
<%
    // Create DAO instance and fetch the list of students
    ManageUserDao dao = new ManageUserDao();
    List<ManageUser> studentList = dao.getAllUsers();
%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Manage Users</title>
    <link rel="stylesheet" type="text/css" href="manageUsers.css">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@20..48,100..700,0..1,-50..200" />
</head>
<body>
    <div class="admin-header">
        <h1>Manage Users</h1>
        <button class="back-btn" onclick="history.back()">Back</button>
    </div>

    <div class="admin-dashboard">

        <!-- Delete User Section -->
        <div class="admin-card">
            <h2>Delete User</h2>
            <form action="ManageUserController" method="POST">
                <input type="hidden" name="action" value="delete">
                <div class="form-group">
                    <label for="delete_regNo">Registration Number:</label>
                    <input type="number" name="RegdNo" id="delete_regNo" placeholder="Enter user Registration number.." required>
                </div>
                <button type="submit" class="delete-btn">Delete User</button>
            </form>
        </div>

        <!-- Update User Section -->
        <div class="admin-card">
            <h2>Update User</h2>
            <form action="ManageUserController" method="POST">
                <input type="hidden" name="action" value="update">
                <div class="form-group">
                    <label for="update_regNo">Registration Number:</label>
                    <input type="number" name="RegdNo" id="update_regNo" placeholder="Enter user new Registration Number.." required>
                </div>
                <div class="form-group">
                    <label for="update_name">Name:</label>
                    <input type="text" name="Name" id="update_name" placeholder="Enter user new Name.." required>
                </div>
                <div class="form-group">
                    <label for="update_phNo">Phone Number:</label>
                    <input type="number" name="PhNo" id="update_phNo" placeholder="Enter user new Phone Number.." required>
                </div>
                <div class="form-group">
                    <label for="update_program">Program:</label>
                    <input type="text" name="Program" id="update_program" placeholder="Enter user new Program.." required>
                </div>
                <div class="form-group">
                    <label for="update_branch">Branch:</label>
                    <input type="text" name="Branch" id="update_branch" placeholder="Enter user new Branch.." required>
                </div>
                <button type="submit" class="action-btn">Update User</button>
            </form>
        </div>

        <!-- Student List Section -->
        <div class="admin-card">
            <h2>Student List</h2>
            <table>
                <thead>
                    <tr>
                        <th>Registration Number</th>
                        <th>Name</th>
                        <th>Phone Number</th>
                        <th>Program</th>
                        <th>Branch</th>
                    </tr>
                </thead>
                <tbody>
                    <% 
                    
                    for (ManageUser student : studentList) {
                    %>
                        <tr>
                            <td><%= student.getRegNo() %></td>
                            <td><%= student.getName() %></td>
                            <td><%= student.getPhNo() %></td>
                            <td><%= student.getProgram() %></td>
                            <td><%= student.getBranch() %></td>
                        </tr>
                    <%
                    }
                    %>
                </tbody>
            </table>
        </div>
    </div>
    <script src="manageUsers.js" defer></script>
</body>
</html>
