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
 * 1. ServerSocket�� �����.(port)
 * 2. 1��.accept(); //���� ����...
 * 3. 2���� Socket�� return type����...
 * 4. 3��.getInputStream()
 * 5. 3��.getOutputStream()
 * 6. 4��.read()�� ���� request�����͸� �ޱ�
 * 7. response �����͸� �����
 * 8. 5��.write()�� ���� 7�� ������ ����
 * 9. 6�� ~ 8�� �ݺ�
 * 10. 4,5���� �ݴ´�.
 * 11. 3���� �ݴ´�.
 * 12. 1���� �ݴ´�.
 * 
 * @author Anyware
 *
 */
public class TestServerSocket {

	static int port = 5000;
	public static ServerSocket server; 
	public static void main(String[] args) throws IOException {
		//1. ServerSocket�� �����.(port)

		InputStream in;
		Socket service;
		boolean isAlived = true;
		ArrayList<ServiceThread> threadList = new ArrayList();
		ArrayList<Socket> clientList = new ArrayList();//*
		ArrayList<InputStream> inList = new ArrayList();
		ArrayList<OutputStream> outList = new ArrayList(); //* <E, K, V, T,...> : Generic type
		server = new ServerSocket(port ); 
		System.out.println("���� ���� �Ϸ� : " + port);

		while (isAlived) {		// port�� service ��û�� �ޱ� ���ؼ� ���ѷ��� ����
			service = server.accept(); 
			ServiceThread thread = new ServiceThread(service, clientList, inList, outList);
			thread.start();
			threadList.add(thread);
		}
		// 9. 6�� ~ 8�� �ݺ�
		//10. 4,5���� �ݴ´�.
		for (InputStream inClient : inList) {
			inClient.close();
		}
		for (OutputStream outClient : outList) {
			outClient.close();
		}
		//11. 3���� �ݴ´�.
		for (Socket client : clientList) {
			client.close();
		}
		//12. 1���� �ݴ´�.
		 server.close();
		System.out.println("Server shutdown!");
	}

}
