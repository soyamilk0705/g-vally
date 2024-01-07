package test.grade;
/**
 * <pre>
 * �л� ���α׷� �����
 * ���� score �Է�
 * score ���� 90�� �̻� A����
 * score ���� 80�� �̻� B����
 * score ���� 70�� �̻� C����
 * score ���� 60�� �̻� D����
 * �� �� F����
 * @author user04
 *</pre>
 */
public class TestGrade {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 1. ���� score �Է�
		int score = 95;
		String result;
		
		// 2. if���� ���� �Ʒ��� ���ǿ� �´� ��� result�� �� ���� ����
		if(score >= 90) {
			result = "A����";
		} else if(score >= 80) {
			result = "B����";
		} else if(score >= 70) {
			result = "C����";
		} else if(score >= 60) {
			result = "D����";
		} else {
			result = "F����";
		}
	
		
		// 3�� �����ڷ� ��ȯ
		result = (score >= 90) ? "A����" : 
					(score >= 80) ? "B����" : 
					(score >= 70) ? "C����" :
					(score >= 60) ? "D����" : 
					"F����";
		
		
		switch (score) {
		case 100:
		case 90:
			result = "A����";
			break;
		case 80:
			result = "B����";
			break;
		case 70:
			result = "C����";
			break;
		case 60:
			result = "D����";
			break;
		default:
			result = "F����";
		}
		
		// switch�� ���� ������ case �� ���� �� ���� -> 10���� ������ ���� �ذ� ����
		score /= 10;		// score = score / 10;
		
		// switch �������� score�� 10���� ������ ������ 10���� �������ؼ�
		// �������� �ѹ��� 10���� ������ ����°� �����ս��� ����
		switch (score) {
		case 10:
		case 9:
			result = "A����";
			break;
		case 8:
			result = "B����";
			break;
		case 7:
			result = "C����";
			break;
		case 6:
			result = "D����";
			break;
		default:
			result = "F����";
		}
		
		System.out.println("���� ��� : " + result);
		
	}
}
