package test.threadLock;

public class Producer implements Runnable {
    private SyncStack theStack;
    private int num;
    private static int counter = 1;

    public Producer (SyncStack s) {
		theStack = s;
		num = counter++;
    }

    public void run() {
		char c;
	
		for (int i = 0; i < 200; i++) {
		    c = (char)(Math.random() * 26 +'A');		// �빮�� A~Z ���� �������� ����
		    theStack.push(c);
		    System.out.println("Producer" +num+ ": " +c);
		    try {
		    	Thread.sleep((int)(Math.random() * 300));	// 300 = 0.3��
		    } catch (InterruptedException e) {
		    	// ignore it
		    }
		}
    }
} 
