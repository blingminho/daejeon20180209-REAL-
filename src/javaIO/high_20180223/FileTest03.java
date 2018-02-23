package javaIO.high_20180223;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class FileTest03 {
	public static void main(String[] args) {
		File testFile = new File("D:\\공유폴더");
		displayFileList(testFile);
	}
	
	// 지정된 디렉토리(폴더)에 포함된 파일과 디렉토리 목록을 보여주는 메서드
	public static void displayFileList(File dir) {
		System.out.println("[" + dir.getAbsolutePath() + "] 디렉토리 내용");
		
		File[] files = dir.listFiles();// 디렉토리 안의 파일 목록 읽기
		
		// 위의 File배열에서 디렉토리가 저장된 인덱스 번호를 저장할 list
		ArrayList<Integer> subList = new ArrayList<Integer>();
		
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm a");
		
		for (int i = 0; i < files.length; i++) {
			String name = files[i].getName();
			String attr = "";// 속성(읽기, 쓰기, 히든, 디렉토리 구분)을 저장할 변수
			String size = "";// 파일 용량
			
			if (files[i].isDirectory()) {
				attr = "<DIR>";
				subList.add(i);
			}else {
				size = files[i].length() + "";
				attr += files[i].canRead() ? "R" : " ";
				attr += files[i].canWrite() ? "W" : " ";
				attr += files[i].isHidden() ? "H" : " ";
			}
			
			System.out.printf("%s %5s %12s %s\n",
					df.format(new Date(files[i].lastModified())),
					attr, size, name
					);
			
		}
		
		int dirNum = subList.size();// 이 폴더 안에 있는 디렉토리 개수 구하기
		int fileNum = files.length - dirNum;// 파일의 개수 구하기
		
		System.out.println(fileNum + "개의 파일, " + dirNum + "개의 디렉토리");
		System.out.println("==============================================================");
		
		for (int i = 0; i < subList.size(); i++) {
			displayFileList(files[subList.get(i)]);// 재귀 호출
		}
		
		
	}
	
	
}
