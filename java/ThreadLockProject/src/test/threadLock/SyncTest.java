package test.threadLock;

public class SyncTest {
    public static void main(String[] args) throws InterruptedException {
    	 // data - SyncStack
    	 // code - Producer implements Runnable / Consumer implements Runnable
    	 // cpu - Thread

		SyncStack stack = new SyncStack();
	
		Producer p1 = new Producer(stack);
		Thread prodT1 = new Thread (p1);
		prodT1.start();
	
		Producer p2 = new Producer(stack);
		Thread prodT2 = new Thread (p2);
		prodT2.start();
	
		Consumer c1 = new Consumer(stack);
		Thread consT1 = new Thread (c1);
		consT1.start();
	
		Consumer c2 = new Consumer(stack);
		Thread consT2 = new Thread (c2);
		consT2.start();
		
		prodT1.join();
		prodT2.join();
		consT1.join();
		consT2.join();
		
		System.out.println("남은 데이터 : " + stack.getBuffer().size());
    }
}
