package manageuser;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ManageUserDao {
    public static Connection getConnection() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/lms", "yash", "yash1234");
    }

    public void updateUser(ManageUser user) throws ClassNotFoundException {
        String query = "UPDATE signup SET Name = ?, PhNo = ?, Branch = ?, Program = ? WHERE RegNo = ?";
        try (Connection con = ManageUserDao.getConnection();
             PreparedStatement ps = con.prepareStatement(query)) {

            ps.setString(1, user.getName());
            ps.setLong(2, user.getPhNo());
            ps.setString(3, user.getBranch());
            ps.setString(4, user.getProgram());
            ps.setLong(5, user.getRegNo());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteUser(ManageUser user) throws ClassNotFoundException {
        String query = "DELETE FROM signup WHERE RegNo = ?";
        try (Connection con = ManageUserDao.getConnection();
             PreparedStatement ps = con.prepareStatement(query)) {

            ps.setLong(1, user.getRegNo());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ManageUser getUserByName(String name) throws ClassNotFoundException {
        ManageUser user = null;
        String query = "SELECT * FROM signup WHERE Name = ?"; 

        try (Connection con = ManageUserDao.getConnection();
             PreparedStatement ps = con.prepareStatement(query)) {

            ps.setString(1, name);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                user = new ManageUser();
                user.setName(rs.getString("Name"));
                user.setEmail(rs.getString("Email"));
                user.setPassword(rs.getString("Password"));
                user.setRegNo(rs.getLong("RegNo"));
                user.setPhNo(rs.getLong("PhNo")); 
                user.setBranch(rs.getString("Branch"));
                user.setProgram(rs.getString("Program"));
            }
        } catch (SQLException e) {
            
            e.printStackTrace();
        }
        return user;
    }

    public List<ManageUser> getAllUsers() throws ClassNotFoundException {
        List<ManageUser> users = new ArrayList<>();
        String query = "SELECT * FROM signup";

        try (Connection con = ManageUserDao.getConnection();
             PreparedStatement ps = con.prepareStatement(query);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                ManageUser user = new ManageUser();
                user.setName(rs.getString("Name"));
                user.setEmail(rs.getString("Email"));
                user.setPassword(rs.getString("Password"));
                user.setRegNo(rs.getLong("RegNo")); 
                user.setPhNo(rs.getLong("PhNo"));
                user.setBranch(rs.getString("Branch"));
                user.setProgram(rs.getString("Program"));

                users.add(user);
            }
        } catch (SQLException e) {
           
            e.printStackTrace();
        }
        return users;
    }
}
