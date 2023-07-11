package test.oo;

public class Date {
	private int year;
	private int month;	// 1 ~ 12
	private int day;
	// public 인 이유가 없으면 private (은닉성)
	private int[] lastDayOfMonth = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
	
	public Date(int year, int month, int day) {
		super();
		this.setYear(year);
		this.month = month;
		this.day = day;
	}

	public Date() {
		// default 생성자는 자동으로 만들어짐
		// 생성자가 아예 없으면 default 생성자가 자동으로 만들어지지만
		// 생성자를 만들면 default 생성자가 안만들어지기 때문에
		// 오류가 남(위에 Date 생성자 놔두고 이 Date 생성자 지우면 오류남)
		
		// 위에서 값을 명시하는 것보다
		// 생성자에서 값을 명시하는걸 더 권장함
		this(0, 1, 1);
	}

	@Override
	public String toString() {
		 return new String(new StringBuilder().append("Date::").append(year).append(".")
				 .append(month).append(".").append(day).append("."));
		
//		return getYear() + "." + month + "." + day + ".";
	}
	
	
	/**
	 * @return the year
	 */
	public int getYear() {
		return year;
	}
	
	/**
	 * 연도 안보이게 함
	 * block = "*"
	 * return year 대신 block 4개
	 * y = yourBirth.getYear("*");
	 * syso(u) -> "****"
	 * 
	 * @param block
	 * @return
	 */
	public String getYear(String block) {
		// String을 연산해서 사용해야 할 경우
		// 기존 데이터는 StringBuffer 를
		// 새로운 데이터는 StringBuilder를 만들어 사용한다.
		return new String(new StringBuilder(block).append(block).append(block).append(block));
	}

	/**
	 * @param year the year to set
	 */
	public void setYear(int year) {
		this.year = year;
		setDay(day);
	}

	/**
	 * month를 설정 : 1~12
	 * 그 외의 값은 exception을 던져야 함
	 * 그 대안으로 
	 * 0이하가 들어오면 1로 치환
	 * 13이상이 들어오면 12로 치환
	 * @param month
	 */
	void setMonth(int month){
//		this.month = month;
		
		if (month < 1) {
			month = 1;
		} else if (month > 12) {
			month = 12;
		} 
			
		this.month = month;		
		setDay(this.day);		// 월만 바꾸고 일은 안바꿀 경우에 대비해서
	}

	/**
	 * @param day the day to set
	 */
	public void setDay(int day) {
		if (month == 2) {
			setLeapYear();
		}
		
		if (day < 1) {
			day = 1;
		} else if (day > lastDayOfMonth[month - 1]) {
			day = lastDayOfMonth[month - 1];
		}
		
		this.day = day;
	}
	
	
	/**
	 * 윤년 공식
	 * 0. 2월은 28일
	 * 1. 4년마다 29일
	 * 2. 100년마다 28일
	 * 3. 400년마다 29일
	 */
	private void setLeapYear() {
		int last = 28; 
		
//		if (getYear() % 4 == 0) {
//			last = 29;
//			if (getYear() % 100 == 0) {
//				last = 28;
//				if (getYear() % 400 == 0) {
//					last = 29;
//				} 
//			}
//		}
		
		// TODO
		// 과제 : !, &&, || 를 이용하여 조건문을 줄이기
//		last = (year % 4 == 0 || year % 400 == 0) ? 29 : 28;
	
//		if ((year % 4 == 0 && year % != 100) || year % 400 == 0){
//			last = 29;
//		} else {
//			last = 28;
//		}

		// 운년 공식을 적용 -> last에 저장
		
		System.out.println(this + "|| last = " + last);
		lastDayOfMonth[1] = last;
	}
	
	// 부모에만 정의 되어 있는 함수
	public void print() {
		System.out.println(this);
	}
}
