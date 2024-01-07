package test.scanner;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class MyClient {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BufferedReader in = null;
		PrintWriter out = null;
		
		Socket socket = null;
		Scanner scanner = new Scanner(System.in);
		
		try {
			socket = new Socket("localhost", 8000);
			
			in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			out = new PrintWriter(socket.getOutputStream());
			
			while(true) {
				System.out.println("전송하기>>> ");
				String outputMessage = scanner.nextLine();
				out.println(outputMessage);
				out.flush();
				if ("quit".equalsIgnoreCase(outputMessage)) break;
				
				String inputMessage = in.readLine();
				System.out.println("From Server: " + inputMessage);
				if ("quit".equalsIgnoreCase(outputMessage)) break;
			}
		} catch(IOException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				scanner.close();
				if (socket != null) socket.close();
				System.out.println("서버연결종료");
			} catch(IOException e) {
				System.out.println("소켓통신에러");
			}
		}
	}

}
