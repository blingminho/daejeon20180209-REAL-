package javaIO.high_20180226;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class BufferedIOTest1 {

	public static void main(String[] args) {
		// 입출력의 성능 향상을 위해 Buffered스트림을 이용한다.
		
		FileOutputStream fout = null;
		BufferedOutputStream bout = null;
		
		try {
			// 출력용 파일 스트림 객체 생성
			fout = new FileOutputStream("d:/javaIO/bufferTest.txt");
			
			// 크기가 5인 버퍼 스트림 객체 생성
			// 버퍼의 크기를 지정하지 않으면 기본크기가 8192byte(8KB)가 된다.
			bout = new BufferedOutputStream(fout, 5);
			
			for(char i='1'; i<='9'; i++){
				bout.write(i);
			}
			bout.flush();  // 버퍼에 남아있는 모든 데이터를 출력한다.
						   // 작업을 종료하기 전에 버퍼에 남아 있는 데이터는
						   // 모두 출력해야 한다.
			
			bout.close();
			
			System.out.println("작업 끝.");
			
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
