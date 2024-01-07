package test.calc;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class TestFileIO {

	public static void main(String[] args) throws IOException {	// IOException : input, output 관련된 exception
		// Throwable(Error, Exception) 
		// -> try(ex. br.readLine())-catch(Exception e){e.printStackTrace();} or throws Exception
		// Error : 해결할 수 없는 오류 vs Exception : 해결할 수 있는 오류
		// TODO Auto-generated method stub	
		/*
		 * 과제 : 사용자 입력 데이터를 파일로 저장하기
		 * 1. FileOutputStream을 사용하여, 바탕화면에 result.txt 저장(사용자입력 데이터를) : C:\\Users\\user04\\Desktop\\result.txt
		 * 2. FileInputStream을 사용하여 C:\\Users\\user04\\Desktop\\result.txt 파일을 읽어서 화면에 출력하기
		 * 
		 */
		
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		
		System.out.println("제목을 입력하세요.");
		String subject = br.readLine();
		
		System.out.println("내용을 입력하세요: ");
		String content = br.readLine();
		
		System.out.println(subject + "\n" + content);

		// 1. FileOutputStream을 사용하여, 바탕화면에 result.txt 저장(사용자입력 데이터를) : C:\\Users\\user04\\Desktop\\result.txt
		String file = "C:\\Users\\user04\\Desktop\\result.txt";
		FileOutputStream fos = new FileOutputStream(file);
		
		byte[] bSubject = subject.getBytes();
		fos.write(bSubject);
		byte[] bContent = content.getBytes();
		fos.write(bContent);
		
		
		// 2. FileInputStream을 사용하여 C:\\Users\\user04\\Desktop\\result.txt 파일을 읽어서 화면에 출력하기
		FileInputStream fis = new FileInputStream(file);
		
		fis.read(bSubject);
		subject = new String(bSubject);
		fis.read(bContent);
		content = new String(bContent);
		
		System.out.println(subject + "\n" + content);
		
//		int i = 0;
//			      
//		while((i = fis.read()) != -1) {
//			System.out.print((char) i);
//		}
//	       
//		fis.close();

	}

}
