package test.jdbc.oracle;
/**
 * Employee DataModel class
 * Oracle DBMS 의 EmpTBL의 레코드 하나와 일치되는 내용으로
 * 기본 데이터 클래스임.
 * & hashCode(), equals()를 tunning 할 수 있는 상황들 
 * 	1. DB에서 id와 pwd는 Not Null임.
 * 		id와 pwd가 null이 아닌 것을 보장할 수 있는 경우(객체 생성 시, 웹이나 DB에서 가져올 경우)
 * 		(id, pwd는 DB 테이블을 만들 때 not null로도 만들고 javascript에서도 거름, 또한 사용자가 id, pwd를 안넣을 확률 적음)
 * 2. 서비스에서 Employee의 유일성은 id와 pwd로 보장한다.
 * 
 */
public class Employee {
	private String id = "";		// hashCode에서 null 값 체크 하는 삼항연산자를 없애기 위해서 초기값을 아예 지정함 -> 속도 빨라짐
	private String pwd = "";	// null을 허용하지 않음
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
	
	public Employee() {
		super();
	}
	
	@Override
	public int hashCode() {
//		final int prime = 31;
//		int result = 1;
//		result = prime * result + id.hashCode();
//		result = prime * result + pwd.hashCode();
		
		final int prime = 5;
		final int result = 1;
		return result<<prime + id.hashCode() + pwd.hashCode();				// result * prime 을 빨리 하기 위해서 shift 연산자를 사용
		 
	}

	@Override
	public boolean equals(Object obj) {
//		if (this == obj)
//			return true;
//		if (obj == null)
//			return false;
//		if (getClass() != obj.getClass())
//			return false;
//		Employee other = (Employee) obj;
//		if (id == null) {
//			if (other.id != null)
//				return false;
//		} else if (!id.equals(other.id))
//			return false;
//		if (pwd == null) {
//			if (other.pwd != null)
//				return false;
//		} else if (!pwd.equals(other.pwd))
//			return false;
//		return true;
		
		
		// id 와 pwd가 null 인 경우가 없게 초기화 해줬으니 지울 수 있음
		if (this == obj)		// 완전히 똑같으면 밑에 연산 안할 수도 있으니까 지우지 않고 남겨 놓음
			return true;
		if (obj.hashCode() == this.hashCode())		// 같냐 아니냐를 비교하는 것보다 hashCode 연산을 사용하는게 속도가 더 빨라서 변경
			return false;
		return true;
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
