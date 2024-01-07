package test.collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

import test.buy.CU;
/**
 * Collection: ���� ������
 * Set: �ߺ��� ������� ����, ������, �ߺ� ���ſ�
 * List: ���� ���� ���, index ����
 * >>> size(), add(), remove(), insert()
 * @author user04
 *
 */

public class TestCollection2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] i = new int[5];
		
		// �ݺ� Ƚ���� �˰� �ִ� -> for
		for(int j = 0; j < i.length; j++) {
			i[j] = j;
		}
		
		String s = "hello";
		char c = 'A';
		boolean b = true;
		// ������Ʈ ���� ���콺 ������ -> Build Path -> Configure build path -> projects -> add -> buyProject
		CU cu = new CU();
		
		// Collection
		// E : element type ���� �Ұ���, T: type, K : key type ���� �Ұ���
		List list = new ArrayList<>();		// �θ� Ÿ���� ������ �ڽ� Ÿ���� ��ü�� ����
		list = new LinkedList<>();			// ÷��, ������ ���� ��� ������ Ź��
		list.add(i);
		list.add(s);
		list.add(c);
		list.add(b);
		list.add(0, cu);
		
		print(list);
		
		// list ���� �����͸� ����
		list.remove(2);
		// list�� element�� �� �� 
		System.out.println(list.get(2));	// hello�� �����ǰ� ���� �ε��� ������� A�� ��µ�(�ε��� ����)
		// list�� element ����
		list.set(2, "Z");
		System.out.println(list.get(2));
		
		// �ߺ� ������ �߰�
		list.add(1, i);
		list.add(3, i);
		list.add(5, i);
		
		System.out.println("list size = " + list.size());
		
		// �ߺ� ����: Set
		HashSet set = new HashSet<>(list);
		System.out.println("set size = " + set.size());
		
		// �ߺ� ������ �߰�
		set.add(cu);
		System.out.println("set ��ü ��� ");
		
		print(set);
//		for(Object object: c) {
//		// �迭�� ���
//		if (object instanceof int[]) {		// instanceof : object ��ü�� Ÿ���� int[]���� üũ����, java���� �ִ� �� ������ : RuntimeType(new �Ǵ� ������ Ÿ��) checking ��
//
//			for (int j : i) {
//				System.out.print(j + ", ");
//			}
//			// ���� 1 : ������ ������ �ڿ� [,] �����ϱ�
//			System.out.println();	
//		} else {
//			// �Ϲ� �������� ���
//			System.out.println(object);
//		}
//	}
		
		String printJ = "";
		
		// ���� 1 : ������ ������ �ڿ� [,] �����ϱ�
		// ���� 2 : void print (Collection c) -> print(list); print(set);
		
		// 1. ����� ���߿� �ϰ�, printJ������ j ���� ���("0, 1, 2, 3, 4 ") -> "0, 1, 2, 3, 4" ��ȯ (���ڿ��� �Ϻθ� �����ϴ� �Լ�)
		for(int j : i) {
			printJ += (j + ", ");
		}
		printJ = printJ.substring(0, 13);
		System.out.println(printJ);
		
 		// 2. for������ print()�� ���� �ٿ��� ����ϴ� ���̹Ƿ� �������� \b�� ����ؼ� ���� ���� 2���� �����.
		for(int j : i) {
			printJ += (j + ", ");
		}
		System.out.println("int[] : " + printJ + "\b\b\b\b");
		
		// 3. i�� size()�� üũ�ؼ� ������������ ��� + ", "�� ����
		int count = 1;
		
		for(int j : i) {
			if (count++ == i.length) {		// count : 1 ~ size()
				System.out.print(j);
				break;
			}
			System.out.print(j + ", ");
		}
		System.out.println();
		
		// set -> list�� �ٽ� �ٲ�
		list = new ArrayList<>(set);
			
		// list -> array�� �ٲ�1
		Object[] array2 = new Object[list.size()];
		list.toArray(array2);
		for (Object object : array2) {System.out.println(object);}
		
		// list -> array�� �ٲ�2
		Object[] array = list.toArray();
		System.out.println("�迭 ���");
		for (Object object : array) {System.out.println(object);}
		
	}
	
	
	public static void print(Collection c) {
		for(Object object: c) {
			// �迭�� ���
			if (object instanceof int[]) {		// instanceof : object ��ü�� Ÿ���� int[]���� üũ����, java���� �ִ� �� ������ : RuntimeType(new �Ǵ� ������ Ÿ��) checking ��
				String printJ = "";
				
				
				int[] array = (int[]) object;
				
				for (int j : array) {
					printJ += j + ", ";
				}
				
				System.out.println(printJ.substring(0, printJ.length() - 2));

			} else {
				// �Ϲ� �������� ���
				System.out.println(object);
			}
		}
	}
	
	
}
