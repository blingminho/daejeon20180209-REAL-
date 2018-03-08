package javaIO.high_20180226;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class BufferedIOTest2 {

	// 문자 기반의 Buffered스트림 예제
	public static void main(String[] args) {
		try {
			// 이클립스에서 만든 자바프로그램이 실행되는 기본 위치는
			// 프로젝트 폴더가 기본 위치가 된다.		
			
			FileReader fr = new FileReader("./src/javaIO/high_20180226/ByteArrayIOTest2.java");
			BufferedReader br = new BufferedReader(fr);
			
			String temp = "";
			
			// 문자기반의 Buffered스트림에서 줄 단위로 자료를 읽어 온다.
			// (readLine()메서드 이용 ==> null값을 읽어오면 끝까지 읽었다는 의미이다.)
			for(int i=1; (temp=br.readLine())!=null; i++){
				System.out.printf("%4d : %s\n", i, temp);
			}
			
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
