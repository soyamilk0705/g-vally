package test.threadLock;

import java.util.Vector;

public class SyncStack {

    private Vector buffer = new Vector(400, 200);	// ������ ũ��(400) �뷮���� �ʱ�ȭ �� Vector ��ü�� �����ϰ� 
    																		// �뷮 �ʰ� �� capacityIncrement(200) ��ŭ ������Ų��
    
    public synchronized char pop() {	
		char c;
	
		// wait ���� ���ϰ� �ϸ� Consumer���� Exception�� �߻�, Consumer ������ �׾ Producer�� �����
		if (buffer.size() == 0) {
		    try {
		    	this.wait();	// ������
		    } catch (InterruptedException e) {
		    	// ignore it...
		    	e.printStackTrace();
		    }
		}
	 
		// stack �޸��̱� ������ �� ���������� ����(remove : ���� ������ ����)
		c = ((Character)buffer.remove(buffer.size()-1)).charValue();
		return c;
    }

    public Vector getBuffer() {
		return buffer;
	}


	public synchronized void push(char c) {
		this.notify();		
		buffer.addElement(c);
    }
	
	// pop �Ϸ����ϴµ� size() �� 0 �̸� �����·� �ٲٰ� �ٸ� ������ ����
	// �� pop �̸� �� �����·� wait()
	// push �߻� �ϸ� notify()�� ������ ������ ����
}
