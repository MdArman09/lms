package login;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import signup.model;
import javax.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/login")
public class login extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        PrintWriter out = resp.getWriter();
        resp.setContentType("text/html");
        String regNo = req.getParameter("RegNo");  
        String pass = req.getParameter("password");
        String role = req.getParameter("role");

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/lms","yash","yash1234");

            PreparedStatement ps1 = con.prepareStatement("SELECT * FROM signup WHERE RegNo = ?");
            ps1.setString(1, regNo);
            ResultSet rs1 = ps1.executeQuery();

            if (rs1.next()) {
            	
                if (rs1.getString("Password").equals(pass)) {
                	
                    if (rs1.getString("role").equals(role)) {
                        model signup = new model();
                        signup.setName(rs1.getString("Name"));
                        signup.setEmail(rs1.getString("Email"));

                        HttpSession session = req.getSession();
                        session.setAttribute("session_user", signup);
                        signup.setRegNo(Float.parseFloat(regNo)); 
                        System.out.println("Debug - Student RegNo set in session: " + signup.getRegNo());


                        if ("admin".equals(role)) {
                            session.setAttribute("admin_session_user", signup);
                            System.out.println("Admin session created: " + signup.getName());
                            resp.sendRedirect(req.getContextPath() + "/DashBoard.jsp");
                        } else if ("student".equals(role)) {
                            session.setAttribute("student_session_user", signup);
                            System.out.println("Student session created: " + signup.getName());
                            resp.sendRedirect(req.getContextPath() + "/StudentDashboard.jsp");
                        }


                    } else {
                        out.println("<script type=\"text/javascript\">");
                        out.println("alert('Invalid Role! Please try again.');");
                        out.println("location='login.jsp';");
                        out.println("</script>");
                    }
                } else {
                    out.println("<script type=\"text/javascript\">");
                    out.println("alert('Invalid Password! Please try again.');");
                    out.println("location='login.jsp';");
                    out.println("</script>");
                }
            } else {
                out.println("<script type=\"text/javascript\">");
                out.println("alert('Invalid RegNo! Please try again.');");
                out.println("location='login.jsp';");
                out.println("</script>");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
