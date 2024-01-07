package test.network;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 * Socket Server Application
 * 1. ServerSocket�� �����.(port)
 * 2. 1��.accept();	// ���� ����...
 * 3. 2���� Socket�� return type����...	// ������ �����ϸ� Socket return ��
 * 4. 3��.getInputStream()
 * 5. 3��.getOutputStream()
 * 6. 4��.read()�� ���� request �����͸� �ޱ�
 * 7. response �����͸� �����
 * 8. 5��.write()�� ���� 7�� ������ ����
 * 9. 6��~8�� �ݺ�
 * 10. 4, 5�� �ݴ´�.
 * 11. 3�� �ݴ´�.
 * 12. 1�� �ݴ´�.
 *
 * ���� ������ ���ѷ����� ���ư��� ������ ���� �ʿ� ����
 * ���� ���˰��� ��쿣 ���� ���� ����
 * @author user04
 *
 */
public class TestSocketServer {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		// 1. ServerSocket�� �����.(port)
		int port = 7777;		// port�� 0~65535 ������ �� �� ���� (�� �� ~1023�� �����ڿ� ��Ʈ, �Ϲ� ����� ��� �Ұ�)
		ServerSocket server = null;
		try {
			server = new ServerSocket(port);
		} catch(IOException e) {	
			e.printStackTrace();
			try { // ���� ���� ���� error�� ��Ʈ �浹��
				server = new ServerSocket(++port);
			} catch(IOException e1) {
				System.out.println(port  + "�� ����� �� �����ϴ�. ������� �� �ֽ��ϴ�. ��밡���� ��Ʈ�� Ȯ���ϼ���.");
				System.exit(-2);	// ��/���ۻ簡 ���ϴ� �ڵ� �� : ��Ʈ �浹
			}
		}
		
		System.out.println("��Ĺ������ ��Ʈ " + port + "������ �������Դϴ�.");
		
		while (true) {
			Socket service = null;
			 // 2. 1��.accept();	// ���� ����...
			 // 3. 2���� Socket�� return type����...	// ������ �����ϸ� Socket return ��
			try {
				// 1�� 2�� �� �� �Ȱ��� exception ���� ������ ��ĥ �� ������ ���� ��ġ�� ��� ���� ���� Ȯ�� ����
				service = server.accept();
				System.out.println("Ŭ���̾�Ʈ�� ���ӵǾ����ϴ�. ::" + service.getInetAddress());
			} catch(IOException e) {
				e.printStackTrace();
				// Ŭ���̾�Ʈ�� ���� �ҷ�, ���� �ð� ���� �ݺ��Ǵ� ������� ������ �簡���Ѵ�.
			}
			
			 // 4. 3��.getInputStream()
			 // 5. 3��.getOutputStream()
			InputStream in = service.getInputStream();
			OutputStream out = service.getOutputStream();
			
			// TODO ����
			// : readLine() �� ���� �Լ��� ��ȯ�� ��
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
			
			 // 6. 4��.read()�� ���� request �����͸� �ޱ�
			String requestData = "";
			if(in.read(buffer) != -1) {
				requestData = new String(buffer);
			}
			System.out.println("Client>" + requestData);		// ���������� ���������� ������ �޽���, ����(�ڱⰡ �̷� �ֶ�� ����)
			 // 7. response �����͸� �����
			String responseData = "Server>" + requestData;
			
			 // 8. 5��.write()�� ���� 7�� ������ ����
			buffer = responseData.getBytes();
			out.write(buffer);
			out.flush();		// stream �ȿ� �����ִ� �����Ͱ� ������ �����͸� ���������� �� ����(���� auto-flush ����� �� ������ �׷��� �ѹ����°� ����)
//									// outputStream�� flush �� close �ϴ°� ������
			
			 // 9. 6��~8�� �ݺ�
			 // 10. 4, 5�� �ݴ´�.
			in.close();
			out.close();
			
			 // 11. 3�� �ݴ´�.
			service.close();
			
			if(requestData.equals("end")) {
				break;
			}
		}
		 // 12. 1�� �ݴ´�.
		server.close();  // server�� ���� �ʴ´�.
		
		
	}

}
