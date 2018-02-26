package javaIO.high_20180226;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/*
	'd:/javaIO/Tulips.jpg'파일을
	'd:/javaIO/복사본Tulips.jpg'파일로 복사하는 프로그램을 작성하시오.
*/

public class FileCopyTest {

	public static void main(String[] args) {
		try {
			// 복사할 파일 스트림 객체 생성
			FileInputStream fin = new FileInputStream("d:/javaIO/Tulips.jpg");
			
			// 버퍼 스트림을 이용하여 입출력 효율을 향상 시켜 보자.
			// 버퍼의 크기를 지정하지 않으면 기본 크기가 8192byte가 된다.
			BufferedInputStream bis = new BufferedInputStream(fin);
			
			
			
			// 복사될 파일 스트림 객체 생성
			FileOutputStream fout = new FileOutputStream("d:/javaIO/복사본Tulips.jpg");
			BufferedOutputStream bout = new BufferedOutputStream(fout);
			
			
			
			int c;
			/*
			while(( c = fin.read()) != -1){
				fout.write(c);
			}
			*/
			
			while(( c = bis.read()) != -1){
				bout.write(c);
			}
			bout.flush();
			
			
			System.out.println("복사 완료..");
			
			bis.close();
			bout.close();
			
			//fin.close();
			//fout.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}












