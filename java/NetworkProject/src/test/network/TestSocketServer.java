package test.network;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 * Socket Server Application
 * 1. ServerSocket을 만든다.(port)
 * 2. 1번.accept();	// 서버 가동...
 * 3. 2번은 Socket을 return type으로...	// 누군가 접속하면 Socket return 됨
 * 4. 3번.getInputStream()
 * 5. 3번.getOutputStream()
 * 6. 4번.read()를 통해 request 데이터를 받기
 * 7. response 데이터를 만들기
 * 8. 5번.write()를 통해 7번 데이터 전송
 * 9. 6번~8번 반복
 * 10. 4, 5번 닫는다.
 * 11. 3번 닫는다.
 * 12. 1번 닫는다.
 *
 * 서버 소켓은 무한루프로 돌아가기 때문에 닫을 필요 없음
 * 서버 점검같은 경우엔 서버 소켓 닫음
 * @author user04
 *
 */
public class TestSocketServer {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		// 1. ServerSocket을 만든다.(port)
		int port = 7777;		// port는 0~65535 번까지 쓸 수 있음 (그 중 ~1023은 관리자용 포트, 일반 사용자 사용 불가)
		ServerSocket server = null;
		try {
			server = new ServerSocket(port);
		} catch(IOException e) {	
			e.printStackTrace();
			try { // 가장 자주 나는 error는 포트 충돌임
				server = new ServerSocket(++port);
			} catch(IOException e1) {
				System.out.println(port  + "를 사용할 수 없습니다. 사용중일 수 있습니다. 사용가능한 포트를 확인하세요.");
				System.exit(-2);	// 고객/제작사가 정하는 코드 값 : 포트 충돌
			}
		}
		
		System.out.println("소캣서버가 포트 " + port + "번에서 가동중입니다.");
		
		while (true) {
			Socket service = null;
			 // 2. 1번.accept();	// 서버 가동...
			 // 3. 2번은 Socket을 return type으로...	// 누군가 접속하면 Socket return 됨
			try {
				// 1번 2번 둘 다 똑같은 exception 쓰기 때문에 합칠 수 있지만 둘을 합치면 어디서 에러 난지 확인 힘듦
				service = server.accept();
				System.out.println("클라이언트가 접속되었습니다. ::" + service.getInetAddress());
			} catch(IOException e) {
				e.printStackTrace();
				// 클라이언트의 접속 불량, 일정 시간 내에 반복되는 문제라면 서버를 재가동한다.
			}
			
			 // 4. 3번.getInputStream()
			 // 5. 3번.getOutputStream()
			InputStream in = service.getInputStream();
			OutputStream out = service.getOutputStream();
			
			// TODO 과제
			// : readLine() 등 편리한 함수로 변환할 것
//			byte[] buffer = new byte[1024];
//			String requestData = "";
//			if(in.read(buffer) != -1) {
//				requestData = new String(buffer);
//			}
//			System.out.println("Client>" + requestData);
//			Scanner scan = new Scanner(System.in);
//			requestData = scan.nextLine();
//			String responseData = "Server>" + requestData;
//			out.write(responseData.getBytes());
//			out.flush();
//			scan.close();	
			
			
			byte[] buffer = new byte[1024];
			
			 // 6. 4번.read()를 통해 request 데이터를 받기
			String requestData = "";
			if(in.read(buffer) != -1) {
				requestData = new String(buffer);
			}
			System.out.println("Client>" + requestData);		// 웹브라우저가 웹서버한테 보내는 메시지, 정보(자기가 이런 애라고 보냄)
			 // 7. response 데이터를 만들기
			String responseData = "Server>" + requestData;
			
			 // 8. 5번.write()를 통해 7번 데이터 전송
			buffer = responseData.getBytes();
			out.write(buffer);
			out.flush();		// stream 안에 남아있는 데이터가 없도록 데이터를 목적지까지 다 보냄(요즘엔 auto-flush 기능이 들어가 있지만 그래도 한번쓰는게 좋음)
//									// outputStream은 flush 후 close 하는게 안전함
			
			 // 9. 6번~8번 반복
			 // 10. 4, 5번 닫는다.
			in.close();
			out.close();
			
			 // 11. 3번 닫는다.
			service.close();
			
			if(requestData.equals("end")) {
				break;
			}
		}
		 // 12. 1번 닫는다.
		server.close();  // server는 죽지 않는다.
		
		
	}

}
