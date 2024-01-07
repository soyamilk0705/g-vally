package test.threadLock;

import java.util.Vector;

public class SyncStack {

    private Vector buffer = new Vector(400, 200);	// 지정한 크기(400) 용량으로 초기화 된 Vector 객체를 생성하고 
    																		// 용량 초과 시 capacityIncrement(200) 만큼 증가시킨다
    
    public synchronized char pop() {	
		char c;
	
		// wait 실행 못하게 하면 Consumer에서 Exception이 발생, Consumer 스레드 죽어서 Producer만 실행됨
		if (buffer.size() == 0) {
		    try {
		    	this.wait();	// 대기상태
		    } catch (InterruptedException e) {
		    	// ignore it...
		    	e.printStackTrace();
		    }
		}
	 
		// stack 메모리이기 때문에 맨 마지막값을 지움(remove : 원본 데이터 삭제)
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
	
	// pop 하려고하는데 size() 가 0 이면 대기상태로 바꾸고 다른 스레드 실행
	// 또 pop 이면 또 대기상태로 wait()
	// push 발생 하면 notify()로 대기상태 스레드 깨움
}
