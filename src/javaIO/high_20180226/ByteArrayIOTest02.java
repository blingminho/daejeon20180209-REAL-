package javaIO.high_20180226;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Arrays;

public class ByteArrayIOTest02 {
	public static void main(String[] args) {
		byte[] inSrc = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
		byte[] outSrc = null;
		
		byte[] temp = new byte[4];
		
		ByteArrayInputStream input = new ByteArrayInputStream(inSrc);
		ByteArrayOutputStream output = new ByteArrayOutputStream();
		
		// 배열을 이용한 자료 읽기
		// input.read(temp); : read(byte[] tt)
		
		try {
			// input.available(); : inputStream에서 읽어올 수 있는 byte수 반환
			while (input.available() > 0) {
				input.read(temp);
				output.write(temp);
			}
		} catch (IOException e) {
			
		}
		
		outSrc = output.toByteArray();
		
		System.out.println(" inSrc = " + Arrays.toString(inSrc));
		System.out.println("outSrc = " + Arrays.toString(outSrc));
		
	}
}
