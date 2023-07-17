package test.thread;

import java.util.Iterator;

/**
 * Thread Program
 * (process 구성 요소)
 * 1. data - Object
 * 2. code - run()  - Runnable
 * 3. cpu - thread - Thread
 * 
 * 1-1. int count; -> class Counter
 * 2-1. count++; -> class Counter::inc() 함수 생성
 * 3-1. new Thread;
 * 
 * 
 * @author user04
 *
 */
public class TestThread {

	public static void main(String[] args) throws InterruptedException {
		Counter data = new Counter();
		Runnable code = new Runner(data); 	// Counter 안에 inc()를 실행하기 위해 monitor 전달
		Thread cpu1 = new Thread(code);		// cpu 입장에서 보면 code는 내가 실행해야할 목적, target
		Thread cpu2 = new Thread(code);
		Thread cpu3 = new Thread(code);
		cpu1.start();		// start() 메소드 호출하면 자동으로 run() 메소드 호출함
		cpu2.start();
		cpu3.start();
		cpu1.join();		// 스레드가 종료 될 때까지 기다림(run() 끝날 때까지 기다림)
		cpu2.join();
		cpu3.join();
//		Thread.yield();		// 같은 우선순위의 쓰레드한테 cpu를 양보한다. (cpu를 놓긴 놨지만 잽싸게 줄을 섰는데 내 자식보다 먼저 서게 되는 경우 0이 나옴)
		Thread.sleep(50);
		System.out.println(Thread.currentThread() + "::" + data.count);
	}

}

class Counter{	// 하나의 자바 파일에는 하나의 public class 만 가질 수 있음
	// 1-1. int count; -> class Counter
	int count;
	
	// 2-1. count++; -> class Counter::inc() 함수 생성
	void inc() {
		count++;
	}
}

class Runner implements Runnable {	
	Counter monitor;
	
	public Runner(Counter monitor) {
		this.monitor = monitor;
	}
	
	@Override
	public void run() {
		int i = 0;
		for (; i < 100000000; i++) {
			monitor.inc();
		}
//		System.out.println(Thread.currentThread() + "::" + monitor.count);
		System.out.println(Thread.currentThread() + ":inc()횟수=" + i + ":결과=" + monitor.count);
	}
}

// 0이 나오는 이유?
// main thread start 시작 시키고 print 출력하고 다했다고 죽음
// 나머지 cpu thread가 남아서 inc() 동작 시키고 있는거임

// main과 cpu thread 는 독립적인 thread 로 돌림
// 그래서 main 독립적으로 실행하고 죽음


