package emp.model;

import java.util.Date;

public class BoardDTO {
	//num, name, email, pwd, subject, content, regdate, hit, parent, sort, tab
	
	private int num;
	private String name;
	private String email;
	private String pwd;
	private String subject;
	private String content; 
	private Date regdate;
	private int hit;
	private int parent;
	private int sort;
	private int tab;
	
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getRegdate() {
		return regdate;
	}
	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}
	public int getHit() {
		return hit;
	}
	public void setHit(int hit) {
		this.hit = hit;
	}
	public int getParent() {
		return parent;
	}
	public void setParent(int parent) {
		this.parent = parent;
	}
	public int getSort() {
		return sort;
	}
	public void setSort(int sort) {
		this.sort = sort;
	}
	public int getTab() {
		return tab;
	}
	public void setTab(int tab) {
		this.tab = tab;
	}
	
	@Override
	public String toString() {
		return "BoardDTO [num=" + num + ", name=" + name + ", email=" + email
				+ ", pwd=" + pwd + ", subject=" + subject + ", content="
				+ content + ", regdate=" + regdate + ", hit=" + hit
				+ ", parent=" + parent + ", sort=" + sort + ", tab=" + tab
				+ "]";
	}
	
}
