package test.oo;

public class Appointment extends Date{
	private String subject, content;
	private String person, place;
	private int hour;
	
	public Appointment(int year, int month, int day, String subject, String content, String person, String place,
			int hour) {
		super(year, month, day);	// 부모 가리키는 기호
		this.subject = subject;
		this.content = content;
		this.person = person;
		this.place = place;
		this.hour = hour;
	}
	
	@Override
	public String toString() {
		return "Appointment:: 내 일정\n[제목 : " + subject + "\n 내용 : " + content + "\n대상 : " + person + "\n장소 : " + place
				+ "\n약속시간 : " + hour + "시]";
	}
	public String getSubject() {
		return subject;
	}
	public String getContent() {
		return content;
	}
	public String getPerson() {
		return person;
	}
	public String getPlace() {
		return place;
	}
	public int getHour() {
		return hour;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public void setPerson(String person) {
		this.person = person;
	}
	public void setPlace(String place) {
		this.place = place;
	}
	public void setHour(int hour) {
		this.hour = hour;
	}
	
	
	
	
}
