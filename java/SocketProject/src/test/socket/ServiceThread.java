package test.socket;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketAddress;
import java.util.ArrayList;

public class ServiceThread extends Thread {
	private Socket service;
	private ServerSocket server;
	private InputStream in;
	private OutputStream out;
	private ArrayList<Socket> clientList;
	private ArrayList<InputStream> inList;
	private ArrayList<OutputStream> outList;

	public void run()
	{
		
		SocketAddress remote = service.getRemoteSocketAddress();	// ip 주소 나옴
		System.out.println("client connected...[" + remote + "]");
		//4. 3번.getInputStream()
		//5. 3번.getOutputStream()
		try {
			in = service.getInputStream();
			out = service.getOutputStream();
			inList.add(in);//		clientList.add(in);
			outList.add(out);//		clientList.add(in);
			clientList.add(service);//		clientList.add(in);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String request=" ";
		while(!request.trim().equals("1")) {	// trim : 공백제거
			//6. 4번.read()를 통해 request데이터를 받기
			byte[] buffer = new byte[1024];
			try {
				in.read(buffer);
				request = new String(buffer);
				System.out.println(remote+">" + new String(buffer).trim());
				//7. response 데이터를 만들기
				String response = request;
				//8. 5번.write()를 통해 7번 데이터 전송

				for (OutputStream o : outList) {
					o.write(response.getBytes());		// write하다가 exception 발생하면 this 스레드 죽음 -> catch로 잡기 때문에 스레드 안죽음
					o.flush();
				}
			} catch (IOException e) {		// 좀비 스레드 만들어지는거 방지, 갑작스럽게 연결이 끊기면 좀비 스레드 생김(재접속해도 포트 다르기 때문에 다른 클라이언트로 인식)
				// TODO Auto-generated catch block
//				e.printStackTrace();
				outList.remove(out);
				break;
			}
		}
		inList.remove(in);		// 내가 속해 있는 list에서 빠져나옴
		outList.remove(out);
		clientList.remove(service);
		try {
			in.close();out.close();service.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public ServiceThread(Socket service, ArrayList<Socket> clientList, ArrayList<InputStream> inList,
			ArrayList<OutputStream> outList) {
		super();
		this.service = service;
		this.clientList = clientList;
		this.inList = inList;
		this.outList = outList;
	}
}
