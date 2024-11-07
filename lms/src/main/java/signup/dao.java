package signup;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class dao {
	public static Connection getConnection() throws SQLException, ClassNotFoundException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		return DriverManager.getConnection("jdbc:mysql://localhost:3306/lms","yash", "yash1234");		
	}
	public void addStudent(model signup) {
		Connection con = null;
		PreparedStatement su=null;
		try {
			con= dao.getConnection();
			su = con.prepareStatement("INSERT INTO signup (Name, Email, RegNo, PhNo, Branch, Program, Year, Password) VALUES (?,?,?,?,?,?,?,?)");
			su.setString(1, signup.getName());
			su.setString(2, signup.getEmail());
			su.setFloat(3, signup.getRegNo());
			su.setFloat(4, signup.getPhNo());
			su.setString(5, signup.getBranch());
			su.setString(6, signup.getProgram());
			su.setInt(7, signup.getYear());
			su.setString(8, signup.getPassword());
			su.executeUpdate();
		}
		catch(Exception e1){
			e1.printStackTrace();
		}
		finally {
		    try {
		        if (su != null) {
		            su.close();
		        }
		        if (con != null) {
		            con.close();
		        }
		    } catch (SQLException e2) {
		        e2.printStackTrace();
		    }
		}

	}
}
