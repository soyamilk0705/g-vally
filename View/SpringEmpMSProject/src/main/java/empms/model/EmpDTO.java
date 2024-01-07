package empms.model;

public class EmpDTO {
	
	private String id;
	private String name;
	private String pwd;
	private String position;
	private String tel;
	private String hobby;
	private String etc;
	
	public EmpDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public EmpDTO(String id, String name, String pwd, String position, String tel, String hobby, String etc) {
		super();
		this.id = id;
		this.name = name;
		this.pwd = pwd;
		this.position = position;
		this.tel = tel;
		this.hobby = hobby;
		this.etc = etc;
	}

	@Override
	public String toString() {
		return "EmpDTO [id=" + id + ", name=" + name + ", pwd=" + pwd + ", position=" + position + ", tel=" + tel
				+ ", hobby=" + hobby + ", etc=" + etc + "]";
	}

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getPwd() {
		return pwd;
	}

	public String getPosition() {
		return position;
	}

	public String getTel() {
		return tel;
	}

	public String getHobby() {
		return hobby;
	}

	public String getEtc() {
		return etc;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public void setHobby(String hobby) {
		this.hobby = hobby;
	}

	public void setEtc(String etc) {
		this.etc = etc;
	}
	
	
	
}
