package managebook;

public class ManageBook {
	private String acc_no;
    private String title;
    private String author;
    private String publisher;
	public String getAcc_no() {
		return acc_no;
	}
	public void setAcc_no(String acc_no) {
		this.acc_no = acc_no;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public ManageBook(String acc_no, String title, String author, String publisher) {
		super();
		this.acc_no = acc_no;
		this.title = title;
		this.author = author;
		this.publisher = publisher;
	}
	
	public ManageBook() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "ManageBook [acc_no=" + acc_no + ", title=" + title + ", author=" + author + ", publisher=" + publisher
				+ "]";
	}

    

    
}
