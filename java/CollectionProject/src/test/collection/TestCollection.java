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
		// �迭�� ������ ������ ������ִ°��� �ϳ��ϳ��� �ٽ� �־������
//		i[4] = 1;
		
		// �ݺ� Ƚ���� �˰� �ִ� -> for
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
