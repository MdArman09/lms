package RequestBook;

import java.math.BigDecimal;
import java.sql.Date;

public class BookRequest {
    private int requestId;
    private String studentRegNo;
    private String bookId;
    private String status;
    private Date issueDate;      
    private Date returnDate;     
    private BigDecimal fine;
    private Date returnedOn;
    private int isReturned;

    public int getIsReturned() {
        return isReturned;
    }

    public void setIsReturned(int isReturned) {
        this.isReturned = isReturned;
    }

	public Date getReturnedOn() {
		return returnedOn;
	}
	public void setReturnedOn(Date returnedOn) {
		this.returnedOn = returnedOn;
	}
	public int getRequestId() {
		return requestId;
	}
	public void setRequestId(int requestId) {
		this.requestId = requestId;
	}
	public String getStudentRegNo() {
		return studentRegNo;
	}
	public void setStudentRegNo(String studentRegNo) {
		this.studentRegNo = studentRegNo;
	}
	public String getBookId() {
		return bookId;
	}
	public void setBookId(String bookId) {
		this.bookId = bookId;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	public Date getIssueDate() {
		return issueDate;
	}
	public void setIssueDate(Date issueDate) {
		this.issueDate = issueDate;
	}
	public Date getReturnDate() {
		return returnDate;
	}
	public void setReturnDate(Date returnDate) {
		this.returnDate = returnDate;
	}
	public BigDecimal getFine() {
		return fine;
	}
	public void setFine(BigDecimal fine) {
		this.fine = fine;
	}
	
	
	@Override
	public String toString() {
		return "BookRequest [requestId=" + requestId + ", studentRegNo=" + studentRegNo + ", bookId=" + bookId
				+ ", status=" + status + ", issueDate=" + issueDate + ", returnDate=" + returnDate + ", fine=" + fine
				+ ", returnedOn=" + returnedOn + ", IsReturned=" + isReturned + "]";
	}
	
	
	public BookRequest() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public BookRequest(int requestId, String studentRegNo, String bookId, String status, Date issueDate,
			Date returnDate, BigDecimal fine, Date returnedOn, int isReturned) {
		super();
		this.requestId = requestId;
		this.studentRegNo = studentRegNo;
		this.bookId = bookId;
		this.status = status;
		this.issueDate = issueDate;
		this.returnDate = returnDate;
		this.fine = fine;
		this.returnedOn = returnedOn;
		this.isReturned = isReturned;
	}
	
    
}

