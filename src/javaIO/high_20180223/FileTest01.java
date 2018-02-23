package javaIO.high_20180223;

import java.io.File;

public class FileTest01 {
	/*
	 * File 객체 만들기 연습
	 * 
	 * File객체 : 파일 또는 디렉토리(폴더)를 관리하는 객체
	 * 				지정한 파일이나 디렉토리는 현재 디스크에 존재하지 않을 수 도 있다
	 */
	public static void main(String[] args) {
		/*
		 * 1. new File(String 파일 또는 경로);
		 * 디렉토리와 디렉토리 사이 또는 디렉토리와 파일명 사이의 구분 문자는
		 * 역슬래쉬(\) 를 사용하거나 슬래쉬(/)를 사용할 수 있다
		 * 주의할점 : 역슬래쉬는 두개 쓴다
		 */
		File file = new File("D:\\javaIO\\test.txt");
		System.out.println(file.getName() + "은 ");
		if (file.isFile()) {
			System.out.println("파일 입니다.");
		}else if(file.isDirectory()) {
			System.out.println("디렉토리(폴더) 입니다.");
		}
		System.out.println();
		
		File file2 = new File("D:\\javaIO");
		System.out.println(file2.getName() + "은 ");
		if (file2.isFile()) {
			System.out.println("파일 입니다.");
		}else if(file2.isDirectory()) {
			System.out.println("디렉토리(폴더) 입니다.");
		}
		System.out.println();
		
		
		/*
		 * 2. new File(File parent, String child);
		 * 'parent' 디렉토리 안에 있는 'child'파일을 갖는 객체 생성
		 */
		File file3 = new File(file2, "test.txt");
		System.out.println(file3.getName() + "은 ");
		if (file3.isFile()) {
			System.out.println("파일 입니다.");
		}else if(file3.isDirectory()) {
			System.out.println("디렉토리(폴더) 입니다.");
		}
		System.out.println();
		
		
		/*
		 * 3. new File(String parent, String child);
		 */
		File file4 = new File("d:\\javaIO", "test.txt");
		System.out.println(file4.getName() + "은 ");
		if (file4.isFile()) {
			System.out.println("파일 입니다.");
		}else if(file4.isDirectory()) {
			System.out.println("디렉토리(폴더) 입니다.");
		}
		System.out.println();
		
		
		// ==============================================================================
		
		/*
		 *  - 디렉토리(폴더) 만들기
		 * 1. mkdir()
		 * 		> File객체의 경로 중 마지막 위치에 지정한 디렉토리를 만든다
		 * 		> 전체 경로 중 중간의 경로에 지정한 디렉토리들은 모두 만들어져 있어야 한다
		 * 
		 * 2. mkdirs()
		 * 		> File객체의 경로 중 마지막 위치에 지정한 디렉토리를 만든다
		 * 		> 중간의 경로가 없으면 중간의 경로도 새롭게 만든 후 마지막 위치의 경로를 만들어 준다.
		 */
		File file5 = new File("d:\\javaIO\\연습용");
		if (file5.mkdir()) {// 만들기 성공하면 true
			System.out.println(file5.getName() + "만들기 성공!");
		}else{
			System.out.println(file5.getName() + "만들기 실패...");
		}
		System.out.println();
		
		File file6 = new File("d:\\javaIO\\test\\ java\\src");
		if (file6.mkdirs()) {// 만들기 성공하면 true
			System.out.println(file6.getName() + "만들기 성공!");
		}else{
			System.out.println(file6.getName() + "만들기 실패...");
		}
		System.out.println();
		
		
		
		
		
		
		
		
		
		
	}
}
