package test.network;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * Socket Client Application
 * 1. Socket을 만든다.(ip, port)
 * 2. 1번 getOutputStream()		// in-out in-out 똑같은 순서로 만들면 통신 안됨 in-out out-in 이런 순서로 바꿔야함
 * 3. 1번 getInputStream()
 * 4. response 데이터를 만들기
 * 5. 2번.write()를 통해 요청 데이터 전송
 * 6. 5번.read()를 통해 response 데이터를 받기
 * 7. 2, 3번을 닫는다.
 * 8. 1번을 닫는다.
 * 
 * @author user04
 *
 */
public class SocketClient {
	
	public SocketClient() throws UnknownHostException, IOException {
		super();
		String host = "localhost";	// ip를 사용해도 됨 127.0.0.1, 192.168.1.83, IP 확인 > window-cmd-"ipconfig /all";
		int port = 7777;
		// 1. Socket을 만든다.(ip, port)
		Socket socket = new Socket(host, port);
		
		// 2. 1번 getOutputStream()		// in-out in-out 똑같은 순서로 만들면 통신 안됨 in-out out-in 이런 순서로 바꿔야함
		OutputStream out = socket.getOutputStream();
	
		// 3. 1번 getInputStream()
		InputStream in = socket.getInputStream();
	
		// 4. response 데이터를 만들기
		String requestData = "안녕하세요....!";		// host 변경 하고 접속 했을 시 requestData 값 화면에 출력됨
		byte[] buffer = requestData.getBytes();
	
		// 5. 2번.write()를 통해 요청 데이터 전송
		out.write(buffer);
		
		// 6. 5번.read()를 통해 response 데이터를 받기
		buffer = new byte[1024];
		in.read(buffer);
		System.out.println(new String(buffer));
		
		// 7. 2, 3번을 닫는다.
		out.close();
		in.close();
		
		// 8. 1번을 닫는다.
		socket.close();
	}
}
