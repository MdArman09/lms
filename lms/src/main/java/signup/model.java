package signup;

public class model {
	private String Name;
	private String Email;
	private float RegNo;
	private float PhNo;
	private String Program;
	private String Branch;
	private int Year;
	private String Password;
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public float getRegNo() {
		return RegNo;
	}
	public void setRegNo(float regNo) {
		RegNo = regNo;
	}
	public float getPhNo() {
		return PhNo;
	}
	public void setPhNo(float phNo) {
		PhNo = phNo;
	}
	public String getProgram() {
		return Program;
	}
	public void setProgram(String program) {
		Program = program;
	}
	public String getBranch() {
		return Branch;
	}
	public void setBranch(String branch) {
		Branch = branch;
	}
	public int getYear() {
		return Year;
	}
	public void setYear(int year) {
		Year = year;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	@Override
	public String toString() {
		return "model [Name=" + Name + ", Email=" + Email + ", RegNo=" + RegNo + ", PhNo=" + PhNo + ", Program="
				+ Program + ", Branch=" + Branch + ", Year=" + Year + ", Password=" + Password + "]";
	}
	public model() {
		super();
		// TODO Auto-generated constructor stub
	}
	public model(String name, String email, float regNo, float phNo, String program, String branch, int year,
			String password) {
		super();
		Name = name;
		Email = email;
		RegNo = regNo;
		PhNo = phNo;
		Program = program;
		Branch = branch;
		Year = year;
		Password = password;
	}
	
	}
	
