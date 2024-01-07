package intranet.entity;

public class UserDTO {
	private String userId;
	private String name;
	private String password;
	private String address;
	private String phone;
	private String passwordQuestion;
	private String passwordAnswer;
	private String marriage;
	private String hobby;
	private String etc;
	
	public UserDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UserDTO(String userId, String name, String password, String address, String phone,
			String passwordQuestion, String passwordAnswer, String marriage, String hobby, String etc) {
		super();
		this.userId = userId;
		this.name = name;
		this.password = password;
		this.address = address;
		this.phone = phone;
		this.passwordQuestion = passwordQuestion;
		this.passwordAnswer = passwordAnswer;
		this.marriage = marriage;
		this.hobby = hobby;
		this.etc = etc;
	}

	
	
	@Override
	public String toString() {
		return "UserDTO [userId=" + userId + ", name=" + name + ", password=" + password + ", address=" + address
				+ ", phone=" + phone + ", passwordQuestion=" + passwordQuestion + ", passwordAnswer=" + passwordAnswer
				+ ", marriage=" + marriage + ", hobby=" + hobby + ", etc=" + etc + "]";
	}

	public String getUserId() {
		return userId;
	}

	public String getName() {
		return name;
	}

	public String getPassword() {
		return password;
	}

	public String getAddress() {
		return address;
	}

	public String getPhone() {
		return phone;
	}

	public String getPasswordQuestion() {
		return passwordQuestion;
	}

	public String getPasswordAnswer() {
		return passwordAnswer;
	}

	public String getMarriage() {
		return marriage;
	}

	public String getHobby() {
		return hobby;
	}

	public String getEtc() {
		return etc;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public void setPasswordQuestion(String passwordQuestion) {
		this.passwordQuestion = passwordQuestion;
	}

	public void setPasswordAnswer(String passwordAnswer) {
		this.passwordAnswer = passwordAnswer;
	}

	public void setMarriage(String marriage) {
		this.marriage = marriage;
	}

	public void setHobby(String hobby) {
		this.hobby = hobby;
	}

	public void setEtc(String etc) {
		this.etc = etc;
	}
	
	
}
