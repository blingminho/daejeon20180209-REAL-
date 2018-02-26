package javaIO.high_20180226;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class DataIOStreamTest {

	public static void main(String[] args) {
		try {
			FileOutputStream fout = new FileOutputStream("d:/javaIO/test.dat");
			
			// DataOutputStream은 출력용 데이터를 자료형에 맞게 출력해 준다.
			DataOutputStream dout = new DataOutputStream(fout);
			
			dout.writeInt(200);			// 정수형으로 데이터 출력
			dout.writeFloat(131.4f);	// 실수형으로 출력
			dout.writeBoolean(false);	// 논리형으로 출력
			dout.writeUTF("안녕하세요.");// 문자열 출력
			
			System.out.println("출력 완료...");
			
			dout.close();  // 스트림 닫기.
			
			//=============================================
			
			// 출력한 자료 읽어오기
			FileInputStream fin = new FileInputStream("d:/javaIO/test.dat");
			DataInputStream din = new DataInputStream(fin);
			
			System.out.println("정수형 자료 : " + din.readInt());
			System.out.println("실수형 자료 : " + din.readFloat());
			System.out.println("논리형 자료 : " + din.readBoolean());
			System.out.println("문자열 자료 : " + din.readUTF());
			
			din.close();
			
		} catch (IOException e) {
			// TODO: handle exception
		}

	}

}






