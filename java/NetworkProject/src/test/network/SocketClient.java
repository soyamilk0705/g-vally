package test.network;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * Socket Client Application
 * 1. Socket�� �����.(ip, port)
 * 2. 1�� getOutputStream()		// in-out in-out �Ȱ��� ������ ����� ��� �ȵ� in-out out-in �̷� ������ �ٲ����
 * 3. 1�� getInputStream()
 * 4. response �����͸� �����
 * 5. 2��.write()�� ���� ��û ������ ����
 * 6. 5��.read()�� ���� response �����͸� �ޱ�
 * 7. 2, 3���� �ݴ´�.
 * 8. 1���� �ݴ´�.
 * 
 * @author user04
 *
 */
public class SocketClient {
	
	public SocketClient() throws UnknownHostException, IOException {
		super();
		String host = "localhost";	// ip�� ����ص� �� 127.0.0.1, 192.168.1.83, IP Ȯ�� > window-cmd-"ipconfig /all";
		int port = 7777;
		// 1. Socket�� �����.(ip, port)
		Socket socket = new Socket(host, port);
		
		// 2. 1�� getOutputStream()		// in-out in-out �Ȱ��� ������ ����� ��� �ȵ� in-out out-in �̷� ������ �ٲ����
		OutputStream out = socket.getOutputStream();
	
		// 3. 1�� getInputStream()
		InputStream in = socket.getInputStream();
	
		// 4. response �����͸� �����
		String requestData = "�ȳ��ϼ���....!";		// host ���� �ϰ� ���� ���� �� requestData �� ȭ�鿡 ��µ�
		byte[] buffer = requestData.getBytes();
	
		// 5. 2��.write()�� ���� ��û ������ ����
		out.write(buffer);
		
		// 6. 5��.read()�� ���� response �����͸� �ޱ�
		buffer = new byte[1024];
		in.read(buffer);
		System.out.println(new String(buffer));
		
		// 7. 2, 3���� �ݴ´�.
		out.close();
		in.close();
		
		// 8. 1���� �ݴ´�.
		socket.close();
	}
}
