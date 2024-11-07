package ReturnBook;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@WebServlet("/returnBook")
public class ReturnBookController extends HttpServlet {

    private static final String DB_URL = "jdbc:mysql://localhost:3306/lms";
    private static final String DB_USER = "yash";
    private static final String DB_PASSWORD = "yash1234";

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String userId = request.getParameter("userId");
        String bookId = request.getParameter("bookId");

        String userCheckQuery = "SELECT COUNT(*) FROM issued_books WHERE student_reg_no = ?";
        String bookCheckQuery = "SELECT COUNT(*) FROM addbook WHERE acc_no = ?";
        String issuedBookCheckQuery = "SELECT is_returned FROM issued_books WHERE student_reg_no = ? AND book_id = ?";
        String updateQuery = "UPDATE issued_books SET is_returned = 1, returned_on = NOW() WHERE student_reg_no = ? AND book_id = ? AND is_returned = 0";

        try (Connection con = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {

            // Check if user exists
            try (PreparedStatement userCheckStmt = con.prepareStatement(userCheckQuery)) {
                userCheckStmt.setString(1, userId);
                ResultSet userResult = userCheckStmt.executeQuery();
                if (userResult.next() && userResult.getInt(1) == 0) {
                    response.getWriter().write("Invalid User ID.");
                    return;
                }
            }

            // Check if book exists
            try (PreparedStatement bookCheckStmt = con.prepareStatement(bookCheckQuery)) {
                bookCheckStmt.setString(1, bookId);
                ResultSet bookResult = bookCheckStmt.executeQuery();
                if (bookResult.next() && bookResult.getInt(1) == 0) {
                    response.getWriter().write("Invalid Book ID.");
                    return;
                }
            }

            // Check if issued and not yet returned
            boolean isIssuedAndNotReturned = false;
            try (PreparedStatement issuedBookCheckStmt = con.prepareStatement(issuedBookCheckQuery)) {
                issuedBookCheckStmt.setString(1, userId);
                issuedBookCheckStmt.setString(2, bookId);
                ResultSet issuedBookResult = issuedBookCheckStmt.executeQuery();

                if (issuedBookResult.next()) {
                    isIssuedAndNotReturned = issuedBookResult.getInt("is_returned") == 0;
                } else {
                    response.getWriter().write("No matching issued book found.");
                    return;
                }
            }

            // Attempt to update if issued and not returned
            if (isIssuedAndNotReturned) {
                try (PreparedStatement ps = con.prepareStatement(updateQuery)) {
                    ps.setString(1, userId);
                    ps.setString(2, bookId);
                    int rowsUpdated = ps.executeUpdate();

                    if (rowsUpdated > 0) {
                        response.getWriter().write("Book returned successfully.");
                    } else {
                        response.getWriter().write("Failed to update return status. Debug info: Student ID - " + userId + ", Book ID - " + bookId);
                    }
                }
            } else {
                response.getWriter().write("The book has already been returned.");
            }

        } catch (SQLException e) {
            e.printStackTrace();
            response.getWriter().write("An error occurred while returning the book.");
        }
    }
}
