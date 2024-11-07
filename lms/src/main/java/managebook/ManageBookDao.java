package managebook;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ManageBookDao {

    public static Connection getConnection() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/lms", "yash", "yash1234");
    }

    public void addBook(ManageBook book) {
        String query = "INSERT INTO addbook (acc_no, title, author, publisher) VALUES (?, ?, ?, ?)";
        try (Connection con = ManageBookDao.getConnection();
             PreparedStatement ps = con.prepareStatement(query)) {
            ps.setString(1, book.getAcc_no());
            ps.setString(2, book.getTitle());
            ps.setString(3, book.getAuthor());
            ps.setString(4, book.getPublisher());
            ps.executeUpdate();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace(); 
        }
    }

    public void deleteBook(String acc_no) {
        String query = "DELETE FROM addbook WHERE acc_no = ?";
        try (Connection con = ManageBookDao.getConnection();
             PreparedStatement ps = con.prepareStatement(query)) {
            ps.setString(1, acc_no);
            ps.executeUpdate();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace(); 
        }
    }

    public void updateBook(ManageBook book) {
        String query = "UPDATE addbook SET title = ?, author = ?, publisher = ? WHERE acc_no = ?";
        try (Connection con = ManageBookDao.getConnection();
             PreparedStatement ps = con.prepareStatement(query)) {
            ps.setString(1, book.getTitle());
            ps.setString(2, book.getAuthor());
            ps.setString(3, book.getPublisher());
            ps.setString(4, book.getAcc_no());
            ps.executeUpdate();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace(); 
        }
    }

    public ManageBook getBookByAccNo(String acc_no) {
        ManageBook book = null;
        String query = "SELECT * FROM addbook WHERE acc_no = ?";
        try (Connection con = ManageBookDao.getConnection();
             PreparedStatement ps = con.prepareStatement(query)) {
            ps.setString(1, acc_no);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                book = new ManageBook();
                book.setAcc_no(rs.getString("acc_no")); 
                book.setTitle(rs.getString("title"));   
                book.setAuthor(rs.getString("author"));
                book.setPublisher(rs.getString("publisher"));
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace(); 
        }
        return book;
    }

    public List<ManageBook> getAllBooks() {
        List<ManageBook> books = new ArrayList<>();
        String query = "SELECT * FROM addbook";
        try (Connection con = ManageBookDao.getConnection();
             PreparedStatement ps = con.prepareStatement(query);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                ManageBook book = new ManageBook();
                book.setAcc_no(rs.getString("acc_no")); 
                book.setTitle(rs.getString("title"));   
                book.setAuthor(rs.getString("author"));
                book.setPublisher(rs.getString("publisher"));
                books.add(book);
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace(); 
        }
        return books;
    }
}
