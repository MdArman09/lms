package signup;

import java.io.IOException;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/signup_controller")
public class controller extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        response.setContentType("text/html;charset=UTF-8");

        String name = request.getParameter("name");
        String email = request.getParameter("email");
        float regno = Float.parseFloat(request.getParameter("regno")); 
        float phone = Float.parseFloat(request.getParameter("phone")); 
        String branch = request.getParameter("branch");
        String program = request.getParameter("program");
        int year = Integer.parseInt(request.getParameter("year"));
        String password = request.getParameter("pass");

        model signup = new model();
        signup.setName(name);
        signup.setEmail(email);
        signup.setRegNo(regno);
        signup.setPhNo(phone);
        signup.setBranch(branch);
        signup.setProgram(program);
        signup.setYear(year);  
        signup.setPassword(password);

        dao signupDAO = new dao();
        try {
            signupDAO.addStudent(signup);
            response.sendRedirect("login.jsp?signup=success");

        } catch (Exception e) {
            e.printStackTrace();
            response.getWriter().println("<h3>Sign-up failed!</h3>");
        }
    }
}
