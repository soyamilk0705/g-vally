package test.collection;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import test.buy.CU;

public class TestCollection {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] i;
		i = new int[5];
		// 배열은 집합의 구조만 만들어주는거지 하나하나는 다시 넣어줘야함
//		i[4] = 1;
		
		// 반복 횟수를 알고 있다 -> for
		for(int j = 0; j < i.length; j++) {
			i[j] = j;
		}
	
		System.out.println(i[4]);
		
		// for-each
		for (int j : i) {
			System.out.println(j);
		}
	}

}
