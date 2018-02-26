package javaIO.high_20180226;

import java.io.FileReader;
import java.io.IOException;

public class FileReaderTest {

	public static void main(String[] args) {
		FileReader fr = null;
		
		try {
			// 문자 단위의 입력을 담당하는 Reader형 객체 생성
			fr = new FileReader("d:/javaIO/test.txt");
			
			int c;
			
			while((c=fr.read())!=-1){
				System.out.print((char)c);
			}
			fr.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
