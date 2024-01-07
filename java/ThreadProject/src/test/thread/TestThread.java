package test.thread;

import java.util.Iterator;

/**
 * Thread Program
 * (process ���� ���)
 * 1. data - Object
 * 2. code - run()  - Runnable
 * 3. cpu - thread - Thread
 * 
 * 1-1. int count; -> class Counter
 * 2-1. count++; -> class Counter::inc() �Լ� ����
 * 3-1. new Thread;
 * 
 * @author user04
 *
 */
public class TestThread {

	public static void main(String[] args) throws InterruptedException {
		Counter data = new Counter();
		Runnable code = new Runner(data); 	// Counter �ȿ� inc()�� �����ϱ� ���� monitor ����
		Thread cpu1 = new Thread(code);		// cpu ���忡�� ���� code�� ���� �����ؾ��� ����, target -> Runnable
		Thread cpu2 = new Thread(code);
		Thread cpu3 = new Thread(code);
		cpu1.start();		// start() �޼ҵ� ȣ���ϸ� �ڵ����� run() �޼ҵ� ȣ����
		cpu2.start();
		cpu3.start();
		cpu1.join();		// �����尡 ���� �� ������ ��ٸ�(run() ���� ������ ��ٸ�) / ������ ������(ä�������尡 ����� ������ �������� ����:Non-Runnable)
		cpu2.join();
		cpu3.join();
//		Thread.yield();		// ���� �켱������ ���������� cpu�� �纸�Ѵ�. (cpu�� ���� ������ ��ΰ� ���� ���µ� �� �ڽĺ��� ���� ���� �Ǵ� ��� 0�� ����)
//		Thread.sleep(50);		// ���� �켱������ ���������� cpu�� �纸�Ѵ�.
		System.out.println(Thread.currentThread() + "::" + data.count);
	}
	// main thread : static void main�� Ÿ������ ���� ������
}

/**
 * Data class : �����ڿ�(monitor : Thread�� � �������� �� �� �ִ� ������ ���)
 * @author user04
 *
 */
class Counter{	// �ϳ��� �ڹ� ���Ͽ��� �ϳ��� public class �� ���� �� ����
	// 1-1. int count; -> class Counter
	int count;
	
	// 2-1. count++; -> class Counter::inc() �Լ� ����
	// synchronized ���1.		
//	void inc() {
//		synchronized (this) {
//			count++;
//		}
//	}
	
	// synchronized ���2.
	synchronized void inc() {		
		count++;
	}

	// synchronized : �� �����尡 �� ������ �����Ͽ� ����� �� lock�� �ɸ����ν� �ٸ� �����尡 ���� �� �� ����
	//							�ش� �����尡 �� ���� �� ����ԵǸ� unlock ���°� �Ǿ� �׶����� ����ϰ� �ִ� �ٸ� �����尡 ������ �ٽ� lock �ɰ� ���
	// ����� : ���� �� ���¿��� �����尡 �׾������ ��� �߻� -> �׷��� main�� run() �ȿ��� �ϴ°� ���� monitor���� ���� ��(������� ������)
}

/**
 * Target class : Runnable ���(public void run() ����)
 * ���� �������� ��ü(main)
 * @author user04
 *
 */
class Runner implements Runnable {	
	Counter monitor;
	
	public Runner(Counter monitor) {
		this.monitor = monitor;
	}
	
	@Override
	public void run() {
		int i = 0;
		for (; i < 10000; i++) {
			monitor.inc();
		}
//		System.out.println(Thread.currentThread() + "::" + monitor.count);
		System.out.println(Thread.currentThread() + ":inc()Ƚ��=" + i + ":���=" + monitor.count);
	}
}

// main thread�� ���� ������ ����?
// main thread start ���� ��Ű�� print ����ϰ� ���ߴٰ� ����
// ������ cpu thread�� ���Ƽ� inc() ���� ��Ű�� �ִ°���
// -> join() ����ϸ� ���� �ذ��

// main�� cpu thread �� �������� thread �� ����
// �׷��� main ���������� �����ϰ� ����


