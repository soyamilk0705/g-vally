package test.collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import test.buy.CU;
/**
 * Collection: ���� ������
 * Map: ���� - ���� ��ġ(�ǹ�) : ��ȣ
 * >>> size(), put(key, value), remove()
 * @author user04
 *
 */

public class TestCollection3 {

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
		
		// HashMap
		HashMap map = new HashMap();
		
		// ������ �߰�
		map.put("��浿", i);
		map.put("����", s);
		map.put("�Ѹ�", c);
		map.put("�Ѹ�", c);		// map�� �ߺ��� �������� ������ ������ �߻������� �ʴ´�.
		map.put("�Ѹ�", b);		// ���� key�� �ٸ� �����͸� ���� ��� ��ü�ȴ�.
		map.put("�����", b);
		map.put("��ġ", cu);
		
		// key�� �ñ��� ���
		Set keys = map.keySet();
		
		System.out.println(map);
		System.out.println(keys);
		
		// values ���������� ���
		Collection values = map.values();
		
		for (Object object : values) {
			System.out.println(object);
		}

//		print(set);
//		
//		// set -> list�� �ٽ� �ٲ�
//		list = new ArrayList<>(set);
//			
//		// list -> array�� �ٲ�1
//		Object[] array2 = new Object[list.size()];
//		list.toArray(array2);
//		for (Object object : array2) {System.out.println(object);}
//		
//		// list -> array�� �ٲ�2
//		Object[] array = list.toArray();
//		for (Object object : array) {System.out.println(object);}
		
		
		
		
	}
	
	
	public static void print(Collection c) {
//		for(Object object: c) {
//			// �迭�� ���
//			if (object instanceof int[]) {		// instanceof : object ��ü�� Ÿ���� int[]���� üũ����, java���� �ִ� �� ������ : RuntimeType(new �Ǵ� ������ Ÿ��) checking ��
//	
//				for (int j : i) {
//					System.out.print(j + ", ");
//				}
//				System.out.println();	
//			} else {
//				// �Ϲ� �������� ���
//				System.out.println(object);
//			}
//		}
		
		
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
