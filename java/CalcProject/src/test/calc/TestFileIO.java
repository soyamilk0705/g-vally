package test.calc;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class TestFileIO {

	public static void main(String[] args) throws IOException {	// IOException : input, output ���õ� exception
		// Throwable(Error, Exception) 
		// -> try(ex. br.readLine())-catch(Exception e){e.printStackTrace();} or throws Exception
		// Error : �ذ��� �� ���� ���� vs Exception : �ذ��� �� �ִ� ����
		// TODO Auto-generated method stub	
		/*
		 * ���� : ����� �Է� �����͸� ���Ϸ� �����ϱ�
		 * 1. FileOutputStream�� ����Ͽ�, ����ȭ�鿡 result.txt ����(������Է� �����͸�) : C:\\Users\\user04\\Desktop\\result.txt
		 * 2. FileInputStream�� ����Ͽ� C:\\Users\\user04\\Desktop\\result.txt ������ �о ȭ�鿡 ����ϱ�
		 * 
		 */
		
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		
		System.out.println("������ �Է��ϼ���.");
		String subject = br.readLine();
		
		System.out.println("������ �Է��ϼ���: ");
		String content = br.readLine();
		
		System.out.println(subject + "\n" + content);

		// 1. FileOutputStream�� ����Ͽ�, ����ȭ�鿡 result.txt ����(������Է� �����͸�) : C:\\Users\\user04\\Desktop\\result.txt
		String file = "C:\\Users\\user04\\Desktop\\result.txt";
		FileOutputStream fos = new FileOutputStream(file);
		
		byte[] bSubject = subject.getBytes();
		fos.write(bSubject);
		byte[] bContent = content.getBytes();
		fos.write(bContent);
		
		
		// 2. FileInputStream�� ����Ͽ� C:\\Users\\user04\\Desktop\\result.txt ������ �о ȭ�鿡 ����ϱ�
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
