package javaIO.high_20180223;

import java.io.File;

public class FileTest02 {
	public static void main(String[] args) {
		File f1 = new File("D:\\C_Lib\\ibatis\\ojdbc6.jar");
//		File f1 = new File("D:\\C_Lib\\ibatis\\ojd.jar");
		File f2 = new File("D:\\javaIO\\연습용2");
		
		if (f1.exists()) {// 해당 파일 또는 디렉토리가 있으면 true
			System.out.println(f1.getPath() + "은 존재합니다");
		}else {
			System.out.println(f1.getAbsolutePath() + "은 없습니다");
		}
		System.out.println();
		
		
		if (f2.exists()) {
			System.out.println(f2.getName() + "은 ");
			if (f2.isDirectory()) {
				System.out.println("디렉토리(폴더) 입니다");
			}else if (f2.isFile()) {
				System.out.println("파일 입니다");
			}
		}else {
			if (f2.mkdir()) {
				System.out.println(f2.getName() + "디렉토리 만들기 성공!!");
			}else {
				System.out.println(f2.getName() + "디렉토리 만들기 실패~~");
			}
		}
		System.out.println();
		
		System.out.println(f1.getName() + "의 크기 : " + f1.length() + "bytes");
		
		
	}
}
