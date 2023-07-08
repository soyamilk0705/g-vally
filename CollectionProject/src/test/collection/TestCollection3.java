package test.collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import test.buy.CU;
/**
 * Collection: 집합 데이터
 * Map: 지도 - 실제 위치(건물) : 기호
 * >>> size(), put(key, value), remove()
 * @author user04
 *
 */

public class TestCollection3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] i = new int[5];
		
		// 반복 횟수를 알고 있다 -> for
		for(int j = 0; j < i.length; j++) {
			i[j] = j;
		}
		
		String s = "hello";
		char c = 'A';
		boolean b = true;
		// 프로젝트 위에 마우스 오른쪽 -> Build Path -> Configure build path -> projects -> add -> buyProject
		CU cu = new CU();
		
		// HashMap
		HashMap map = new HashMap();
		
		// 데이터 추가
		map.put("고길동", i);
		map.put("고희동", s);
		map.put("둘리", c);
		map.put("둘리", c);		// map은 중복이 허용되지는 않으나 에러가 발생하지도 않는다.
		map.put("둘리", b);		// 같은 key에 다른 데이터를 넣을 경우 교체된다.
		map.put("도우너", b);
		map.put("또치", cu);
		
		// key가 궁금할 경우
		Set keys = map.keySet();
		
		System.out.println(map);
		System.out.println(keys);
		
		// values 순차적으로 사용
		Collection values = map.values();
		
		for (Object object : values) {
			System.out.println(object);
		}

//		print(set);
//		
//		// set -> list로 다시 바꿈
//		list = new ArrayList<>(set);
//			
//		// list -> array로 바꿈1
//		Object[] array2 = new Object[list.size()];
//		list.toArray(array2);
//		for (Object object : array2) {System.out.println(object);}
//		
//		// list -> array로 바꿈2
//		Object[] array = list.toArray();
//		for (Object object : array) {System.out.println(object);}
		
		
		
		
	}
	
	
	public static void print(Collection c) {
//		for(Object object: c) {
//			// 배열일 경우
//			if (object instanceof int[]) {		// instanceof : object 객체의 타입이 int[]인지 체크해줌, java에만 있는 논리 연산자 : RuntimeType(new 또는 생성한 타입) checking 용
//	
//				for (int j : i) {
//					System.out.print(j + ", ");
//				}
//				// 과제 1 : 마지막 데이터 뒤에 [,] 제거하기
//				System.out.println();	
//			} else {
//				// 일반 데이터의 경우
//				System.out.println(object);
//			}
//		}
		

		// 과제2 : void print (Collection c) -> print(list); print(set);
		for(Object object: c) {
			// 배열일 경우
			if (object instanceof int[]) {		// instanceof : object 객체의 타입이 int[]인지 체크해줌, java에만 있는 논리 연산자 : RuntimeType(new 또는 생성한 타입) checking 용
				String result = "";
				int[] array = (int[]) object;
				
				for (int j : array) {
					result += j + ", ";
				}
				
				System.out.println(result.substring(0, result.length() - 2));

			} else {
				// 일반 데이터의 경우
				System.out.println(object);
			}
		}
	}
	
	
}
