package test.socket;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

/**
 * TCP/IP Socket프로그램
 * Client : 
 * 1. Socket 만들기
 * 2. 1번.getOutputStream()
 * 3. 1번.getInputStream()
 * 4. request 데이터를 만들기
 * 5. 2번.write()를 통해 4번 데이터 전송
 * 6. 3번.read()를 통해 result데이터를 받기
 * 7. 5번 ~ 6번 반복
 * 8. 2,3번을 닫는다.
 * 9. 1번을 닫는다.
 * 
 * @author Anyware
 *
 */
public class TestSocket {

	public static void main(String[] args) throws UnknownHostException, IOException {
		//1. Socket 만들기
		String ip = "192.168.1.83"; //localhost
		int port = 5000;
//		ip = "www.naver.com"; port = 80;
		Socket client = new Socket(ip, port);
		 //2. 1번.getOutputStream()
		 //3. 1번.getInputStream()
		OutputStream out = client.getOutputStream();
		InputStream in = client.getInputStream();
		 //4. request 데이터를 만들기
		String request = "23";
		Scanner inClient = new Scanner(System.in);
		 //5. 2번.write()를 통해 4번 데이터 전송.
		 //6. 3번.read()를 통해 result데이터를 받기
		while (true) {
			System.out.print("대화입력>");
			request = inClient.next();
			out.write(request.getBytes());
			byte[] buffer = new byte[1024];
			try {
				in.read(buffer );
				System.out.println(new String(buffer));
				if(request.trim().equals("1")) break;
			} catch (Exception e) {
				e.printStackTrace();
				break;
			}
		}
		 // 7. 5번 ~ 6번 반복
		 //8. 2,3번을 닫는다.
		in.close();
		out.close();
		 //9. 1번을 닫는다.
		 client.close();
		 
	}
}
