package test.collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

import test.buy.CU;
/**
 * Collection: 집합 데이터
 * Set: 중복을 허용하지 않음, 검증용, 중복 제거용
 * List: 가장 많이 사용, index 제공
 * >>> size(), add(), remove(), insert()
 * @author user04
 *
 */

public class TestCollection2 {

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
		
		// Collection
		// E : element type 뭐로 할건지, T: type, K : key type 뭐로 할건지
		List list = new ArrayList<>();		// 부모 타입의 변수에 자식 타입의 객체를 생성
		list = new LinkedList<>();			// 첨가, 삭제가 많을 경우 성능이 탁월
		list.add(i);
		list.add(s);
		list.add(c);
		list.add(b);
		list.add(0, cu);
		
		print(list);
		
		// list 에서 데이터를 제거
		list.remove(2);
		// list의 element를 볼 때 
		System.out.println(list.get(2));	// hello가 삭제되고 다음 인덱스 결과값인 A가 출력됨(인덱스 변경)
		// list의 element 수정
		list.set(2, "Z");
		System.out.println(list.get(2));
		
		// 중복 데이터 추가
		list.add(1, i);
		list.add(3, i);
		list.add(5, i);
		
		System.out.println("list size = " + list.size());
		
		// 중복 제거: Set
		HashSet set = new HashSet<>(list);
		System.out.println("set size = " + set.size());
		
		// 중복 데이터 추가
		set.add(cu);
		System.out.println("set 전체 출력 ");
		
		print(set);
//		for(Object object: c) {
//		// 배열일 경우
//		if (object instanceof int[]) {		// instanceof : object 객체의 타입이 int[]인지 체크해줌, java에만 있는 논리 연산자 : RuntimeType(new 또는 생성한 타입) checking 용
//
//			for (int j : i) {
//				System.out.print(j + ", ");
//			}
//			// 과제 1 : 마지막 데이터 뒤에 [,] 제거하기
//			System.out.println();	
//		} else {
//			// 일반 데이터의 경우
//			System.out.println(object);
//		}
//	}
		
		String printJ = "";
		
		// 과제 1 : 마지막 데이터 뒤에 [,] 제거하기
		// 과제 2 : void print (Collection c) -> print(list); print(set);
		
		// 1. 출력을 나중에 하고, printJ변수에 j 값을 담고("0, 1, 2, 3, 4 ") -> "0, 1, 2, 3, 4" 변환 (문자열의 일부를 선택하는 함수)
		for(int j : i) {
			printJ += (j + ", ");
		}
		printJ = printJ.substring(0, 13);
		System.out.println(printJ);
		
 		// 2. for문장의 print()는 같은 줄에서 출력하는 것이므로 마지막에 \b를 사용해서 앞의 문자 2개를 지운다.
		for(int j : i) {
			printJ += (j + ", ");
		}
		System.out.println("int[] : " + printJ + "\b\b\b\b");
		
		// 3. i의 size()를 체크해서 마지막번재일 경우 + ", "를 안함
		int count = 1;
		
		for(int j : i) {
			if (count++ == i.length) {		// count : 1 ~ size()
				System.out.print(j);
				break;
			}
			System.out.print(j + ", ");
		}
		System.out.println();
		
		// set -> list로 다시 바꿈
		list = new ArrayList<>(set);
			
		// list -> array로 바꿈1
		Object[] array2 = new Object[list.size()];
		list.toArray(array2);
		for (Object object : array2) {System.out.println(object);}
		
		// list -> array로 바꿈2
		Object[] array = list.toArray();
		System.out.println("배열 출력");
		for (Object object : array) {System.out.println(object);}
		
	}
	
	
	public static void print(Collection c) {
		for(Object object: c) {
			// 배열일 경우
			if (object instanceof int[]) {		// instanceof : object 객체의 타입이 int[]인지 체크해줌, java에만 있는 논리 연산자 : RuntimeType(new 또는 생성한 타입) checking 용
				String printJ = "";
				
				
				int[] array = (int[]) object;
				
				for (int j : array) {
					printJ += j + ", ";
				}
				
				System.out.println(printJ.substring(0, printJ.length() - 2));

			} else {
				// 일반 데이터의 경우
				System.out.println(object);
			}
		}
	}
	
	
}
