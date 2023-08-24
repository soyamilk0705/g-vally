package emp.model;

public class EmpDTO {
	private String empNum;
	private String name;
	private String pwd;
	private String role;
	private String hobby;
	private String comment;
	
	public EmpDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public EmpDTO(String empNum, String name, String pwd, String role, String hobby, String comment) {
		super();
		this.empNum = empNum;
		this.name = name;
		this.pwd = pwd;
		this.role = role;
		this.hobby = hobby;
		this.comment = comment;
	}

	@Override
	public String toString() {
		return "EmployeeDTO [empNum=" + empNum + ", name=" + name + ", pwd=" + pwd + ", role=" + role + ", hobby="
				+ hobby + ", comment=" + comment + "]";
	}

	public String getEmpNum() {
		return empNum;
	}

	public String getName() {
		return name;
	}

	public String getPwd() {
		return pwd;
	}

	public String getRole() {
		return role;
	}

	public String getHobby() {
		return hobby;
	}

	public String getComment() {
		return comment;
	}

	public void setEmpNum(String empNum) {
		this.empNum = empNum;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public void setHobby(String hobby) {
		this.hobby = hobby;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}
	
	
}
