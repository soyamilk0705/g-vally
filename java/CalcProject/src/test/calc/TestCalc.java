package test.calc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * <pre>
 * 계산기 만들기
 * 연산자 : op
 * 연산값1 : opr1
 * 연산값2 : opr2
 * 결과값 : result
 * 지식 > syso : System.out
             sysi : System.in : 컴퓨터에 입력 장치로부터 데이터를 가져올 수 있음 -> 데이터(byte)
             syse : System.err
             main(String[] args) : args 문자열 배열로 외부에서 어떤 데이터를 가져올 수 있음 -> 문자열의 배열
 *
 * 1. 연산자를 (아무거나) 대입
 * 2 연산값1, 2에 (아무거나) 대입
 * 3. 연산자를 비교(+, -, *, /) 해서 해당 연산자와 동일(==) 하면 해당 연산을 수행해서 결과값에 저장
 * 4. 결과값을 출력
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
		// 선언을 했지만 값을 초기화 하지 않으면 담겨진 값을 출력하지 못함
		int result = 0;	// double result 도 가능(나누기 있으니까) -> 불편함(나누기 빼고는 int로 캐스팅 해야하니까)
		
		// 1. 연산자를 (아무거나) 대입
//		op = '+';
		op = "+";
		// 2 연산값1, 2에 (아무거나) 대입
		opr1 = 100;
		opr2 = 90;
		
		// main에서 연산값1, 연산자, 연산자, 연산자2 순으로 입력받는다.
		// String[](배열 : 순서에 따라 [0], [1], [2], ...)
		// Run 옆에 역삼각형 클릭 -> Run Configurations -> Arguments -> Program arguments 박스 안에 500 + 180 입력 -> Run
//		opr1 = Integer.parseInt(args[0]);		// String data -> int 변환
//		op = args[1];
//		opr2 = Integer.parseInt(args[2]);
		
		
		// 사용자 입력을 받자
		// 사용자 출력
//		byte[] buffer = new byte[2]; // int: 4byte (16억) vs byte[4] : 4글자(기호, 숫자
//		int inputData = System.in.read(buffer);	// inputData : byte 
//		String temp = new String(buffer);		// byte -> String으로 변경
//		opr1 = new Integer(temp);
//		System.out.println((char)inputData);
		
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		String temp = "";
		
		
//		while(true) {
		for(int i = 0; i < 5; i++) {
			// 첫번째 숫자 입력
			System.out.println("첫번째 숫자를 입력하세요: ");
			temp = br.readLine();
			opr1 = new Integer(temp);
			
			// 연산자 입력
			System.out.println("연산자를 입력하세요: ");
			op = br.readLine();
			
			// 두번째 숫자 입력
			System.out.println("두번째 숫자를 입력하세요: ");
			temp = br.readLine();
			opr2 = new Integer(temp);
			
		// 3. 연산자를 비교(+, -, *, /) 해서 해당 연산자와 동일(==) 하면 
//		if (op == '+') {
//			// 해당 연산을 수행해서 결과값에 저장
//			result = opr1 + opr2; 
//		} else if (op == '-') {
//			result = opr1 - opr2;
//		} else if (op == '*') {
//			result = opr1 * opr2;
//		} else if (op == '/') {
//			result = opr1 / opr2;
//		}
		
		// char -> String 변경 시 '' -> "" 로 변경
//		if (op == "+") {
//			// 해당 연산을 수행해서 결과값에 저장
//			result = opr1 + opr2; 
//		} else if (op == "-") {
//			result = opr1 - opr2;
//		} else if (op == "*") {
//			result = opr1 * opr2;
//		} else if (op == "/") {
//			result = opr1 / opr2;
//		}
		
		// 조건이 4개 이상이면 switch가 더 빠름
		// 조건들 각각이 일어날 확률이 비슷하면 switch, 확률이 비슷하지 않으면 if 가 좋음
		// switch에 좋은 예 = 계산기 프로젝트, if에 좋은 예 = grade 프로젝트
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
		
			// 삼항 연산자
			// String은 객체이기 때문에 == 연산자 안먹음(char는 가능), 객체 비교는 equals()
			result = (op.equals("+")) ? opr1 + opr2:
						(op.equals("-")) ? opr1 - opr2:
						(op.equals( "*")) ? opr1 * opr2:
						(op.equals("/")) ? opr1 / opr2:
						result;
			
			// 4. 결과값을 출력
			System.out.println(opr1 + op + opr2 + "=" + result);
			
			if (result == 0) {
				break;
			}
		
		// System.out.println(opr1 + op + opr2 + "=" + result); 시 결과 233=190으로 나옴
		// byte, short, char -> int 호환 타입
		// op가 int 값으로 바껴서 연산이 되서 op를 char 로 할 때 조심해야함
		// 그래서 java에선 char 잘안씀 -> String 사용으로 해결 가능
		
		// System.out.println("" + opr1 + op + opr2 + "=" + result);
		// 문자열에 숫자 연산을 해서 문자로 나옴 -> 좋은 방법 아님 
		
		}
	}
}
