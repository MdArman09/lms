package manageuser;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/ManageUserController")
public class ManageUserController extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private ManageUserDao dao = new ManageUserDao();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String action = req.getParameter("action");

        HttpSession session = req.getSession(false);
        if (session != null && session.getAttribute("session_user") != null) {
            
            try {
                if ("update".equals(action)) {
                    updateUser(req, res);
                } else if ("delete".equals(action)) {
                    deleteUser(req, res);
                } else {
                    throw new IllegalArgumentException("Invalid action: " + action);
                }
            } catch (Exception e) {
                res.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Error processing request: " + e.getMessage());
            }
        } else {
            res.sendRedirect("login.jsp"); 
        }
    }

    private void updateUser(HttpServletRequest req, HttpServletResponse res) throws IOException, ClassNotFoundException {
        PrintWriter out = res.getWriter();
        ManageUser user = new ManageUser();
        
        try {
            user.setRegNo(Long.parseLong(req.getParameter("RegdNo")));
            user.setName(req.getParameter("Name"));
            user.setPhNo(Long.parseLong(req.getParameter("PhNo")));
            user.setProgram(req.getParameter("Program"));
            user.setBranch(req.getParameter("Branch"));

            dao.updateUser(user);
            out.println("<script type=\"text/javascript\">");
            out.println("alert('User Updated Successfully!');");
            out.println("location='manageUsers.jsp';");
            out.println("</script>");
        } catch (NumberFormatException e) {
            out.println("<script type=\"text/javascript\">");
            out.println("alert('Invalid input: " + e.getMessage() + "');");
            out.println("location='manageUsers.jsp';");
            out.println("</script>");
        }
    }

    private void deleteUser(HttpServletRequest req, HttpServletResponse res) throws IOException, ClassNotFoundException {
        PrintWriter out = res.getWriter();
        ManageUser user = new ManageUser();
        
        try {
            user.setRegNo(Long.parseLong(req.getParameter("RegdNo")));
            dao.deleteUser(user);
            out.println("<script type=\"text/javascript\">");
            out.println("alert('User Deleted Successfully!');");
            out.println("location='manageUsers.jsp';");
            out.println("</script>");
        } catch (NumberFormatException e) {
            out.println("<script type=\"text/javascript\">");
            out.println("alert('Invalid Registration Number: " + e.getMessage() + "');");
            out.println("location='manageUsers.jsp';");
            out.println("</script>");
        }
    }
}
