package RequestBook;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import managebook.ManageBookDao;

public class BookRequestDao {

    public void createRequest(float regNo, String bookId) {
        try (Connection con = ManageBookDao.getConnection();
             PreparedStatement ps = con.prepareStatement(
                "INSERT INTO book_requests (student_regno, book_id, status) VALUES (?, ?, 'pending')")) {

            ps.setLong(1, (long) regNo); 
            ps.setString(2, bookId);
            
            int result = ps.executeUpdate();
            if (result > 0) {
                System.out.println("Book request created successfully!");
            } else {
                System.out.println("Failed to create book request.");
            }

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public List<BookRequest> getAllPendingRequests() {
        List<BookRequest> requests = new ArrayList<>();
        try (Connection con = ManageBookDao.getConnection();
             PreparedStatement ps = con.prepareStatement("SELECT * FROM book_requests WHERE status = 'pending'")) {

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                BookRequest request = new BookRequest();
                request.setRequestId(rs.getInt("request_id"));
                request.setStudentRegNo(rs.getString("student_regno"));  
                request.setBookId(rs.getString("book_id"));
                request.setStatus(rs.getString("status"));

                // Add to list
                requests.add(request);
            }

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        return requests;
    }

    public void updateRequestStatus(String requestId, String status) {
        try (Connection con = ManageBookDao.getConnection();
             PreparedStatement ps = con.prepareStatement(
                "UPDATE book_requests SET status = ?, approved_date = NOW() WHERE request_id = ?")) {
            System.out.println("Updating Request ID: " + requestId + " to Status: " + status);

            ps.setString(1, status);
            ps.setString(2, requestId);

            int result = ps.executeUpdate();
            if (result > 0) {
                System.out.println("Request status updated successfully!");
            } else {
                System.out.println("Failed to update request status.");
            }

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    // New method to insert into issued_books
    public void insertIssuedBook(String studentRegNo, String bookId) {
        String sql = "INSERT INTO issued_books (student_reg_no, book_id, issue_date, return_date) " +
                     "VALUES (?, ?, CURDATE(), DATE_ADD(CURDATE(), INTERVAL 7 DAY))"; 
        
        try (Connection con = ManageBookDao.getConnection();
             PreparedStatement stmt = con.prepareStatement(sql)) {
             
            stmt.setString(1, studentRegNo);
            stmt.setString(2, bookId);
            stmt.executeUpdate();
            System.out.println("Book issued successfully!");

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    
    public BookRequest getRequestById(String requestId) {
        BookRequest request = null;
        try (Connection con = ManageBookDao.getConnection();
             PreparedStatement ps = con.prepareStatement("SELECT * FROM book_requests WHERE request_id = ?")) {

            ps.setString(1, requestId);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                request = new BookRequest();
                request.setRequestId(rs.getInt("request_id"));
                request.setStudentRegNo(rs.getString("student_regno"));
                request.setBookId(rs.getString("book_id"));
                request.setStatus(rs.getString("status"));
            }

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return request;
    }
    
    public void updateFines() {
        String sql = "UPDATE issued_books " +
                     "SET fine = DATEDIFF(CURDATE(), return_date) * 5 " + 
                     "WHERE return_date < CURDATE() AND fine = 0"; 

        try (Connection con = ManageBookDao.getConnection();
             PreparedStatement stmt = con.prepareStatement(sql)) {

            int rowsUpdated = stmt.executeUpdate();
            System.out.println("Fines updated for " + rowsUpdated + " overdue books.");

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    
    public List<BookRequest> getBorrowedBooksByStudent(float regNo) {
        List<BookRequest> borrowedBooks = new ArrayList<>();
        // Update query to only fetch records where is_returned is 0 (book not returned)
        String sql = "SELECT * FROM issued_books WHERE student_reg_no = ? AND is_returned = 0";

        try (Connection con = ManageBookDao.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setFloat(1, regNo);
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                BookRequest request = new BookRequest();
                request.setBookId(rs.getString("book_id"));
                request.setIssueDate(rs.getDate("issue_date"));
                request.setReturnDate(rs.getDate("return_date"));
                borrowedBooks.add(request);
            }

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        return borrowedBooks;
    }
    
    public List<BookRequest> getReturnedBooksByStudent(float regNo) {
        List<BookRequest> returnedBooks = new ArrayList<>();
        String sql = "SELECT * FROM issued_books WHERE student_reg_no = ? AND is_returned = 1";

        try (Connection con = ManageBookDao.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setFloat(1, regNo);
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                BookRequest request = new BookRequest();
                request.setBookId(rs.getString("book_id"));
                request.setIssueDate(rs.getDate("issue_date"));
                request.setReturnDate(rs.getDate("return_date"));
                request.setReturnedOn(rs.getDate("returned_on"));
                request.setFine(rs.getBigDecimal("fine"));
                returnedBooks.add(request);
            }

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        return returnedBooks;
    }
    
    public List<BookRequest> getAllIssuedBooks() {
        List<BookRequest> issuedBooks = new ArrayList<>();
        String sql = "SELECT * FROM issued_books";

        try (Connection con = ManageBookDao.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                BookRequest request = new BookRequest();
                request.setStudentRegNo(rs.getString("student_reg_no"));
                request.setBookId(rs.getString("book_id"));
                request.setIssueDate(rs.getDate("issue_date"));
                request.setReturnDate(rs.getDate("return_date"));
                request.setFine(rs.getBigDecimal("fine"));
                request.setIsReturned(rs.getInt("is_returned"));
                request.setReturnedOn(rs.getDate("returned_on"));
                
//                System.out.println("BookRequest: " + request);
                
                issuedBooks.add(request);
            }


        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        return issuedBooks;
    }


}
