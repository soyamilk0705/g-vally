package test.oo;
/**
 * 객체지향
 * 1. 추상화
 * 2. 은닉화
 * 3. 다형성(상속)
 * 
 * 1. 추상화
 * date : 연월일로 표현
 * class Date{ year, month, day }
 * 
 * @author user04
 *
 */
public class TestOO {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int year = 2023;
		int month = 7;
		int day = 7;
		
		System.out.println(year + "." + month + "." + day + ".");
		
		int yearOfBirth = 1996;
		int monthOfBirth = 1;
		int dayOfBirth = 10;
		
		System.out.println(yearOfBirth + "." + monthOfBirth + "." + dayOfBirth + ".");
		
		Date today = new Date(2023, 7, 7);
		Date birthday = new Date(1996, 1, 10);
		
		System.out.println(today);
		System.out.println(birthday);
		
		Date someday = new Date();
		someday.setYear(2030);
		someday.setMonth(24);
		someday.setDay(100);
		
		System.out.println(someday);
		
		someday.setMonth(2);
		System.out.println(someday);
		someday.setYear(2020);
		System.out.println(someday);	// 마지막날을 29일로 바꾸라고 하는거지 내가 입력한 날짜 자체를 마지막날로 바꾸라고 한게 아니니까 28이 마즈음
		
		someday.setDay(100);
		System.out.println(someday);
	}

}
