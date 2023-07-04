package test.grade;
/**
 * <pre>
 * 학사 프로그램 만들기
 * 점수 score 입력
 * score 값이 90점 이상 A학점
 * score 값이 80점 이상 B학점
 * score 값이 70점 이상 C학점
 * score 값이 60점 이상 D학점
 * 그 외 F학점
 * @author user04
 *</pre>
 */
public class TestGrade {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 1. 정수 score 입력
		int score = 95;
		String result;
		
		// 2. if문을 통해 아래의 조건에 맞는 결과 result에 각 학점 저장
		if(score >= 90) {
			result = "A학점";
		} else if(score >= 80) {
			result = "B학점";
		} else if(score >= 70) {
			result = "C학점";
		} else if(score >= 60) {
			result = "D학점";
		} else {
			result = "F학점";
		}
	
		
		// 3항 연산자로 변환
		result = (score >= 90) ? "A학점" : 
					(score >= 80) ? "B학점" : 
					(score >= 70) ? "C학점" :
					(score >= 60) ? "D학점" : 
					"F학점";
		
		
		switch (score) {
		case 100:
		case 90:
			result = "A학점";
			break;
		case 80:
			result = "B학점";
			break;
		case 70:
			result = "C학점";
			break;
		case 60:
			result = "D학점";
			break;
		default:
			result = "F학점";
		}
		
		// switch는 범위 값으로 case 를 정할 수 없음 -> 10으로 나누면 문제 해결 가능
		score /= 10;		// score = score / 10;
		
		// switch 구문에서 score를 10으로 나누면 여러번 10으로 나눠야해서
		// 맨위에서 한번만 10으로 나누게 만드는게 퍼포먼스가 좋음
		switch (score) {
		case 10:
		case 9:
			result = "A학점";
			break;
		case 8:
			result = "B학점";
			break;
		case 7:
			result = "C학점";
			break;
		case 6:
			result = "D학점";
			break;
		default:
			result = "F학점";
		}
		
		System.out.println("학점 결과 : " + result);
		
	}
}
