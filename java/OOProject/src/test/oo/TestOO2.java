package test.oo;

import java.util.ArrayList;

/**
 * Appointment extends Date
 * class Date{ year, month, day }
 * class Appointment() { subject, content, person, place, hour }
 * 
 * @author user04
 *
 */
public class TestOO2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Date today = new Date(2023, 7, 7);
		Date appoint = new Appointment(2023, 7, 7, "���� ���", "ģ���� ���ֻ��", "��浿", "ȸ�� �繫��", 13);
		
//		appoint.setSubject();
		System.out.println(today);
		System.out.println(appoint);
		
		ArrayList<Date> list = new ArrayList<Date>();
		list.add(today);
		list.add(appoint);
		
		System.out.println();
		
		for (Date date : list) {
			date.print();
		}
	}

}
