package test.socket;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

/**
 * TCP/IP Socket���α׷�
 * Client : 
 * 1. Socket �����
 * 2. 1��.getOutputStream()
 * 3. 1��.getInputStream()
 * 4. request �����͸� �����
 * 5. 2��.write()�� ���� 4�� ������ ����
 * 6. 3��.read()�� ���� result�����͸� �ޱ�
 * 7. 5�� ~ 6�� �ݺ�
 * 8. 2,3���� �ݴ´�.
 * 9. 1���� �ݴ´�.
 * 
 * @author Anyware
 *
 */
public class TestSocket {

	public static void main(String[] args) throws UnknownHostException, IOException {
		//1. Socket �����
		String ip = "192.168.1.83"; //localhost
		int port = 5000;
//		ip = "www.naver.com"; port = 80;
		Socket client = new Socket(ip, port);
		//2. 1��.getOutputStream()
		//3. 1��.getInputStream()
		OutputStream out = client.getOutputStream();
		InputStream in = client.getInputStream();
		//4. request �����͸� �����
		String request = "23";
		Scanner inClient = new Scanner(System.in);
		//5. 2��.write()�� ���� 4�� ������ ����.
		//6. 3��.read()�� ���� result�����͸� �ޱ�
		while (true) {
			System.out.print("��ȭ�Է�>");
			request = inClient.next();
			out.write(request.getBytes());
			byte[] buffer = new byte[1024];
			try {
				in.read(buffer);
				System.out.println(new String(buffer));
				if(request.trim().equals("1")) break;
			} catch (Exception e) {
				e.printStackTrace();
				break;
			}
		}
		// 7. 5�� ~ 6�� �ݺ�
		//8. 2,3���� �ݴ´�.	
		in.close();
		out.close();
		//9. 1���� �ݴ´�.
		 client.close();
		 
	}
}
