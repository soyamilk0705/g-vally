package test.scanner;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class MyServer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BufferedReader in = null;
		PrintWriter out = null;
		
		ServerSocket serverSocket = null;
		Socket socket = null;
		Scanner scanner = new Scanner(System.in);
		
		try {
			serverSocket = new ServerSocket(8000);
			
			System.out.println("[Server ����] Client ���� �����...");
			socket = serverSocket.accept();
		
			System.out.println("Client �����.");
			in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			out = new PrintWriter(socket.getOutputStream());
			
			while(true) {
				String inputMessage = in.readLine();
				if("quit".equalsIgnoreCase(inputMessage)) break;
				
				System.out.println("From Client: " + inputMessage);
				System.out.println("�����ϱ�>>> ");
				
				String outputMessage = scanner.nextLine();
				out.println(outputMessage);
				out.flush();
				if("quit".equalsIgnoreCase(outputMessage)) break;
			}
		} catch(IOException e) {
			e.printStackTrace();
		} finally {
			try {
				scanner.close();
				socket.close();
				serverSocket.close();
				System.out.println("��������");
			} catch(IOException e) {
				System.out.println("������ſ���");
			}
		}
	}

}
