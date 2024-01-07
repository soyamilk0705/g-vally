package test.api;

import java.util.ArrayList;
import java.util.List;

import test.buy.CU;
import test.oo.Date;

public class TestAPI {
/**
 * �پ��� API �׽�Ʈ
 * Object
 * Math
 * Wrapper
 * String
 * 
 * @param args
 */
	public static void main(String[] args) {
		/**
		 * TODO ����
		 * ���� 1 : abstract class, interface class ���� �ڵ��ϱ�
		 * ���� 2 : inner class ~ anonymous class ���� �ڵ��ϱ�
		 * ���� 3 : equals() ȿ��ȭ (level 2. hashcode() �Լ��� �����ϱ�)
		 * ������ �ƴ� : Math.random()�� java.util.Random Ŭ������ ���� ������ �ϸ� ����
		 * 
		 */
		// Object
		Object o1 = new CU(),  o2 = new CU();
//		o1 = o2; // �ּ� ���� �������� ������ ���� true ����
		boolean b= o1.equals(o2);	// equals �� ���� ���� ����ִ����� Ȯ����(������ ���� �ȿ� ������ ���� ������ ���ٰ� �ϰ� ���� -> Override equals ��)
		System.out.println(b + "::equals()\n" + o1 + "\n" + o2);
		b = o1 == o2;
		System.out.println(b + "::[==]\n" + o1 + "\n" + o2);
		
		// Date class : �߸���� ���� Ŭ����
//		Date d1 = new Date(),  d2 = new Date();
//		b = d1.equals(d2);
//		System.out.println(b + "::equals()\n" + d1 + "\n" + d2);
//		b = d1 == d2;
//		System.out.println(b + "::[==]\n" + d1 + "\n" + d2);
	
		Date d1 = new Date(),  d2 = new Date();
		b = d1.myEquals(d2);
		System.out.println(b + "::equals()\n" + d1 + "\n" + d2);
		b = d1 == d2;
		System.out.println(b + "::[==]\n" + d1 + "\n" + d2);
		d1.hashCode();
		d2.hashCode();
//		
		// Math
//		Math m = new Math();		// private Math() �� �Ǿ��ֱ� ������ ������
		System.out.println(Math.PI);
		int i = 1;
		double d = 1.0;
		System.out.println(Math.max(i, d));	// i�� double�� �ڵ� ����ȯ(auto casting)�� �Ǹ鼭 d�� ���� ��� 1.0�� ���� ����Ű�� ��(������ ū�ŷ� ����)
																// i�� d�� ���� ���� ������ ����� 1.0�� i������ d������ ��		
//		Math.PI = 1;		// PI�� ���(public static final)�̶� ���� ������ �� ����
		
		
		// Wrapper, String
		String s1 = "Hello";
		String s2 = new String("Hello");
//		s2 = "Hello";
		b = s1.equals(s2);		// String�� equals() �Լ��� ���� ��
		System.out.println(b + "::equals()\n" + s1 + "\n" + s2);
		b = s1 == s2;
		System.out.println(b + "::[==]\n" + s1 + "\n" + s2);		// s2 = "Hello"; ���� �� string pool �� �����ϱ� ������ ���� -> ���� ���Ǯ�� ������ ������ ����Ǵ� ��� ���� ������ �ν�
																							// String test1 = "test1";
																							// String test2 = "test1";
																							// String test3 = new String("test1");
																							// test1 == test2 ? true
																							// test1 == test3 ? false
		
		// Wrapper class : �⺻�� 8�� ��� ����, �Ʒ� �ڵ�� jdk1.5�̻󿡼� ����
		int j = 1;	// �⺻�� Ÿ��
		j = Integer.parseInt("1");
		Integer jj = new Integer(j);	// ��ü
		Integer jjj = 100;		// ��ü ���� ���ϰ� �� ���� �־��µ� ���� �ȳ�
		Character c = 'c';
		jj = j;	
		j = jj;
		
		
//		List list = new ArrayList<int>();	// Reference type �̿�����
//		List list = new ArrayList<Integer>();		// ��Ÿ�ӿ� Ÿ�� ��ô� �ǹ� ����
//		list.add(s1);											// ���� �ȳ�
		List<Integer> list = new ArrayList();		// ���𿡼� Ÿ�� ��ð� ����
		list.add(jj);
		list.add(j);
		for (Integer integer : list) {
			int k = integer + 5;	// ������ �ȵ����� �ڹ�1.5 ���ķ� ����
		}
		
		
	}
}
