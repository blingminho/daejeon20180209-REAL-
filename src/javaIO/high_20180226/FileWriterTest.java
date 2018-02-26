package javaIO.high_20180226;

import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class FileWriterTest {

	public static void main(String[] args) {
		// 사용자가 입력한 내용을 그대로 파일에 저장하기
		
		// 콘솔(표준 입출력장치)과 연결된 입력 문자 스트림 생성
		InputStreamReader isr = new InputStreamReader(System.in);
		
		FileWriter fw = null;
		
		try {
			// 파일 출력용 문자 스트림 객체 생성
			fw = new FileWriter("d:/javaIO/testChar.txt");
			
			int c;
			System.out.println("아무거나 입력하세요");
			
			// 콘솔에서 입력할 때 입력의 끝 표시는 'Ctrl + Z' 키를 누르면 된다.
			while((c=isr.read()) != -1){
				fw.write(c);  // 콘솔에서 입력받은 값들을 파일에 출력한다.
			}
			
			isr.close();
			fw.close();
		} catch (IOException e) {		}

	}
}


	
	
	
	
	
	
	
	
