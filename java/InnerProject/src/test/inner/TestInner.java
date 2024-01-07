package test.inner;

public class TestInner {
	public static void main(String args[]) {
		Test test = new Test();
		Test.Inner in = test.new Inner();
		in.print();
		System.out.println(in.j);
	}
}

class Test{
	int i = 1;
	static int si = 1;
	
	// 내부(Inner) 클래스
	class Inner{
		int j = 3;
		void print() {
			System.out.println(i);
			System.out.println(j);
		}
	}
}

