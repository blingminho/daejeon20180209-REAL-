package javaIO.high_20180226;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Arrays;

public class ByteArrayIOTest2 {

	public static void main(String[] args) {
		byte[] inSrc = {0,1,2,3,4,5,6,7,8,9};
		byte[] outSrc = null;
		
		byte[] temp = new byte[4];
		
		ByteArrayInputStream input = new ByteArrayInputStream(inSrc);
		ByteArrayOutputStream output = new ByteArrayOutputStream();
		
		// 배열을 이용한 자료 읽기
		// read(byte[] tt)
		
		try {
			// input.available() ==> inputStream에서 읽어올 수 있는 byte수 반환
			while(input.available()>0){
				//input.read(temp);
				//output.write(temp);
				
				int len = input.read(temp); // 실제 읽어온 byte수 반환
				
				// temp배열에 있는 자료 중에서 0번째부터 읽어온 개수(len)만큼 출력
				output.write(temp, 0, len);
				
				
				System.out.println("반복문 안에서 temp = " + Arrays.toString(temp));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		System.out.println();
		outSrc = output.toByteArray();
		
		System.out.println(" inSrc = " + Arrays.toString(inSrc));
		System.out.println("outSrc = " + Arrays.toString(outSrc));

	}

}









