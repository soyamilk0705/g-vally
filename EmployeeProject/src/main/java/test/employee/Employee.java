package test.employee;

public class Employee {
	private String id;
	private String pwd;
	private String name;
	private String phone;
	private String email;
	private String hireDT;
	
	public Employee(String id, String pwd, String name, String phone, String email, String hireDT) {
		super();
		this.id = id;
		this.pwd = pwd;
		this.name = name;
		this.phone = phone;
		this.email = email;
		this.hireDT = hireDT;
	}
	
	

	@Override
	public String toString() {
		return "Employee [id=" + id + ", pwd=" + pwd + ", name=" + name + ", phone=" + phone + ", email=" + email
				+ ", hireDT=" + hireDT + "]";
	}


	public String getId() {
		return id;
	}

	public String getPwd() {
		return pwd;
	}

	public String getName() {
		return name;
	}

	public String getPhone() {
		return phone;
	}

	public String getEmail() {
		return email;
	}

	public String getHireDT() {
		return hireDT;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setHireDT(String hireDT) {
		this.hireDT = hireDT;
	}
	
	
}
