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
 * @author user04
 *
 */
public class TestThread {

	public static void main(String[] args) throws InterruptedException {
		Counter data = new Counter();
		Runnable code = new Runner(data); 	// Counter 안에 inc()를 실행하기 위해 monitor 전달
		Thread cpu1 = new Thread(code);		// cpu 입장에서 보면 code는 내가 실행해야할 목적, target -> Runnable
		Thread cpu2 = new Thread(code);
		Thread cpu3 = new Thread(code);
		cpu1.start();		// start() 메소드 호출하면 자동으로 run() 메소드 호출함
		cpu2.start();
		cpu3.start();
		cpu1.join();		// 스레드가 종료 될 때까지 기다림(run() 끝날 때까지 기다림) / 빚쟁이 쓰리드(채무쓰레드가 종료될 때까지 실행하지 않음:Non-Runnable)
		cpu2.join();
		cpu3.join();
//		Thread.yield();		// 같은 우선순위의 쓰레드한테 cpu를 양보한다. (cpu를 놓긴 놨지만 잽싸게 줄을 섰는데 내 자식보다 먼저 서게 되는 경우 0이 나옴)
//		Thread.sleep(50);		// 낮은 우선순위의 쓰레드한테 cpu를 양보한다.
		System.out.println(Thread.currentThread() + "::" + data.count);
	}
	// main thread : static void main을 타켓으로 갖는 스레드
}

/**
 * Data class : 공유자원(monitor : Thread가 어떤 상태인지 알 수 있는 유일한 방법)
 * @author user04
 *
 */
class Counter{	// 하나의 자바 파일에는 하나의 public class 만 가질 수 있음
	// 1-1. int count; -> class Counter
	int count;
	
	// 2-1. count++; -> class Counter::inc() 함수 생성
	// synchronized 방법1.		
//	void inc() {
//		synchronized (this) {
//			count++;
//		}
//	}
	
	// synchronized 방법2.
	synchronized void inc() {		
		count++;
	}

	// synchronized : 한 스레드가 이 영역에 접근하여 사용할 때 lock이 걸림으로써 다른 스레드가 접근 할 수 없음
	//							해당 스레드가 다 실행 후 벗어나게되면 unlock 상태가 되어 그때서야 대기하고 있던 다른 스레드가 접근해 다시 lock 걸고 사용
	// 데드락 : 락을 건 상태에서 스레드가 죽어버리는 경우 발생 -> 그래서 main과 run() 안에선 하는게 없고 monitor에서 일을 함(스레드는 잘죽음)
}

/**
 * Target class : Runnable 상속(public void run() 구현)
 * 실제 쓰레드의 몸체(main)
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
		System.out.println(Thread.currentThread() + ":inc()횟수=" + i + ":결과=" + monitor.count);
	}
}

// main thread가 먼저 끝나는 이유?
// main thread start 시작 시키고 print 출력하고 다했다고 죽음
// 나머지 cpu thread가 남아서 inc() 동작 시키고 있는거임
// -> join() 사용하면 문제 해결됨

// main과 cpu thread 는 독립적인 thread 로 돌림
// 그래서 main 독립적으로 실행하고 죽음


