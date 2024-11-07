package RequestBook;

import java.io.IOException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import signup.model; // Assuming this represents the Student model

@WebServlet("/RequestBookController")
public class RequestBookController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private BookRequestDao bookRequestDao = new BookRequestDao();
    
    private static final String ACTION_REQUEST = "request";
    private static final String ACTION_APPROVE = "approve";
    private static final String ACTION_REJECT = "reject";

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession(false);  
        if (session == null || session.getAttribute("session_user") == null) {
            response.sendRedirect("login.jsp");
            return;
        }

        model student = (model) session.getAttribute("session_user");  
        String action = request.getParameter("action");

        switch (action) {
            case ACTION_REQUEST:  
                handleBookRequest(request, response, student);
                break;

            case ACTION_APPROVE:  
                handleRequestApproval(request, response);
                break;

            case ACTION_REJECT:  
                handleRequestRejection(request, response);
                break;

            default:
                response.getWriter().println("Invalid action.");
                break;
        }
    }

    private void handleBookRequest(HttpServletRequest request, HttpServletResponse response, model student) throws IOException {
        String bookId = request.getParameter("book_id");

        if (bookId == null || bookId.isEmpty()) {
            response.getWriter().println("Invalid book ID provided.");
            return;
        }

        if (student == null || student.getRegNo() == 0.0) {
            response.getWriter().println("Invalid student information.");
            return;
        }

        bookRequestDao.createRequest(student.getRegNo(), bookId);
        response.sendRedirect("StudentDashboard.jsp");
        
        System.out.println("Debug - Retrieved student from session: " + student);

    }

    private void handleRequestApproval(HttpServletRequest request, HttpServletResponse response) throws IOException {
        bookRequestDao.updateFines();
        
        String requestIdToApprove = request.getParameter("request_id");
        if (requestIdToApprove != null) {
            BookRequest requestToApprove = bookRequestDao.getRequestById(requestIdToApprove);
            
            if (requestToApprove != null) {
                bookRequestDao.updateRequestStatus(requestIdToApprove, "approved");
                bookRequestDao.insertIssuedBook(requestToApprove.getStudentRegNo(), requestToApprove.getBookId());
                request.setAttribute("message", "Request approved.");
                response.sendRedirect("issueBooks.jsp");
            } else {
                response.getWriter().println("Invalid request ID.");
            }
        } else {
            response.getWriter().println("Invalid request ID.");
        }
    }

    private void handleRequestRejection(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String requestIdToReject = request.getParameter("request_id");
        if (requestIdToReject != null) {
            bookRequestDao.updateRequestStatus(requestIdToReject, "rejected");
            request.setAttribute("message", "Request rejected.");
            response.sendRedirect("issueBooks.jsp");
        } else {
            response.getWriter().println("Invalid request ID.");
        }
    }
}
