package javaIO.high_20180226;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class FileStreamTest3 {
	// 한글이 저장된 파일 읽어오기
	// (한글의 인코딩을 지정해서 읽어오기)
	
	public static void main(String[] args) {
		FileInputStream fin = null;
		
		// Byte기반의 스트림을 문자기반의 스트림으로 변환해 준다.
		InputStreamReader isr = null;  
		
		try {
			/*
			FileInputStream객체를 생성한 후 이 객체를 매개값으로 하는 
			InputStreamReader객체를 생성한다. 
			*/
			//fin = new FileInputStream("d:/javaIO/test_ansi.txt");
			fin = new FileInputStream("d:/javaIO/test_utf8.txt");
			
			/*
			InputStreamReader객체는 인코딩 방식을 지정할 수 있다.
				인코딩 지정문자는 다음과 같다.
				- MS949  ==> 윈도우의 기본 한글 인코딩 방식 (ANSI)
				- UTF-8	 ==> 유니코드 UTF-8 인코딩 방식
				- US-ASCII ==> 영문 전용 인코딩 방식 
			*/
			//isr = new InputStreamReader(fin);
			isr = new InputStreamReader(fin, "UTF-8");
			//isr = new InputStreamReader(fin, "MS949");
			
			int c;
			while((c=isr.read())!=-1){
				System.out.print((char)c);
			}
			
			isr.close();  // 보조스트림을 닫으면 보조스트림의 기반이 되는 
						  // 스트림도 같이 닫힌다.
			
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}








