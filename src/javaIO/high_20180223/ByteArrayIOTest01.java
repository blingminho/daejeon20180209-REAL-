package javaIO.high_20180223;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Arrays;

public class ByteArrayIOTest01 {
	public static void main(String[] args) throws IOException {
		byte[] inSrc = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
		byte[] outSrc = null;
		
		ByteArrayInputStream input = null;
		ByteArrayOutputStream output = null;
		
		input = new ByteArrayInputStream(inSrc);
		output = new ByteArrayOutputStream();
		
		int data;// 읽어온 자료를 저장할 변수
		
		// 입력 스트림의 read()메서드는 더이상 읽어올 자료가 없으면 -1을 반환한다.
		while ((data = input.read()) != -1) {
			output.write(data);// 출력하기
		}
		
		outSrc = output.toByteArray();// 출력된 스트림들을 배열로 변환해서 반환
		
		System.out.println("inSrc : " + Arrays.toString(inSrc));
		System.out.println("outSrc : " + Arrays.toString(outSrc));
		
		input.close();
		output.close();
		
		
		
		
		
	}
}
