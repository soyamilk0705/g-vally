package test.jdbc.oracle;

import java.sql.SQLException;

/**
 * Employee DataModel class
 * OracleDBMS의 EmpTBL의 레코드 하나와 일치되는 내용으로
 * 기본 데이터 클래스임.
 * 
 * @author Anyware
 *
 */
public class EmployeeDTO extends EmployeeService {
	private String id;
	private String pwd;
	private String name;
	private String phone;
	private String email;
	private String hireDT;
	
	public EmployeeDTO() {
		super();	 // 비어있어도 상관 없음(컴파일러가 자동으로 넣어줌)
	}
	
	public EmployeeDTO(String id, String pwd, String name, String phone, String email, String hireDT) {
		super();
		this.id = id;
		this.pwd = pwd;
		this.name = name;
		this.phone = phone;
		this.email = email;
		this.hireDT = hireDT;
	}
	
	public EmployeeDTO getLogin() throws SQLException {
		EmployeeDTO dto = login(this);
		this.id = dto.getId();
		this.pwd = dto.getPwd();
		this.name = dto.getName();
		this.phone = dto.getPhone();
		this.email = dto.getEmail();
		this.hireDT = dto.getHireDT();
		return this; 
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