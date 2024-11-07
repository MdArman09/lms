package manageuser;

public class ManageUser {
	
	private String Name;
	private String Email;
	private String Password;
	private long RegNo;
	private long PhNo;
	private String Branch;
	private String Program;
	private String Year;
	private String Role;
	
	
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
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	 
	public long getRegNo() {
		return RegNo;
	}
	public void setRegNo(long regNo) {
		RegNo = regNo;
	}
	 
	public long getPhNo() {
		return PhNo;
	}
	public void setPhNo(long phNo) {
		PhNo = phNo;
	}
	public String getBranch() {
		return Branch;
	}
	public void setBranch(String branch) {
		Branch = branch;
	}
	public String getProgram() {
		return Program;
	}
	public void setProgram(String program) {
		Program = program;
	}
	public String getYear() {
		return Year;
	}
	public void setYear(String year) {
		Year = year;
	}
	public String getRole() {
		return Role;
	}
	public void setRole(String role) {
		Role = role;
	}
	@Override
	public String toString() {
		return "ManageUser [Name=" + Name + ", Email=" + Email + ", Password=" + Password + ", RegNo=" + RegNo
				+ ", PhNo=" + PhNo + ", Branch=" + Branch + ", Program=" + Program + ", Year=" + Year + ", Role=" + Role
				+ "]";
	}

}