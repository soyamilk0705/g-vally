package test.buy;
/**
 * <pre>
 * <���̽�ũ�� �ɺθ�>
�⿬��: ��, �κ�, ������(����)
������: 1000��, "������"

1. (���� �κ�����) �޼� ��.
1-1. left;
2. �޼� <- 1000��.
2-1. left = 1000;
3. (���� �κ�����) ���̽�ũ�� ���.
3-1. buyIcecream();
4. �κ��� ������(cu)�� �߰��ϰ� ����.
4-1. cu;
5. (�κ��� ��������) ���̽�ũ�� �ּ���.
5-1. getIcecream();
	6. ������ �Ŵ뿡�� ���̽�ũ��("������")�� �����´�.
	6-1. "������";	
	7. (5���� ���� ��������) (������ �κ�����) ���̽�ũ��(������)�� �ش�.
	7-1. return [6-1];
	7-2. (�κ���) right = [7-1];
8. �κ��� ���� �ִ� ������ ���ƿ´�.
8-1. ;
9. �κ��� ������ �տ� �ִ� ���̽�ũ���� �ش�.
9-1. syso(right);

 * @author �����
 *</pre>
 */
public class BuyIcecream {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 1. (���� �κ�����) �޼� ��.
		int left;
		//	2. �޼� <- 1000��.
		left = 1000;
		//	3. (���� �κ�����) ���̽�ũ�� ���.
		buyIcecream(left);
		//	8. �κ��� ���� �ִ� ������ ���ƿ´�.
		Object right = buyIcecream(left);
		//	9. �κ��� ������ �տ� �ִ� ���̽�ũ���� �ش�.
		System.out.println(right);
	}
	
	/**
	 * ���̽�ũ�� ����� �Լ�
	 * @param left : ��
	 * @return : ��� ���̽�ũ��<String>Ÿ��
	 */
	private static Object buyIcecream(int left) {
			//	4. �κ��� ������(cu)�� �߰��ϰ� ����.
			CU cu = new CU();
			//	5. (�κ��� ��������) ���̽�ũ�� �ּ���.
			String right = cu.getIcecream(left);
			return right;	
	}
}
