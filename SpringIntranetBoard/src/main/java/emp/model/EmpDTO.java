package emp.model;

public class EmpDTO {
	
	private int num;				// EMP_CODE
	private String name;			// EMP_NAME
	private String pwd;			// EMP_LOGIN_PASSWD
	private String id;				// EMP_LOGIN_ID
	
		
	public EmpDTO() {
		super();
	}

	@Override
	public String toString() {
		return "EmpDTO [num=" + num + ", name=" + name + ", pwd=" + pwd + ", id=" + id + "]";
	}

	public int getNum() {
		return num;
	}

	public String getName() {
		return name;
	}

	public String getPwd() {
		return pwd;
	}

	public String getId() {
		return id;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int geteMP_CODE() {
		return num;
	}

	public String getEMP_NAME() {
		return name;
	}

	public String getEMP_LOGIN_PASSWD() {
		return pwd;
	}

	public String getEMP_LOGIN_ID() {
		return id;
	}

	public void setEMP_CODE(int eMP_CODE) {
		this.num = eMP_CODE;
	}

	public void setEMP_NAME(String eMP_NAME) {
		this.name = eMP_NAME;
	}

	public void setEMP_LOGIN_PASSWD(String eMP_LOGIN_PASSWD) {
		this.pwd = eMP_LOGIN_PASSWD;
	}

	public void setEMP_LOGIN_ID(String eMP_LOGIN_ID) {
		this.id = eMP_LOGIN_ID;
	}
	
	
}
