package test.data;

public class TestData {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int i = 111111111;
		long j = 1111111111111L;
		
		System.out.println(12);
		System.out.println(012);				// 8진수
		System.out.println(0xA3);				// 16진수
		System.out.println(0x80000000);
		System.out.println(5 % 3);			// 나머지
		System.out.println(-5 % 3);			
		System.out.println(0x80000001 << 2);	// shift 연산자(<<, >>, >>>)
		System.out.println(0x80000001 << 1024);
		System.out.println(0xFFFFFFFF);
		System.out.println(0xFFFFFFFF >> 30);
		System.out.println(0xFFFFFFFF >>> 30);
		
		char c = 'a';
		System.out.println(c);
		System.out.println((int) c);
		System.out.println('\141');
		System.out.println('\u0061');
		System.out.println(++c);
		
//		int m = 0;
//		System.out.println(3 / m);
		
		System.out.println(1.2345678901234567890123456789);
		System.out.println(2e3);
		System.out.println(0.1+1.6);
		System.out.println(3.0 / 0.0);
		System.out.println(0.0 / 0.0);
		
		int k = 0;
//		System.out.println(++k);
//		System.out.println(k++);
		System.out.println((++k != 0) && (100 / k++ > 10));
		System.out.println("k = " + k);
		System.out.println((k != 0) && (100 / k > 10));		// (100 / k > 10) 이부분은 실행되지 않음
		System.out.println((k == 0) || (100 / k <= 10));	// true
		System.out.println((k == 0) ? 100 : 100 / k);
		System.out.println((1 == 1) ^ (k == 2));
//		System.out.println((k != 0) & (100 / k > 2));
		System.out.println((k == 0) | (100 / k <= 10));
		
		
		int n = 0;
		int l, m;
		l = 0;
		m = 1;
		System.out.println(n + ":" + l + ":" + m);
		
		// 삼항 연산자
		int a = 10;
		int b = 20;
		System.out.println(a>b ? "맞다" : "아니다");
		System.out.println(a<b ? a : b);
		System.out.println(a==b ? a*20 : b*2);
	}
}


