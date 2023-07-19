package test.socket;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketAddress;
import java.net.SocketImpl;
import java.util.ArrayList;

/**
 * Socket Server Application
 * 1. ServerSocket을 만든다.(port)
 * 2. 1번.accept(); //서버 가동...
 * 3. 2번은 Socket을 return type으로...
 * 4. 3번.getInputStream()
 * 5. 3번.getOutputStream()
 * 6. 4번.read()를 통해 request데이터를 받기
 * 7. response 데이터를 만들기
 * 8. 5번.write()를 통해 7번 데이터 전송
 * 9. 6번 ~ 8번 반복
 * 10. 4,5번을 닫는다.
 * 11. 3번을 닫는다.
 * 12. 1번을 닫는다.
 * 
 * @author Anyware
 *
 */
public class TestServerSocket {

	static int port = 5000;
	public static ServerSocket server; 
	public static void main(String[] args) throws IOException {
		//1. ServerSocket을 만든다.(port)

		InputStream in;
		Socket service;
		boolean isAlived = true;
		ArrayList<ServiceThread> threadList = new ArrayList();
		ArrayList<Socket> clientList = new ArrayList();//*
		ArrayList<InputStream> inList = new ArrayList();
		ArrayList<OutputStream> outList = new ArrayList(); //* <E, K, V, T,...> : Generic type
		server = new ServerSocket(port ); 
		System.out.println("서버 가동 완료 : " + port);

		while (isAlived) {		
			service = server.accept(); 
			ServiceThread thread = new ServiceThread(service, clientList, inList, outList);
			thread.start();
			threadList.add(thread);
		}
		 // 9. 6번 ~ 8번 반복
		 //10. 4,5번을 닫는다.
		for (InputStream inClient : inList) {
			inClient.close();
		}
		for (OutputStream outClient : outList) {
			outClient.close();
		}
		 //11. 3번을 닫는다.
		for (Socket client : clientList) {
			client.close();
		}
		//12. 1번을 닫는다.
		 server.close();
		System.out.println("Server shutdown!");
	}

}
