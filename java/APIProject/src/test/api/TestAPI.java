package test.api;

import java.util.ArrayList;
import java.util.List;

import test.buy.CU;
import test.oo.Date;

public class TestAPI {
/**
 * 다양한 API 테스트
 * Object
 * Math
 * Wrapper
 * String
 * 
 * @param args
 */
	public static void main(String[] args) {
		/**
		 * TODO 과제
		 * 과제 1 : abstract class, interface class 예제 코딩하기
		 * 과제 2 : inner class ~ anonymous class 예제 코딩하기
		 * 과제 3 : equals() 효율화 (level 2. hashcode() 함수도 적용하기)
		 * 과제는 아님 : Math.random()와 java.util.Random 클래스에 대한 예제도 하면 좋음
		 * 
		 */
		// Object
		Object o1 = new CU(),  o2 = new CU();
//		o1 = o2; // 주소 값이 같아지기 때문에 전부 true 나옴
		boolean b= o1.equals(o2);	// equals 는 같은 곳에 들어있는지를 확인함(하지만 나는 안에 데이터 값이 같으면 같다고 하고 싶음 -> Override equals 함)
		System.out.println(b + "::equals()\n" + o1 + "\n" + o2);
		b = o1 == o2;
		System.out.println(b + "::[==]\n" + o1 + "\n" + o2);
		
		// Date class : 잘만들어 놓은 클래스
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
//		Math m = new Math();		// private Math() 로 되어있기 때문에 오류남
		System.out.println(Math.PI);
		int i = 1;
		double d = 1.0;
		System.out.println(Math.max(i, d));	// i가 double로 자동 형변환(auto casting)이 되면서 d의 값인 상수 1.0를 같이 가리키게 됨(작은게 큰거로 변함)
																// i랑 d가 값이 같기 때문에 결과에 1.0이 i값인지 d값인지 모름		
//		Math.PI = 1;		// PI는 상수(public static final)이라 값을 변경할 수 없음
		
		
		// Wrapper, String
		String s1 = "Hello";
		String s2 = new String("Hello");
//		s2 = "Hello";
		b = s1.equals(s2);		// String의 equals() 함수는 내용 비교
		System.out.println(b + "::equals()\n" + s1 + "\n" + s2);
		b = s1 == s2;
		System.out.println(b + "::[==]\n" + s1 + "\n" + s2);		// s2 = "Hello"; 실행 시 string pool 에 존재하기 때문에 같음 -> 같은 상수풀에 동일한 값으로 저장되는 경우 같은 값으로 인식
																							// String test1 = "test1";
																							// String test2 = "test1";
																							// String test3 = new String("test1");
																							// test1 == test2 ? true
																							// test1 == test3 ? false
		
		// Wrapper class : 기본형 8개 모두 존재, 아래 코드는 jdk1.5이상에서 가능
		int j = 1;	// 기본형 타입
		j = Integer.parseInt("1");
		Integer jj = new Integer(j);	// 객체
		Integer jjj = 100;		// 객체 생성 안하고 값 집에 넣었는데 오류 안남
		Character c = 'c';
		jj = j;	
		j = jj;
		
		
//		List list = new ArrayList<int>();	// Reference type 이여야함
//		List list = new ArrayList<Integer>();		// 런타임에 타입 명시는 의미 없음
//		list.add(s1);											// 오류 안남
		List<Integer> list = new ArrayList();		// 선언에서 타입 명시가 좋음
		list.add(jj);
		list.add(j);
		for (Integer integer : list) {
			int k = integer + 5;	// 원래는 안됐으나 자바1.5 이후론 가능
		}
		
		
	}
}
