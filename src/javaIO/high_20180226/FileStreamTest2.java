package javaIO.high_20180226;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileStreamTest2 {

	public static void main(String[] args) {
		// 바이트 기반의 스트림을 이용한 파일 입출력 
		
		FileInputStream fin = null;
		FileOutputStream fout = null;
		
		try {
			// 출력용 OutputStream객체 생성
			fout = new FileOutputStream("d:/javaIO/out.txt");
			
			for(char ch= 'a'; ch<='z'; ch++){
				fout.write(ch);   // FileStream으로 출력하기
			}
			
			System.out.println("출력 끝...");
			fout.close();  // 쓰기 작업 완료 후 스트림 닫기
			
			// =======================================
			
			// 저장된 파일 내용을 읽어와 확인하기
			fin = new FileInputStream("d:/javaIO/out.txt");
			
			int c ;
			
			System.out.println();
			System.out.println("읽어온 내용");
			
			while((c=fin.read())!=-1){
				System.out.print((char)c);
			}
			
			fin.close();
			
			
			
			
		} catch (IOException e) {
			// TODO: handle exception
		}
		

	}

}











