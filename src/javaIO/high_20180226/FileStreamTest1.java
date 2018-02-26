package javaIO.high_20180226;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class FileStreamTest1 {

	public static void main(String[] args) {
		// FileInputStream객체를 이용한 파일 내용 읽기
		FileInputStream fin = null;
		
		try {
			// 파일과 연결된 바이트 기반의 스트림 객체 생성하기
			// 방법1 --> 파일명을 문자열로 지정하기
			//fin = new FileInputStream("d:/javaIO/test.txt");
			
			// 방법2 --> 파일명을 File객체로 지정하기
			File file = new File("d:/javaIO/test.txt");
			fin = new FileInputStream(file);
			
			int c;  // 읽어온 데이터를 저장할 변수
			
			// 읽어온 값이 -1이면 파일의 끝까지 읽었다는 의미이다.
			while( (c = fin.read()) != -1 ){
				System.out.print((char)c);
			}
			
			fin.close();  // 작업 완료 후 스트림 닫기
			
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}









