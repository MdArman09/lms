package managebook;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/ManageBook")
public class ManageBookController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private ManageBookDao bookDao = new ManageBookDao();
   
    // Action constants
    private static final String ACTION_ADD = "add";
    private static final String ACTION_UPDATE = "update";
    private static final String ACTION_DELETE = "delete";
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       
        HttpSession currentSession = request.getSession(false);
        if (currentSession == null || currentSession.getAttribute("session_user") == null) {
           
            response.sendRedirect("login.jsp");
            return; 
        }

        String action = request.getParameter("action");

        switch (action) {
            case ACTION_ADD:
                addBook(request, response);
                break;
            case ACTION_UPDATE:
                updateBook(request, response);
                break;
            case ACTION_DELETE:
                deleteBook(request, response);
                break;
            default:
                response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid action");
                break;
        }
    }
    
    private void addBook(HttpServletRequest request, HttpServletResponse response) throws IOException {
        ManageBook book = new ManageBook();
        book.setAcc_no(request.getParameter("AccNumber"));
        book.setTitle(request.getParameter("bookTitle"));
        book.setAuthor(request.getParameter("author"));
        book.setPublisher(request.getParameter("publisher"));

        bookDao.addBook(book);
        response.sendRedirect("manageBooks.jsp?message=Book Added Successfully!"); 
    }

    private void deleteBook(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String acc_no = request.getParameter("AccNumber");
        bookDao.deleteBook(acc_no);
        response.sendRedirect("manageBooks.jsp?message=Book Deleted Successfully!"); 
    }

    private void updateBook(HttpServletRequest request, HttpServletResponse response) throws IOException {
        ManageBook book = new ManageBook();
        book.setAcc_no(request.getParameter("AccNumber"));
        book.setTitle(request.getParameter("bookTitle"));
        book.setAuthor(request.getParameter("author"));
        book.setPublisher(request.getParameter("publisher"));

        bookDao.updateBook(book);
        response.sendRedirect("manageBooks.jsp?message=Book Updated Successfully!"); 
    }
}
