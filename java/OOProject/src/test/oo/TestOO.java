package test.oo;
/**
 * ��ü����
 * 1. �߻�ȭ
 * 2. ����ȭ
 * 3. ������(���)
 * 
 * 1. �߻�ȭ
 * date : �����Ϸ� ǥ��
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
		System.out.println(someday);	// ���������� 29�Ϸ� �ٲٶ�� �ϴ°��� ���� �Է��� ��¥ ��ü�� ���������� �ٲٶ�� �Ѱ� �ƴϴϱ� 28�� ������
		
		someday.setDay(100);
		System.out.println(someday);
	}

}
