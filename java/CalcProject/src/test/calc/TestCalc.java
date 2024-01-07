package test.calc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * <pre>
 * ���� �����
 * ������ : op
 * ���갪1 : opr1
 * ���갪2 : opr2
 * ����� : result
 * ���� > syso : System.out
             sysi : System.in : ��ǻ�Ϳ� �Է� ��ġ�κ��� �����͸� ������ �� ���� -> ������(byte)
             syse : System.err
             main(String[] args) : args ���ڿ� �迭�� �ܺο��� � �����͸� ������ �� ���� -> ���ڿ��� �迭
 *
 * 1. �����ڸ� (�ƹ��ų�) ����
 * 2 ���갪1, 2�� (�ƹ��ų�) ����
 * 3. �����ڸ� ��(+, -, *, /) �ؼ� �ش� �����ڿ� ����(==) �ϸ� �ش� ������ �����ؼ� ������� ����
 * 4. ������� ���
 * 
 * @author user04
 * </pre>
 */
public class TestCalc {
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
//		char op;
		String op;
		int opr1;
		int opr2;
		// ������ ������ ���� �ʱ�ȭ ���� ������ ����� ���� ������� ����
		int result = 0;	// double result �� ����(������ �����ϱ�) -> ������(������ ����� int�� ĳ���� �ؾ��ϴϱ�)
		
		// 1. �����ڸ� (�ƹ��ų�) ����
//		op = '+';
		op = "+";
		// 2 ���갪1, 2�� (�ƹ��ų�) ����
		opr1 = 100;
		opr2 = 90;
		
		// main���� ���갪1, ������, ������, ������2 ������ �Է¹޴´�.
		// String[](�迭 : ������ ���� [0], [1], [2], ...)
		// Run ���� ���ﰢ�� Ŭ�� -> Run Configurations -> Arguments -> Program arguments �ڽ� �ȿ� 500 + 180 �Է� -> Run
//		opr1 = Integer.parseInt(args[0]);		// String data -> int ��ȯ
//		op = args[1];
//		opr2 = Integer.parseInt(args[2]);
		
		
		// ����� �Է��� ����
		// ����� ���
//		byte[] buffer = new byte[2]; // int: 4byte (16��) vs byte[4] : 4����(��ȣ, ����
//		int inputData = System.in.read(buffer);	// inputData : byte 
//		String temp = new String(buffer);		// byte -> String���� ����
//		opr1 = new Integer(temp);
//		System.out.println((char)inputData);
		
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		String temp = "";
		
		
//		while(true) {
		for(int i = 0; i < 5; i++) {
			// ù��° ���� �Է�
			System.out.println("ù��° ���ڸ� �Է��ϼ���: ");
			temp = br.readLine();
			opr1 = new Integer(temp);
			
			// ������ �Է�
			System.out.println("�����ڸ� �Է��ϼ���: ");
			op = br.readLine();
			
			// �ι�° ���� �Է�
			System.out.println("�ι�° ���ڸ� �Է��ϼ���: ");
			temp = br.readLine();
			opr2 = new Integer(temp);
			
		// 3. �����ڸ� ��(+, -, *, /) �ؼ� �ش� �����ڿ� ����(==) �ϸ� 
//		if (op == '+') {
//			// �ش� ������ �����ؼ� ������� ����
//			result = opr1 + opr2; 
//		} else if (op == '-') {
//			result = opr1 - opr2;
//		} else if (op == '*') {
//			result = opr1 * opr2;
//		} else if (op == '/') {
//			result = opr1 / opr2;
//		}
		
		// char -> String ���� �� '' -> "" �� ����
//		if (op == "+") {
//			// �ش� ������ �����ؼ� ������� ����
//			result = opr1 + opr2; 
//		} else if (op == "-") {
//			result = opr1 - opr2;
//		} else if (op == "*") {
//			result = opr1 * opr2;
//		} else if (op == "/") {
//			result = opr1 / opr2;
//		}
		
		// ������ 4�� �̻��̸� switch�� �� ����
		// ���ǵ� ������ �Ͼ Ȯ���� ����ϸ� switch, Ȯ���� ������� ������ if �� ����
		// switch�� ���� �� = ���� ������Ʈ, if�� ���� �� = grade ������Ʈ
//		switch (op) {
//			case "+":
//			result = opr1 + opr2;
//				break;
//			case "-":
//				result = opr1 - opr2;
//				break;
//			case "*":
//				result = opr1 * opr2;
//				break;
//			case "/":
//				result = opr1 / opr2;
//				break;
//		default:
//			break;
//		}
		
			// ���� ������
			// String�� ��ü�̱� ������ == ������ �ȸ���(char�� ����), ��ü �񱳴� equals()
			result = (op.equals("+")) ? opr1 + opr2:
						(op.equals("-")) ? opr1 - opr2:
						(op.equals( "*")) ? opr1 * opr2:
						(op.equals("/")) ? opr1 / opr2:
						result;
			
			// 4. ������� ���
			System.out.println(opr1 + op + opr2 + "=" + result);
			
			if (result == 0) {
				break;
			}
		
		// System.out.println(opr1 + op + opr2 + "=" + result); �� ��� 233=190���� ����
		// byte, short, char -> int ȣȯ Ÿ��
		// op�� int ������ �ٲ��� ������ �Ǽ� op�� char �� �� �� �����ؾ���
		// �׷��� java���� char �߾Ⱦ� -> String ������� �ذ� ����
		
		// System.out.println("" + opr1 + op + opr2 + "=" + result);
		// ���ڿ��� ���� ������ �ؼ� ���ڷ� ���� -> ���� ��� �ƴ� 
		
		}
	}
}
